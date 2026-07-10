package org.xpd.errors;

public class FieldNotExistsError extends RuntimeException {
    public FieldNotExistsError(String fieldName) {
        super(String.format("field not exists type error: %s", fieldName));
    }
}
