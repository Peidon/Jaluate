package org.xpd.core;

import org.xpd.operator.Operator;
import java.util.Map;

public class Constant {

    private Constant() {}

    public static final int ArgumentsLengthLimit = 4;
    private static boolean initialized = false;
    private static Map<String, Operator<?>> functions;

    public synchronized static void initFunctions(Map<String, ? extends Operator<?>> userFunctions) {
        if (initialized) {
            throw new IllegalStateException("functions already initialized");
        }
        functions = Map.copyOf(userFunctions);
        initialized = true;
    }

    public static Map<String, Operator<?>> getFunctions() {
        return functions;
    }
}
