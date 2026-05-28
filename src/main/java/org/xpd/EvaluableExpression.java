package org.xpd;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.xpd.ast.ValuateParser;
import org.xpd.ast.*;
import org.xpd.operator.FunctionalOperator;
import org.xpd.operator.Operator;

import java.util.Map;

/**
 *
 * @param <T> Value Type of Result
 */
public class EvaluableExpression<T> implements ValuateParserVisitor<EvalStage<?>> {
    private ValuateParser.PlanContext plan;
    private Map<String, Operator<?>>  functions;

    /**
     * parse the text to AST, then hold the Tree as an execute plan
     * @param text Expression String
     */
    public EvaluableExpression(String text) {
        var inputStream = CharStreams.fromString(text); 
        var lexer = new ValuateLexer(inputStream);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new ValuateParser(tokenStream);

        parser.setBuildParseTree(true);
        this.plan = parser.plan();
    }

    public EvaluableExpression(String text, Map<String, Operator<?>> functions) {
        this(text);
    }


    @Override
    public EvalStage<?> visitPlan(ValuateParser.PlanContext ctx) {
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
