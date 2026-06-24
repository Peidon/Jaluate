package org.xpd.core;

public interface Operator<R> {
    R execute(Object... args);
}
