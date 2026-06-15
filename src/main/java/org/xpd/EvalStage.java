package org.xpd;

import org.xpd.operator.Operator;
import org.xpd.operator.Symbol;

import java.util.ArrayList;

public class EvalStage<T> {
    private final Symbol symbol;
    private final Operator<T> operator;
    private ArrayList<EvalStage<T>> dependencies;

    public EvalStage(Symbol symbol, Operator<T> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public EvalStage(Symbol symbol, Operator<T> operator, ArrayList<EvalStage<T>> dependencies) {
        this.symbol = symbol;
        this.operator = operator;
        this.dependencies = dependencies;
    }

    public Operator<T> getOperator() {
        return operator;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public ArrayList<EvalStage<T>> getDependencies() {
        return dependencies;
    }

    public void setDependencies(ArrayList<EvalStage<T>> dependencies) {
        this.dependencies = dependencies;
    }
}