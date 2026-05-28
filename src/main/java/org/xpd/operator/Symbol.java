package org.xpd.operator;

public enum Symbol {
    NOOP("noop"),
    LITERAL("literal"),
    VALUE("value"),
    EQ("=="),
    NEQ("!="),
    GT(">"),
    LT("<"),
    GTE(">="),
    LTE("<="),
    AND("&&"),
    OR("||"),
    PLUS("+"),
    MINUS("minus -"),
    MULTIPLY("multiply *"),
    DIVIDE("divide /"),
    MODULUS("modulus %"),
    NEGATE("negate -"),
    INVERT("invert !"),
    INDEX("array index []"),
    FUNCTIONAL("functional"),
    ACCESS("access .");

    private final String text;

    Symbol(String text) {
        this.text = text;
    }

    public String getSymbol() {
        return text;
    }
}
