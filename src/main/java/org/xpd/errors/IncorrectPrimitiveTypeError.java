package org.xpd.errors;

public class IncorrectPrimitiveTypeError extends RuntimeException {
    public IncorrectPrimitiveTypeError(String message) {
        super(String.format("Incorrect primitive type: %s", message));
    }
}
