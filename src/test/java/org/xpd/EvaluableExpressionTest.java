package org.xpd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EvaluableExpressionTest {
    @Test
    public void evaluate() {
        EvaluableExpression expr = new EvaluableExpression("null");
        var result = expr.Eval();
        assertNull(result);

        expr = new EvaluableExpression("a+b+c");
        Map<String, Object> params = new HashMap<>();
        params.put("a", 1);
        params.put("b", 2);
        params.put("c", 3.0);
        result = expr.Eval(params);
        assertEquals(6.0, result);
    }
}
