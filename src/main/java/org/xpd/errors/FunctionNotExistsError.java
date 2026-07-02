package org.xpd.errors;

public class FunctionNotExistsError extends RuntimeException {
    public FunctionNotExistsError(String fnName) {
        super(String.format("function %s not exists", fnName));
    }
}
