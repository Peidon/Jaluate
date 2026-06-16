package org.xpd;

import org.xpd.operator.Operator;
import org.xpd.operator.Symbol;

import java.util.ArrayList;

public class EvalStage {
    private final Symbol symbol;
    private final Operator<?> operator;
    private ArrayList<EvalStage> dependencies;

    public EvalStage(Symbol symbol, Operator<?> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public EvalStage(Symbol symbol, Operator<?> operator, ArrayList<EvalStage> dependencies) {
        this.symbol = symbol;
        this.operator = operator;
        this.dependencies = dependencies;
    }

    public Operator<?> getOperator() {
        return operator;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public ArrayList<EvalStage> getDependencies() {
        return dependencies;
    }

    public void setDependencies(ArrayList<EvalStage> dependencies) {
        this.dependencies = dependencies;
    }
}