package org.xpd.operator;

import org.xpd.type.PrimitiveType;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Factory {

    public Operator<?> createOperator(Symbol symbol, Map<String, Object> params) {
        return switch (symbol) {
            case NOOP -> null;
            case VALUE -> this.makeValue(params);
            case LITERAL -> this.makeLiteral();
            case EQ -> this.makeEquals();
            case NEQ -> this.makeNotEquals();
            case GT -> this.makeGreaterThan();
            case LT -> this.makeLessThan();
            case GTE -> this.makeGreaterThanOrEqualTo();
            case LTE -> this.makeLessThanOrEqualTo();
            case AND -> this.makeAnd();
            case OR -> this.makeOr();
            case PLUS -> this.makePlus();
            case MINUS -> this.makeMinus();
            case MULTIPLY -> this.makeMultiply();
            case DIVIDE -> this.makeDivide();
            case MODULUS -> this.makeModulus();
            case NEGATE -> this.makeNegate();
            case INVERT -> this.makeNot();
            case INDEX -> null;
            case FUNCTIONAL -> null;
            case ACCESS -> null;
        };
    }

    Operator<Object> makeValue(Map<String, Object> params) {
        Function<String, Object> fn = params::get;
        return new FunctionalOperator<>(fn);
    }

    Operator<Object> makeLiteral() {
        BiFunction<String, PrimitiveType, Object> fn = (literal, primitiveType) -> switch (primitiveType) {
            case None -> null;
            case Boolean -> Boolean.parseBoolean(literal);
            case Integer -> Integer.parseInt(literal);
            case String -> literal;
            case Number ->  Double.parseDouble(literal);
        };
        return new FunctionalOperator<>(fn);
    }

    Operator<Boolean> makeEquals() {
        return new FunctionalOperator<>(Object::equals);
    }

    Operator<Boolean> makeNotEquals() {
        BiFunction<Number, Number, Boolean> fn = (a, b) -> !a.equals(b);
        return new FunctionalOperator<>(fn);
    }

    Operator<Boolean> makeGreaterThan() {
        BiFunction<Number, Number, Boolean> fn = (a, b) -> a.doubleValue() > b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    Operator<Boolean> makeGreaterThanOrEqualTo() {
        BiFunction<Number, Number, Boolean> fn = (a, b) -> a.doubleValue() >= b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    Operator<Boolean> makeLessThan() {
        BiFunction<Number, Number, Boolean> fn = (a, b) -> a.doubleValue() < b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    Operator<Boolean> makeLessThanOrEqualTo() {
        BiFunction<Number, Number, Boolean> fn = (a, b) -> a.doubleValue() <= b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    Operator<Boolean> makeAnd() {
        BiFunction<Boolean, Boolean, Boolean> fn = (a, b) -> a && b;
        return new FunctionalOperator<>(fn);
    }

    Operator<Boolean> makeOr() {
        BiFunction<Boolean, Boolean, Boolean> fn = (a, b) -> a || b;
        return new FunctionalOperator<>(fn);
    }

    Operator<Boolean> makeNot() {
        Function<Boolean, Boolean> fn = a -> !a;
        return new FunctionalOperator<>(fn);
    }

    Operator<Number> makeNegate() {
        Function<Number, Number> fn = a -> -a.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    Operator<Number> makePlus() {
        BiFunction<Number, Number, Number> fn = (a, b) -> a.doubleValue() + b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    Operator<Number> makeMinus() {
        BiFunction<Number, Number, Number> fn = (a, b) -> a.doubleValue() - b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    Operator<Number> makeMultiply() {
        BiFunction<Number, Number, Number> fn = (a, b) -> a.doubleValue() * b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    Operator<Number> makeDivide() {
        BiFunction<Number, Number, Number> fn = (a, b) -> a.doubleValue() / b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    Operator<Number> makeModulus() {
        BiFunction<Number, Number, Number> fn = (a, b) -> a.doubleValue() % b.doubleValue();
        return new FunctionalOperator<>(fn);
    }
}
