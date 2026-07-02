package org.xpd.errors;

public class UnknownPrimitiveTypeError extends RuntimeException {
    public UnknownPrimitiveTypeError(String message) {
        super(String.format("Unknown primitive type: %s", message));
    }
}
