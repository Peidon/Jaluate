package org.xpd.errors;

public class NullOperatorException extends RuntimeException {
    public NullOperatorException(String message) {
        super(String.format("no operator defined for %s", message));
    }
}
