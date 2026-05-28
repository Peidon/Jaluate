package org.xpd.operator;

/**
 *
 * @param <T> Type of First Argument
 * @param <U> Type of Second Argument
 * @param <V> Type of Third Argument
 * @param <W> Type of Forth Argument
 * @param <R> Return Type
 */
@FunctionalInterface
public interface QuadFunction<T, U, V, W, R> {
    R apply(T t, U u, V v, W w);
}
