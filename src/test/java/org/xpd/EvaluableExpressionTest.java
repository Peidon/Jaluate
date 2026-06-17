package org.xpd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class EvaluableExpressionTest {
    @Test
    public void evaluate() {
        EvaluableExpression expr = new EvaluableExpression("1+2");
        var result = expr.Eval();
        assertEquals(3.0, result);

        expr = new EvaluableExpression("a+b+c");
        Map<String, Object> params = new HashMap<>();
        params.put("a", 1);
        params.put("b", 2);
        params.put("c", 3.0);
        result = expr.Eval(params);
        assertEquals(6.0, result);
    }
}
