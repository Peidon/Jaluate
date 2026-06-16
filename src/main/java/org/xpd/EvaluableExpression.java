package org.xpd;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.xpd.ast.ValuateParser;
import org.xpd.ast.*;
import org.xpd.errors.VisitParserTreeError;
import org.xpd.operator.Factory;
import org.xpd.operator.Operator;
import org.xpd.operator.Symbol;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @param <T> Value Type of Result
 */
public class EvaluableExpression<T> implements ValuateParserVisitor<EvalStage> {
    private ValuateParser.PlanContext plan;
    private Map<String, Operator<Object>>  functions;
    private Factory operatorFactory;
    private Class<T> returnType;
    private Map<String, Object> parameters;

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
        this.parameters = parameters;
        var stage = this.visitPlan(plan);
        var result = this.evalStage(stage);
        return returnType.cast(result);
    }


    private Object evalStage(EvalStage stage) {
        var dep = stage.getDependencies();
        int n = dep.size();
        var args = new Object[n];
        for (int i = 0; i < n; i++) {
            args[i] = evalStage(dep.get(i));
        }
        var op = stage.getOperator();
        return op.execute(args);
    }


    @Override
    public EvalStage visitPlan(ValuateParser.PlanContext ctx) {
        var expr = ctx.expression();
        if (expr == null) {
            throw new VisitParserTreeError("expression is null");
        }
        return expr.accept(this);
    }

    @Override
    public EvalStage visitAssignment(ValuateParser.AssignmentContext ctx) {
        return null;
    }

    @Override
    public EvalStage visitExpression(ValuateParser.ExpressionContext ctx) {
        // primary type
        ParserRuleContext expr = ctx.primaryExpr();
        if  (expr != null) {
            return  expr.accept(this);
        }

        // unary expression
        expr = ctx.unaryExpr();
        if  (expr != null) {
            return  expr.accept(this);
        }

        // dependencies
        var stages = new ArrayList<EvalStage>();
        for (var exprContext : ctx.expression()) {
            stages.add(exprContext.accept(this));
        }

        // operators

        var node = ctx.DIV();
        if (node != null) {
            return new EvalStage(Symbol.DIVIDE, operatorFactory.makeDivide(), stages);
        }
        node = ctx.STAR();
        if (node != null) {
            return new EvalStage(Symbol.MULTIPLY, operatorFactory.makeMultiply(), stages);
        }
        node = ctx.MODULUS();
        if (node != null) {
            return new EvalStage(Symbol.MODULUS, operatorFactory.makeModulus(), stages);
        }
        node = ctx.PLUS();
        if (node != null) {
            return new EvalStage(Symbol.PLUS, operatorFactory.makePlus(), stages);
        }
        node = ctx.MINUS();
        if (node != null) {
            return new EvalStage(Symbol.MINUS, operatorFactory.makeMinus(), stages);
        }
        node = ctx.EQUALS();
        if (node != null) {
            return new EvalStage(Symbol.EQ,  operatorFactory.makeEquals(),stages);
        }
        node = ctx.NOT_EQUALS();
        if (node != null) {
            return new EvalStage(Symbol.NEQ,  operatorFactory.makeNotEquals(),stages);
        }
        node = ctx.LESS();
        if (node != null) {
            return new EvalStage(Symbol.LT,  operatorFactory.makeLessThan(),stages);
        }
        node = ctx.GREATER();
        if (node != null) {
            return new EvalStage(Symbol.GT,  operatorFactory.makeGreaterThan(),stages);
        }
        node = ctx.LESS_OR_EQUALS();
        if (node != null) {
            return new EvalStage(Symbol.LTE, operatorFactory.makeLessThanOrEqualTo(), stages);
        }
        node = ctx.GREATER_OR_EQUALS();
        if (node != null) {
            return new EvalStage(Symbol.GTE, operatorFactory.makeGreaterThanOrEqualTo(), stages);
        }
        node = ctx.LOGICAL_AND();
        if (node != null) {
            return new EvalStage(Symbol.AND,  operatorFactory.makeAnd(), stages);
        }
        node = ctx.LOGICAL_OR();
        if (node != null) {
            return new EvalStage(Symbol.OR,  operatorFactory.makeOr(), stages);
        }
        throw new VisitParserTreeError("expression is null");
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
