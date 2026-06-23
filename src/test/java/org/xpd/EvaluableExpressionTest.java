package org.xpd;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xpd.core.Constant;
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
        var functions = Map.of("timestamp", new FunctionalOperator<>(System::currentTimeMillis));
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
