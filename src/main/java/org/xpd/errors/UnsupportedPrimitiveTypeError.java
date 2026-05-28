package org.xpd.errors;

public class UnsupportedPrimitiveTypeError extends RuntimeException {
    public UnsupportedPrimitiveTypeError(String target) {
        super(String.format("unsupported primitive type: %s", target));
    }
}
