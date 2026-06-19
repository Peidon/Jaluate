package org.xpd.operator;

import org.xpd.errors.ArgumentsLengthError;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @param <T> Type of First Argument
 * @param <U> Type of Second Argument
 * @param <V> Type of Third Argument
 * @param <W> Type of Forth Argument
 * @param <R> Return Type
 */
public class FunctionalOperator<T, U, V, W, R> implements Operator<R> {

    private Supplier<R> supplier;
    private Function<T, R> unaryFunction;
    private BiFunction<T, U, R> biFunction;
    private TriFunction<T, U, V,R> triFunction;
    private QuadFunction<T, U, V, W, R> quadFunction;
    private final int argumentsLength;

    public FunctionalOperator(Supplier<R> fn) {
        this.supplier = fn;
        this.argumentsLength = 0;
    }

    public FunctionalOperator(Function<T, R> unary) {
        this.unaryFunction = unary;
        this.argumentsLength = 1;
    }

    public FunctionalOperator(BiFunction<T, U, R> bi) {
        this.biFunction = bi;
        this.argumentsLength = 2;
    }

    public FunctionalOperator(TriFunction<T, U, V, R> tri) {
        this.triFunction = tri;
        this.argumentsLength = 3;
    }

    public FunctionalOperator(QuadFunction<T, U, V, W, R> quad) {
        this.quadFunction = quad;
        this.argumentsLength = 4;
    }

    @Override
    public R execute(Object... args) {
        if (args != null && args.length != argumentsLength) {
            throw new ArgumentsLengthError(this.argumentsLength, args.length);
        }
        if (args == null && argumentsLength > 0) {
            throw new ArgumentsLengthError(this.argumentsLength, 0);
        }
        if (args == null || args.length == 0) {
            return supplier.get();
        }
        return switch (args.length) {
            case 1 -> unaryFunction.apply((T)args[0]);
            case 2 -> biFunction.apply((T)args[0], (U)args[1]);
            case 3 -> triFunction.apply((T)args[0], (U)args[1], (V)args[2]);
            case 4 -> quadFunction.apply((T)args[0], (U)args[1], (V)args[2], (W)args[3]);
            default -> throw new ArgumentsLengthError(args.length);
        };
    }
}