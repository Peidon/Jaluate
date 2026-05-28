package org.xpd.operator;

import org.junit.Test;
import org.xpd.errors.ArgumentsLengthError;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

public class FunctionalOperatorTest {

    @Test
    public void executeReturnsSupplierValue() {
        Supplier<String> supplier = () -> "ready";
        var operator = new FunctionalOperator<>(supplier);
        assertEquals("ready", operator.execute());
    }

    @Test
    public void executeAppliesUnaryFunction() {
        Function<String, Integer> length = String::length;
        var operator = new FunctionalOperator<>(length);
        assertEquals(Integer.valueOf(5), operator.execute("hello"));
    }

    @Test
    public void executeAppliesBiFunction() {
        var operator = new FunctionalOperator<>(Integer::sum);
        assertEquals(Integer.valueOf(7), operator.execute(3, 4));
    }

    @Test
    public void executeAppliesTriFunction() {
        TriFunction<String, String, String, String> join = (first, second, third) -> first + second + third;
        var operator = new FunctionalOperator<>(join);

        assertEquals("abc", operator.execute("a", "b", "c"));
    }

    @Test
    public void executeAppliesQuadFunction() {
        QuadFunction<Integer, Integer, Integer, Integer, Integer> sum = (first, second, third, fourth) ->
                first + second + third + fourth;
        FunctionalOperator<Integer, Integer, Integer, Integer, Integer> operator = new FunctionalOperator<>(sum);

        assertEquals(Integer.valueOf(10), operator.execute(1, 2, 3, 4));
    }

    @Test(expected = ArgumentsLengthError.class)
    public void executeThrowsWhenArgumentCountIsTooSmall() {
        Function<String, Integer> length = String::length;
        FunctionalOperator<String, Object, Object, Object, Integer> operator = new FunctionalOperator<>(length);

        operator.execute();
    }

    @Test(expected = ArgumentsLengthError.class)
    public void executeThrowsWhenArgumentCountIsTooLarge() {
        var operator = new FunctionalOperator<>(String::length);
        operator.execute("hello", "extra");
    }

    @Test(expected = ArgumentsLengthError.class)
    public void executeThrowsWhenArgumentsAreNullForFunctionWithArguments() {
        var operator = new FunctionalOperator<>(String::length);
        operator.execute((Object[]) null);
    }

    @Test(expected = ClassCastException.class)
    public void executeThrowsWhenArgumentCannotBeCastToFunctionInputType() {
        Function<String, Integer> length = String::length;
        FunctionalOperator<String, Object, Object, Object, Integer> operator = new FunctionalOperator<>(length);

        operator.execute(123);
    }
}
