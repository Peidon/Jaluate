package org.xpd;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.xpd.ast.ValuateParser;
import org.xpd.ast.*;
import org.xpd.errors.NullOperatorException;
import org.xpd.errors.VisitParserTreeError;
import org.xpd.operator.Factory;
import org.xpd.operator.Operator;
import org.xpd.operator.Symbol;
import org.xpd.type.PrimitiveType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 *
 *
 */
public class EvaluableExpression implements ValuateParserVisitor<EvalStage> {
    private final ValuateParser.PlanContext plan;
    private Map<String, Operator<Object>>  functions;
    private final Factory operatorFactory;
    private Map<String, Object> parameters;

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
        this.operatorFactory = new Factory();
    }

    public EvaluableExpression(String text, Map<String, Operator<Object>> functions) {
        this(text);
        this.functions = functions;
    }

    public Object Eval() {
        var stage = this.visitPlan(plan);
        return this.evalStage(stage);
    }

    public Object Eval(Map<String, Object> parameters) {
        this.parameters = parameters;
        var stage = this.visitPlan(plan);
        return this.evalStage(stage);
    }


    private Object evalStage(EvalStage stage) {
        var op = stage.getOperator();
        if (op == null) {
            throw new NullOperatorException(stage.getSymbol());
        }
        var dep = stage.getDependencies();
        if (dep == null) {
            return op.execute();
        }
        int n = dep.size();
        var args = new Object[n];
        for (int i = 0; i < n; i++) {
            args[i] = evalStage(dep.get(i));
        }
        return op.execute(args);
    }


    @Override
    public EvalStage visitPlan(ValuateParser.PlanContext ctx) {
        var expr = ctx.expression();
        if (expr == null) {
            throw new VisitParserTreeError("visit plan failed. ");
        }
        return expr.accept(this);
    }

    @Override
    public EvalStage visitAssignment(ValuateParser.AssignmentContext ctx) {
        throw new VisitParserTreeError("assignment operator is not yet implemented. ");
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

        // binary operators

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
        var operand = ctx.operand();
        if (operand != null) {
            return operand.accept(this);
        }
        var primary = ctx.primaryExpr();
        if (primary != null) {
            var primaryStage =  primary.accept(this);

            var identify = ctx.IDENTIFIER();
            if (identify != null && ctx.DOT() != null) {
                // access operator
                return new EvalStage(Symbol.ACCESS, operatorFactory.makeAccess(identify.getText()),
                        (ArrayList<EvalStage>) Collections.singletonList(primaryStage));
            }

            var idx = ctx.index();
            if (idx != null) {
                // array index operator
                var idxStage = idx.accept(this);
                return new EvalStage(Symbol.INDEX, operatorFactory.makeArrayIndex(),
                        (ArrayList<EvalStage>) Arrays.asList(primaryStage, idxStage));
            }
        }

        var identify = ctx.IDENTIFIER();
        var args = ctx.arguments();
        // function
        if (identify != null && args != null) {
            String funcName = identify.getText();
            var argStage = args.accept(this);
            return new EvalStage(Symbol.FUNCTIONAL, operatorFactory.makeFunction(funcName, functions),
                    (ArrayList<EvalStage>) Collections.singletonList(argStage));
        }
        throw new VisitParserTreeError("primary expression is null");
    }

    @Override
    public EvalStage visitUnaryExpr(ValuateParser.UnaryExprContext ctx) {
        var stages = new ArrayList<EvalStage>();
        var expr = ctx.expression();
        if (expr != null) {
            stages.add(expr.accept(this));
        }
        var minus = ctx.MINUS();
        if (minus != null) {
            return new EvalStage(Symbol.MINUS, operatorFactory.makeNegate(), stages);
        }
        var invert = ctx.EXCLAMATION();
        if (invert != null) {
            return new EvalStage(Symbol.INVERT, operatorFactory.makeNot(),  stages);
        }
        throw new VisitParserTreeError("unary expression is null");
    }

    @Override
    public EvalStage visitArguments(ValuateParser.ArgumentsContext ctx) {
        var expr = ctx.expressionList();
        if (expr != null) {
            return  expr.accept(this);
        }
        throw new VisitParserTreeError("arguments expression is null");
    }

    @Override
    public EvalStage visitExpressionList(ValuateParser.ExpressionListContext ctx) {
        if (ctx.expression() == null) {
            throw new VisitParserTreeError("expression list is null");
        }
        var n = ctx.expression().size();
        Object[] arr = new Object[n];
        for (int i = 0; i < n; i++) {
            var stage = ctx.expression(i).accept(this);
            arr[i] = evalStage(stage);
        }
        return new EvalStage(Symbol.VALUE, operatorFactory.makeArrayConst(arr));
    }

    @Override
    public EvalStage visitVariate(ValuateParser.VariateContext ctx) {
        var v = ctx.VARID();
        if (v != null) {
            return new EvalStage(Symbol.VALUE, operatorFactory.makeValue(parameters, v.getText()));
        }
        var id = ctx.IDENTIFIER();
        if (id != null) {
            return new EvalStage(Symbol.VALUE, operatorFactory.makeValue(parameters, id.getText()));
        }
        throw new VisitParserTreeError("variate expression is null");
    }

    @Override
    public EvalStage visitOperand(ValuateParser.OperandContext ctx) {
        var basicLit = ctx.basicLit();
        if (basicLit != null) {
            return basicLit.accept(this);
        }
        var v = ctx.variate();
        if (v != null) {
            return v.accept(this);
        }
        var expr = ctx.expression();
        if (expr != null) {
            return expr.accept(this);
        }
        throw new VisitParserTreeError("operand is null");
    }

    @Override
    public EvalStage visitBasicLit(ValuateParser.BasicLitContext ctx) {
        var nullLit = ctx.NIL_LIT();
        if (nullLit != null) {
            return new EvalStage(Symbol.LITERAL, operatorFactory.makeLiteral(nullLit.getText(), PrimitiveType.None));
        }
        if (ctx.TRUE() != null) {
            return new EvalStage(Symbol.LITERAL, operatorFactory.makeLiteral(Boolean.TRUE.toString(), PrimitiveType.Boolean));
        }
        if (ctx.FALSE() != null) {
            return new EvalStage(Symbol.LITERAL, operatorFactory.makeLiteral(Boolean.FALSE.toString(), PrimitiveType.Boolean));
        }
        var lit = ctx.INT();
        if (lit != null) {
            return new EvalStage(Symbol.LITERAL, operatorFactory.makeLiteral(lit.getText(), PrimitiveType.Integer));
        }
        lit = ctx.STRING();
        if (lit != null) {
            return new EvalStage(Symbol.LITERAL, operatorFactory.makeLiteral(lit.getText(), PrimitiveType.String));
        }
        lit = ctx.FLOAT_NUMBER();
        if (lit != null) {
            return new EvalStage(Symbol.LITERAL, operatorFactory.makeLiteral(lit.getText(), PrimitiveType.Number));
        }
        throw new VisitParserTreeError("basic literal is null");
    }

    @Override
    public EvalStage visitObj(ValuateParser.ObjContext ctx) {
        return this.visit(ctx);
    }

    @Override
    public EvalStage visitPair(ValuateParser.PairContext ctx) {
        return this.visit(ctx);
    }

    @Override
    public EvalStage visitArr(ValuateParser.ArrContext ctx) {
        if (ctx.basicLit() == null) {
            throw new VisitParserTreeError("array literal is null");
        }
        var n = ctx.basicLit().size();
        Object[] arr = new Object[n];
        for (int i = 0; i < n; i++) {
            var stage = ctx.basicLit(i).accept(this);
            arr[i] = evalStage(stage);
        }
        return new EvalStage(Symbol.LITERAL, operatorFactory.makeArrayConst(arr));
    }

    @Override
    public EvalStage visitIndex(ValuateParser.IndexContext ctx) {
        var idx = ctx.expression();
        if (idx == null) {
            throw new VisitParserTreeError("index is null");
        }
        var stage = idx.accept(this);
        return new EvalStage(Symbol.INDEX, operatorFactory.makeIndex(), (ArrayList<EvalStage>) Collections.singletonList(stage));
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
