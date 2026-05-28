package org.xpd.operator;


/**
 *
 * @param <T> Type of First Argument
 * @param <U> Type of Second Argument
 * @param <B> Type of Third Argument
 * @param <R> Return Type
 */
@FunctionalInterface
public interface TriFunction<T, U, B,  R> {

    R apply(T t, U u, B b);

}
