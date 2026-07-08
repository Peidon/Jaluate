package org.xpd.errors;

public class FunctionArgTypeError extends RuntimeException {
    public FunctionArgTypeError(String fnName) {
        super(String.format("function argument type error: %s", fnName));
    }
}
