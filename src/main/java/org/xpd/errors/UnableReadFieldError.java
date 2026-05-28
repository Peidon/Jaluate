package org.xpd.errors;

public class UnableReadFieldError extends RuntimeException {
    public UnableReadFieldError(String name, Object object) {
        super(String.format("Unable to read field %s from %s", name, object.getClass().getName()));
    }
}
