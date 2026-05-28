package org.xpd.errors;

import org.xpd.core.Constant;

public class ArgumentsLengthError extends RuntimeException {

    public ArgumentsLengthError(Integer target, Integer current) {
        super(String.format("Arguments length error: target=%d, current=%d", target, current));
    }

    public ArgumentsLengthError(Integer current) {
        super(String.format("Arguments length error: limit=%d, current=%d", Constant.ArgumentsLengthLimit, current));
    }
}
