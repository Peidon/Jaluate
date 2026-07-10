package org.xpd;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xpd.core.Constant;
import org.xpd.errors.FieldNotExistsError;
import org.xpd.errors.IndexOutOfBoundsError;
import org.xpd.example.CarShop;
import org.xpd.example.Common;
import org.xpd.operator.FunctionalOperator;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

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
                "len", new FunctionalOperator<>(Common::length),
                "log", new FunctionalOperator<>(Math::log),
                "exp", new FunctionalOperator<>(Math::exp),
                "sqrt", new FunctionalOperator<>(Math::sqrt)
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
        assertEquals("abc123", eval("'abc123'"));
        assertEquals("hello world\n", eval("'''hello world\n'''"));
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
        assertEquals(true, eval("a==b", Map.of("a", 5.0, "b", 5)));
        assertEquals(true, eval("a == 3", Map.of("a", 3)));
        assertEquals(true, eval("a != 2", Map.of("a", 3)));
    }

    @Test
    public void evalCalculatesComparisonExpressionsWithParams() {
        assertEquals(false, eval("(requests_made * requests_succeeded / 100) >= 90",
                Map.of("requests_made", 100,"requests_succeeded", 80)));
    }

    @Test
    public void evalCalculatesLogicalExpressions() {
        assertEquals(true, eval("abc > 2 && ${c} == true", Map.of("abc", 3, "c", true)));
        assertEquals(false, eval("abc > 2 && ${c} == true", Map.of("abc", 3, "c", false)));
        assertEquals(true, eval("abc > 2 || ${c} == true", Map.of("abc", 3, "c", false)));
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
    public void evalReturnsMapValueByKey() {
        var expr = "{'high' : 10, 'width' : 20.0}";
        var obj = eval(expr);
        assertTrue(obj instanceof Map);
        assertEquals(10, ((Map<?, ?>) obj).get("high"));
        assertEquals(20.0, ((Map<?, ?>) obj).get("width"));
    }

    @Test
    public void evalReturnsArrayElementByParameterIndex() {
        assertEquals(2, eval("a[idx]", Map.of("a", new Object[]{1, 2, 3}, "idx", 1)));
        assertThrows(IndexOutOfBoundsError.class, () -> eval("a[4]", Map.of("a", new Object[]{1, 2, 3})));
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
        assertEquals(car.getDriver().getAge(), eval("car.driver.age", Map.of("car", car)));
    }

    @Test
    public void evalAccessesNestedArrayFields() {
        var car = CarShop.get(2);
        assertEquals(car.getWheels()[0].getWeight(), eval("car.wheels[0].weight", Map.of("car", car)));
        assertEquals(car.getWheels()[1].getSize(), eval("car.wheels[1].size", Map.of("car", car)));
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
        assertThrows(FieldNotExistsError.class, () -> eval("shop.feat.color", params));
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
    public void evalMathFunction() {
        assertEquals(2.0, eval("sqrt(4.0)"));
        assertEquals(3.0, eval("log(exp(3.0))"));
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
