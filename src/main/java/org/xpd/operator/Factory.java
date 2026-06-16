package org.xpd.operator;

import org.xpd.errors.FunctionNotExistsError;
import org.xpd.type.PrimitiveType;
import org.xpd.type.Value;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Factory {

    public Operator<Object> makeValue(Map<String, Object> params) {
        Function<String, Object> fn = params::get;
        return new FunctionalOperator<>(fn);
    }

    public Operator<Object> makeLiteral() {
        BiFunction<String, PrimitiveType, Object> fn = (literal, primitiveType) -> switch (primitiveType) {
            case None -> null;
            case Boolean -> Boolean.parseBoolean(literal);
            case Integer -> Integer.parseInt(literal);
            case String -> literal;
            case Number ->  Double.parseDouble(literal);
        };
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeEquals() {
        return new FunctionalOperator<>(Object::equals);
    }

    public Operator<Boolean> makeNotEquals() {
        BiFunction<Number, Number, Boolean> fn = (a, b) -> !a.equals(b);
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeGreaterThan() {
        BiFunction<Number, Number, Boolean> fn = (a, b) -> a.doubleValue() > b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeGreaterThanOrEqualTo() {
        BiFunction<Number, Number, Boolean> fn = (a, b) -> a.doubleValue() >= b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeLessThan() {
        BiFunction<Number, Number, Boolean> fn = (a, b) -> a.doubleValue() < b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeLessThanOrEqualTo() {
        BiFunction<Number, Number, Boolean> fn = (a, b) -> a.doubleValue() <= b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeAnd() {
        BiFunction<Boolean, Boolean, Boolean> fn = (a, b) -> a && b;
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeOr() {
        BiFunction<Boolean, Boolean, Boolean> fn = (a, b) -> a || b;
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeNot() {
        Function<Boolean, Boolean> fn = a -> !a;
        return new FunctionalOperator<>(fn);
    }

    public Operator<Number> makeNegate() {
        Function<Number, Number> fn = a -> -a.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    public Operator<Number> makePlus() {
        BiFunction<Number, Number, Number> fn = (a, b) -> a.doubleValue() + b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    public Operator<Number> makeMinus() {
        BiFunction<Number, Number, Number> fn = (a, b) -> a.doubleValue() - b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    public Operator<Number> makeMultiply() {
        BiFunction<Number, Number, Number> fn = (a, b) -> a.doubleValue() * b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    public Operator<Number> makeDivide() {
        BiFunction<Number, Number, Number> fn = (a, b) -> a.doubleValue() / b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    public Operator<Number> makeModulus() {
        BiFunction<Number, Number, Number> fn = (a, b) -> a.doubleValue() % b.doubleValue();
        return new FunctionalOperator<>(fn);
    }

    // index : [ expr ]
    public Operator<Integer> makeIndex() {
        Function<Object, Integer> fn =  a -> {
            var v = new Value<>(a);
            return v.getInt();
        };
        return new FunctionalOperator<>(fn);
    }

    // primary_expr [ index ]
    public Operator<Object> makeArrayIndex() {
        BiFunction<Object[], Integer, Object> fn = (arr, idx) -> arr[idx];
        return new FunctionalOperator<>(fn);
    }

    // [expr, ... expr]
    public Operator<Object[]> makeArrayConst() {
        Function<Object, Object[]> fn = (a) -> {
            var v = new Value<>(a);
            return v.getArray();
        };
        return new FunctionalOperator<>(fn);
    }

    public Operator<Object> makeFunction(Map<String, Operator<Object>> operators) {
        BiFunction<String, Object[], Object> fn = (fnName, args) -> {
            Operator<Object> f = operators.get(fnName);
            if (f == null) {
                throw new FunctionNotExistsError(fnName);
            }
            return f.execute(args);
        };
        return new FunctionalOperator<>(fn);
    }

    public Operator<Object> makeAccess() {
        BiFunction<String, Map<String, Object>, Object> fn = (attrName, struct) -> struct.get(attrName);
        return new FunctionalOperator<>(fn);
    }
}
