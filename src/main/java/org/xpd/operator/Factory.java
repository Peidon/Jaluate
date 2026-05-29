package org.xpd.operator;

import org.xpd.errors.FunctionNotExistsError;
import org.xpd.type.PrimitiveType;
import org.xpd.type.Value;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Factory {

    private final Map<String, Operator<Object>> operators;

    public Factory(Map<String, Operator<Object>> operators) {
        this.operators = operators;
    }

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
            case INDEX -> this.makeIndex();
            case FUNCTIONAL -> this.makeFunction(operators);
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

    Operator<Integer> makeIndex() {
        Function<Object, Integer> fn =  a -> {
            var v = new Value<>(a);
            return v.getInt();
        };
        return new FunctionalOperator<>(fn);
    }

    Operator<Object> makeFunction(Map<String, Operator<Object>> fns) {
        BiFunction<String, Object[], Object> fn = (fnName, args) -> {
            Operator<Object> f = fns.get(fnName);
            if (f == null) {
                throw new FunctionNotExistsError(fnName);
            }
            return f.execute(args);
        };
        return new FunctionalOperator<>(fn);
    }

    Operator<Object> makeAccess(String fnName, Object... args) {
        return null;
    }
}
