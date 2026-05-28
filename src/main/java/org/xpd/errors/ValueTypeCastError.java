package org.xpd.errors;

public class ValueTypeCastError extends RuntimeException {
    public ValueTypeCastError(String target, Object value) {
        String message;
        if (value == null) {
            message = String.format("Cast to %s failed, original value is null", target);
        } else {
            String cls = value.getClass().getName();
            message = String.format("Cast to %s failed, original value class is %s", target, cls);
        }
        super(message);
    }
}
