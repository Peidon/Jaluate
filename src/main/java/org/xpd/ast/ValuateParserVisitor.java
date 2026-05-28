// Generated from ValuateParser.g4 by ANTLR 4.9.3
package org.xpd.ast;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValuateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValuateParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValuateParser#plan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlan(ValuateParser.PlanContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ValuateParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ValuateParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(ValuateParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(ValuateParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(ValuateParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(ValuateParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#variate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariate(ValuateParser.VariateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(ValuateParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#basicLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicLit(ValuateParser.BasicLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(ValuateParser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(ValuateParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArr(ValuateParser.ArrContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValuateParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(ValuateParser.IndexContext ctx);
}