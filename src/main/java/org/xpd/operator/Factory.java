package org.xpd.operator;

import org.xpd.errors.FunctionNotExistsError;
import org.xpd.type.Pair;
import org.xpd.type.PrimitiveType;
import org.xpd.type.Value;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;


public class Factory {

    public Operator<Object> makeValue(Map<String, Object> params, String key) {
        Supplier<Object> fn = ()-> params.get(key);
        return new FunctionalOperator<>(fn);
    }

    public Operator<Object> makeLiteral(String literal, PrimitiveType type) {
        Supplier<Object> fn = () -> switch (type) {
            case None -> null;
            case Boolean -> Boolean.parseBoolean(literal);
            case Integer -> Integer.parseInt(literal);
            case String -> literal;
            case Number ->  Double.parseDouble(literal);
        };
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeEquals() {
        BiFunction<Object, Object, Boolean> fn = Objects::equals;
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeNotEquals() {
        BiFunction<Object, Object, Boolean> fn = (a, b) -> !Objects.equals(a, b);
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeGreaterThan() {
        BiFunction<Comparable<Object>, Comparable<Object>, Boolean> fn = (a, b) -> a.compareTo(b) > 0;
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeGreaterThanOrEqualTo() {
        BiFunction<Comparable<Object>, Comparable<Object>, Boolean> fn = (a, b) -> a.compareTo(b) >= 0;
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeLessThan() {
        BiFunction<Comparable<Object>, Comparable<Object>, Boolean> fn = (a, b) -> a.compareTo(b) < 0;
        return new FunctionalOperator<>(fn);
    }

    public Operator<Boolean> makeLessThanOrEqualTo() {
        BiFunction<Comparable<Object>, Comparable<Object>, Boolean> fn = (a, b) -> a.compareTo(b) <= 0;
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
    public Operator<Object[]> makeArrayConst(Object[] arr) {
        Supplier<Object[]> fn = () -> arr;
        return new FunctionalOperator<>(fn);
    }

    public Operator<Object> makeFunction(String fnName, Map<String, Operator<Object>> operators) {
        Function<Object[], Object> fn = (args) -> {
            Operator<Object> f = operators.get(fnName);
            if (f == null) {
                throw new FunctionNotExistsError(fnName);
            }
            return f.execute(args);
        };
        return new FunctionalOperator<>(fn);
    }

    public Operator<Object> makeAccess(String attrName) {
        Function<Map<String, Object>, Object> fn = (struct) -> struct.get(attrName);
        return new FunctionalOperator<>(fn);
    }

    public Operator<Map<String, Object>> makeMap(Map<String, Object> attrs) {
        Supplier<Map<String, Object>> fn = () -> attrs;
        return new FunctionalOperator<>(fn);
    }

    public Operator<Pair> makePair(String key) {
        Function<Object, Pair> fn = (a) -> new Pair(key, a);
        return new FunctionalOperator<>(fn);
    }
}
