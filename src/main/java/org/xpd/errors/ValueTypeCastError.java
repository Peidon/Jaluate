package org.xpd.errors;

public class ValueTypeCastError extends RuntimeException {

    public ValueTypeCastError(String target) {
        super(String.format("Cast to %s failed, original value is null", target));
    }

    public ValueTypeCastError(String target, Object value) {
        super(String.format("Cast to %s failed, original value class is %s", target, value.getClass().getName()));
    }
}
