package org.xpd.core;

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

    public static String stripChar(String text, char target) {
        int start = 0;
        int end = text.length();

        if (start < end && text.charAt(start) == target) {
            start++;
        }
        if (end > start && text.charAt(end - 1) == target) {
            end--;
        }
        return text.substring(start, end);
    }
}
