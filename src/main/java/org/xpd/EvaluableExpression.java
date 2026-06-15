package org.xpd;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.xpd.ast.ValuateParser;
import org.xpd.ast.*;
import org.xpd.operator.Factory;
import org.xpd.operator.Operator;

import java.util.Map;

/**
 *
 * @param <T> Value Type of Result
 */
public class EvaluableExpression<T> implements ValuateParserVisitor<EvalStage<?>> {
    private ValuateParser.PlanContext plan;
    private Map<String, Operator<Object>>  functions;
    private Factory operatorFactory;
    private Class<T> returnType;

    /**
     * parse the text to AST, then hold the Tree as an execute plan
     * @param text Expression String
     */
    public EvaluableExpression(String text, Class<T> returnType) {
        var inputStream = CharStreams.fromString(text); 
        var lexer = new ValuateLexer(inputStream);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new ValuateParser(tokenStream);

        parser.setBuildParseTree(true);
        this.plan = parser.plan();
        this.operatorFactory = new Factory();
        this.returnType = returnType;
    }

    public EvaluableExpression(String text,Class<T> returnType,  Map<String, Operator<Object>> functions) {
        this(text, returnType);
        this.functions = functions;
    }

    public T Eval(Map<String, Object> parameters) {
        var stage = this.visitPlan(plan);
        var result = this.evalStage(stage, parameters);
        return returnType.cast(result);
    }


    private Object evalStage(EvalStage<?> stage, Map<String, Object> parameters) {
        var dep = stage.getDependencies();
        int n = dep.size();
        var args = new Object[n];
        for (int i = 0; i < n; i++) {
            args[i] = evalStage(dep.get(i), parameters);
        }
        var op = stage.getOperator();
        op.setParameters(parameters);
        return op.execute(args);
    }


    @Override
    public EvalStage<T> visitPlan(ValuateParser.PlanContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitAssignment(ValuateParser.AssignmentContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitExpression(ValuateParser.ExpressionContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitPrimaryExpr(ValuateParser.PrimaryExprContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitUnaryExpr(ValuateParser.UnaryExprContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitArguments(ValuateParser.ArgumentsContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitExpressionList(ValuateParser.ExpressionListContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitVariate(ValuateParser.VariateContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitOperand(ValuateParser.OperandContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitBasicLit(ValuateParser.BasicLitContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitObj(ValuateParser.ObjContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitPair(ValuateParser.PairContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitArr(ValuateParser.ArrContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitIndex(ValuateParser.IndexContext ctx) {
        return null;
    }

    @Override
    public EvalStage visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public EvalStage visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public EvalStage visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public EvalStage visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
