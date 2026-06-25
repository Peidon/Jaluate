package org.xpd.example;

import org.xpd.type.Value;

public class Common {
    public static int length(Object obj) {
        return new Value<>(obj).getArray().length;
    }
}
