package org.xpd.operator;

public interface Operator<R> {
    R execute(Object... args);
}
