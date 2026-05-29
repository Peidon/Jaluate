package org.xpd.errors;

public class FunctionNotExistsError extends RuntimeException {
    public FunctionNotExistsError(String fnName) {
        String message = String.format("function %s not exists", fnName);
        super(message);
    }
}
