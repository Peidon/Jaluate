package org.xpd.operator;

import java.util.Map;

public interface Operator<R> {
    R execute(Object... args);
}
