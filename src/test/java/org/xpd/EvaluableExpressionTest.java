package org.xpd;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xpd.core.Constant;
import org.xpd.example.CarShop;
import org.xpd.example.Common;
import org.xpd.operator.FunctionalOperator;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class EvaluableExpressionTest {

    @BeforeClass
    public static void init() {
        var functions = Map.of(
                "timestamp", new FunctionalOperator<>(System::currentTimeMillis),
                "getModelByID", new FunctionalOperator<>(CarShop::getModelByID),
                "getColorByID", new FunctionalOperator<>(CarShop::getColorByID),
                "carInfoByID", new FunctionalOperator<Integer, Object, Object, Object, Map<String, Object>>(
                        id -> Map.of(
                                "model", CarShop.getModelByID(id),
                                "color", CarShop.getColorByID(id)
                        )
                ),
                "checkModelAndColor", new FunctionalOperator<>(CarShop::checkModelAndColor),
                "len", new FunctionalOperator<>(Common::length)
        );
        Constant.initFunctions(functions);
    }

    @Test
    public void evalReturnsNullLiteral() {
        assertNull(eval("null"));
    }

    @Test
    public void evalReturnsBooleanLiterals() {
        assertEquals(true, eval("true"));
        assertEquals(false, eval("false"));
    }

    @Test
    public void evalReturnsStringLiterals() {
        assertEquals("abc", eval("\"abc\""));
        assertEquals("123", eval("\"123\""));
    }

    @Test
    public void evalCalculatesArithmeticExpressions() {
        assertEquals(3.1, eval("1+2.1"));
        assertEquals(9.0, eval("3 * 3"));
        assertEquals(2.0, eval("4 / 2.0"));
        assertEquals(2.5, eval("5 / 2"));
        assertEquals(1.0, eval("5 % 2"));
    }

    @Test
    public void evalCalculatesUnaryExpressions() {
        assertEquals(true, eval("!a", Map.of("a", false)));
        assertEquals(-1.0, eval("-a", Map.of("a", 1)));
    }

    @Test
    public void evalCalculatesComparisonExpressions() {
        assertEquals(true, eval("5 > 2"));
        assertEquals(false, eval("5 <= 2"));
        assertEquals(true, eval("a == 3", Map.of("a", 3)));
        assertEquals(true, eval("a != 2", Map.of("a", 3)));
    }

    @Test
    public void evalCalculatesLogicalExpressions() {
        assertEquals(true, eval("abc > 2 && ${c} == true", Map.of("abc", 3, "c", true)));
        assertEquals(false, eval("abc > 2 && ${c} == true", Map.of("abc", 3, "c", false)));
    }

    @Test
    public void evalReadsParameters() {
        Map<String, Object> params = new HashMap<>();
        params.put("a", 1);
        params.put("b", 2);
        params.put("c", 3.0);

        assertEquals(6.0, eval("a+b+c", params));
        assertEquals(1.0, eval("abc - 2", Map.of("abc", 3)));
        assertEquals(1.0, eval("${ab.c} - 2.0", Map.of("ab.c", 3)));
    }

    @Test
    public void evalReturnsArrayLiterals() {
        assertArrayEquals(new Object[]{}, (Object[]) eval("[]"));
        assertArrayEquals(new Object[]{1, 2, 3}, (Object[]) eval("[1,2,3]"));
    }

    @Test
    public void evalReturnsArrayElementByLiteralIndex() {
        assertEquals(2, eval("a[1]", Map.of("a", new Object[]{1, 2, 3})));
    }

    @Test
    public void evalReturnsArrayElementByParameterIndex() {
        assertEquals(2, eval("a[idx]", Map.of("a", new Object[]{1, 2, 3}, "idx", 1)));
    }

    @Test
    public void evalAccessesMapFields() {
        assertEquals(3, eval("a.score", Map.of("a", Map.of("score", 3))));
    }

    @Test
    public void evalAccessesClassFields() {
        var car = CarShop.get(1);
        assertTrue((Boolean) eval("car.model==model", Map.of("car", car, "model", car.getModel())));
        assertTrue((Boolean) eval("car.color==color", Map.of("car", car, "color", car.getColor())));
    }

    @Test
    public void evalAccessesNestedClassFields() {
        var car = CarShop.get(1);
        assertEquals(car.getDriver().age(), eval("car.driver.age", Map.of("car", car)));
    }

    @Test
    public void evalAccessesNestedArrayFields() {
        var car = CarShop.get(2);
        assertEquals(car.getWheels()[0].weight(), eval("car.wheels[0].weight", Map.of("car", car)));
        assertEquals(car.getWheels()[1].size(), eval("car.wheels[1].size", Map.of("car", car)));
        assertEquals(car.getWheels().length,  eval("len(car.wheels)", Map.of("car", car)));
    }

    @Test
    public void evalAccessesNestedMapFields() {
        Map<String, Object> params = Map.of(
                "shop", Map.of(
                        "featured", Map.of(
                                "model", "roadster",
                                "color", "orange"
                        )
                )
        );

        assertEquals("roadster", eval("shop.featured.model", params));
        assertEquals("orange", eval("shop.featured.color", params));
    }

    @Test
    public void evalAccessesFunctionResultFields() {
        assertEquals("pickup", eval("carInfoByID(7).model"));
        assertEquals("green", eval("carInfoByID(7).color"));
    }

    @Test
    public void evalCallsNoArgumentFunction() {
        assertTrue((Long) eval("timestamp()") > 0);
    }

    @Test
    public void evalCallsUnaryFunctionWithLiteralArgument() {
        assertEquals("crossover", eval("getModelByID(10)"));
        assertEquals("purple", eval("getColorByID(10)"));
    }

    @Test
    public void evalCallsUnaryFunctionWithParameterArgument() {
        assertEquals("limousine", eval("getModelByID(carId)", Map.of("carId", 11)));
        assertEquals("black", eval("getColorByID(carId)", Map.of("carId", 11)));
    }

    @Test
    public void evalUsesFunctionalOperatorInsideComparison() {
        assertTrue((Boolean) eval("getModelByID(carId) == expected", Map.of(
                "carId", 3,
                "expected", "coupe"
        )));
        assertFalse((Boolean) eval("getColorByID(carId) == expected", Map.of(
                "carId", 3,
                "expected", "white"
        )));
        assertFalse((Boolean) eval("checkModelAndColor(\"pickup\", \"black\") >= 0"));
    }

    @Test
    public void evalComparesNullParameter() {
        assertTrue((Boolean) eval("abc == null", new HashMap<>() {{
            put("abc", null);
        }}));
        assertFalse((Boolean) eval("abc != null", new HashMap<>() {{
            put("abc", null);
        }}));
    }

    private Object eval(String expression) {
        return new EvaluableExpression(expression).Eval();
    }

    private Object eval(String expression, Map<String, Object> params) {
        return new EvaluableExpression(expression).Eval(params);
    }
}
