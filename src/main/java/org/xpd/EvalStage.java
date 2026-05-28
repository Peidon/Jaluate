package org.xpd;

import org.xpd.operator.Operator;
import org.xpd.operator.Symbol;

import java.util.ArrayList;

public class EvalStage<T> {
    private final Symbol symbol;
    private ArrayList<EvalStage<T>> dependencies;
    private Operator<T> operator;

    public EvalStage(Symbol symbol) {
        this.symbol = symbol;
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
}