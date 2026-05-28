package org.xpd.ast;
// Generated from ValuateParser.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValuateParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, NIL_LIT=3, LP=4, RP=5, L_CURLY=6, R_CURLY=7, L_BRACKET=8, 
		R_BRACKET=9, COMMA=10, COLON=11, DOT=12, ASSIGN=13, LOGICAL_OR=14, LOGICAL_AND=15, 
		EQUALS=16, NOT_EQUALS=17, LESS=18, LESS_OR_EQUALS=19, GREATER=20, GREATER_OR_EQUALS=21, 
		EXCLAMATION=22, DIV=23, PLUS=24, MINUS=25, STAR=26, MODULUS=27, SKIP_=28, 
		WHITESPACE=29, IDENTIFIER=30, VARKEY_OPEN=31, STRING=32, STRING_LITERAL=33, 
		BYTES_LITERAL=34, INT=35, DECIMAL_LIT=36, FLOAT_NUMBER=37, VARID=38, VARKEY_CLOSE=39;
	public static final int
		RULE_plan = 0, RULE_assignment = 1, RULE_expression = 2, RULE_primaryExpr = 3, 
		RULE_unaryExpr = 4, RULE_arguments = 5, RULE_expressionList = 6, RULE_variate = 7, 
		RULE_operand = 8, RULE_basicLit = 9, RULE_obj = 10, RULE_pair = 11, RULE_arr = 12, 
		RULE_index = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"plan", "assignment", "expression", "primaryExpr", "unaryExpr", "arguments", 
			"expressionList", "variate", "operand", "basicLit", "obj", "pair", "arr", 
			"index"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'true'", "'false'", "'nil'", "'('", "')'", "'{'", null, "'['", 
			"']'", "','", "':'", "'.'", "'='", "'||'", "'&&'", "'=='", "'!='", "'<'", 
			"'<='", "'>'", "'>='", "'!'", "'/'", "'+'", "'-'", "'*'", "'%'", null, 
			null, null, "'${'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TRUE", "FALSE", "NIL_LIT", "LP", "RP", "L_CURLY", "R_CURLY", "L_BRACKET", 
			"R_BRACKET", "COMMA", "COLON", "DOT", "ASSIGN", "LOGICAL_OR", "LOGICAL_AND", 
			"EQUALS", "NOT_EQUALS", "LESS", "LESS_OR_EQUALS", "GREATER", "GREATER_OR_EQUALS", 
			"EXCLAMATION", "DIV", "PLUS", "MINUS", "STAR", "MODULUS", "SKIP_", "WHITESPACE", 
			"IDENTIFIER", "VARKEY_OPEN", "STRING", "STRING_LITERAL", "BYTES_LITERAL", 
			"INT", "DECIMAL_LIT", "FLOAT_NUMBER", "VARID", "VARKEY_CLOSE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ValuateParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ValuateParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PlanContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ValuateParser.EOF, 0); }
		public PlanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plan; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitPlan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlanContext plan() throws RecognitionException {
		PlanContext _localctx = new PlanContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_plan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			expression(0);
			setState(29);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public VariateContext variate() {
			return getRuleContext(VariateContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ValuateParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ValuateParser.EOF, 0); }
		public List<TerminalNode> DOT() { return getTokens(ValuateParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ValuateParser.DOT, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ValuateParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ValuateParser.IDENTIFIER, i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			variate();
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(32);
				match(DOT);
				setState(33);
				match(IDENTIFIER);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			match(ASSIGN);
			setState(40);
			expression(0);
			setState(41);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode STAR() { return getToken(ValuateParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(ValuateParser.DIV, 0); }
		public TerminalNode MODULUS() { return getToken(ValuateParser.MODULUS, 0); }
		public TerminalNode PLUS() { return getToken(ValuateParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ValuateParser.MINUS, 0); }
		public TerminalNode EQUALS() { return getToken(ValuateParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(ValuateParser.NOT_EQUALS, 0); }
		public TerminalNode LESS() { return getToken(ValuateParser.LESS, 0); }
		public TerminalNode LESS_OR_EQUALS() { return getToken(ValuateParser.LESS_OR_EQUALS, 0); }
		public TerminalNode GREATER() { return getToken(ValuateParser.GREATER, 0); }
		public TerminalNode GREATER_OR_EQUALS() { return getToken(ValuateParser.GREATER_OR_EQUALS, 0); }
		public TerminalNode LOGICAL_AND() { return getToken(ValuateParser.LOGICAL_AND, 0); }
		public TerminalNode LOGICAL_OR() { return getToken(ValuateParser.LOGICAL_OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case NIL_LIT:
			case LP:
			case L_CURLY:
			case L_BRACKET:
			case IDENTIFIER:
			case VARKEY_OPEN:
			case STRING:
			case INT:
			case FLOAT_NUMBER:
				{
				setState(44);
				primaryExpr(0);
				}
				break;
			case EXCLAMATION:
			case MINUS:
				{
				setState(45);
				unaryExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(63);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(48);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(49);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIV) | (1L << STAR) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(50);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(51);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(52);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(53);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(54);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(55);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << NOT_EQUALS) | (1L << LESS) | (1L << LESS_OR_EQUALS) | (1L << GREATER) | (1L << GREATER_OR_EQUALS))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(56);
						expression(4);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(57);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(58);
						match(LOGICAL_AND);
						setState(59);
						expression(3);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(60);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(61);
						match(LOGICAL_OR);
						setState(62);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryExprContext extends ParserRuleContext {
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ValuateParser.IDENTIFIER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ValuateParser.DOT, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		return primaryExpr(0);
	}

	private PrimaryExprContext primaryExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, _parentState);
		PrimaryExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_primaryExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(69);
				operand();
				}
				break;
			case 2:
				{
				setState(70);
				match(IDENTIFIER);
				setState(71);
				arguments();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrimaryExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_primaryExpr);
					setState(74);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(78);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case DOT:
						{
						setState(75);
						match(DOT);
						setState(76);
						match(IDENTIFIER);
						}
						break;
					case L_BRACKET:
						{
						setState(77);
						index();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExprContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(ValuateParser.MINUS, 0); }
		public TerminalNode EXCLAMATION() { return getToken(ValuateParser.EXCLAMATION, 0); }
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if ( !(_la==EXCLAMATION || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(86);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(ValuateParser.LP, 0); }
		public TerminalNode RP() { return getToken(ValuateParser.RP, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(LP);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NIL_LIT) | (1L << LP) | (1L << L_CURLY) | (1L << L_BRACKET) | (1L << EXCLAMATION) | (1L << MINUS) | (1L << IDENTIFIER) | (1L << VARKEY_OPEN) | (1L << STRING) | (1L << INT) | (1L << FLOAT_NUMBER))) != 0)) {
				{
				setState(89);
				expressionList();
				}
			}

			setState(92);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValuateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValuateParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			expression(0);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(95);
				match(COMMA);
				setState(96);
				expression(0);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariateContext extends ParserRuleContext {
		public TerminalNode VARKEY_OPEN() { return getToken(ValuateParser.VARKEY_OPEN, 0); }
		public TerminalNode VARID() { return getToken(ValuateParser.VARID, 0); }
		public TerminalNode VARKEY_CLOSE() { return getToken(ValuateParser.VARKEY_CLOSE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ValuateParser.IDENTIFIER, 0); }
		public VariateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitVariate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariateContext variate() throws RecognitionException {
		VariateContext _localctx = new VariateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variate);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARKEY_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(VARKEY_OPEN);
				setState(103);
				match(VARID);
				setState(104);
				match(VARKEY_CLOSE);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandContext extends ParserRuleContext {
		public BasicLitContext basicLit() {
			return getRuleContext(BasicLitContext.class,0);
		}
		public VariateContext variate() {
			return getRuleContext(VariateContext.class,0);
		}
		public TerminalNode LP() { return getToken(ValuateParser.LP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(ValuateParser.RP, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operand);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case NIL_LIT:
			case L_CURLY:
			case L_BRACKET:
			case STRING:
			case INT:
			case FLOAT_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				basicLit();
				}
				break;
			case IDENTIFIER:
			case VARKEY_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				variate();
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				match(LP);
				setState(111);
				expression(0);
				setState(112);
				match(RP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicLitContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ValuateParser.STRING, 0); }
		public TerminalNode INT() { return getToken(ValuateParser.INT, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(ValuateParser.FLOAT_NUMBER, 0); }
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public ArrContext arr() {
			return getRuleContext(ArrContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(ValuateParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ValuateParser.FALSE, 0); }
		public TerminalNode NIL_LIT() { return getToken(ValuateParser.NIL_LIT, 0); }
		public BasicLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitBasicLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicLitContext basicLit() throws RecognitionException {
		BasicLitContext _localctx = new BasicLitContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_basicLit);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(STRING);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(INT);
				}
				break;
			case FLOAT_NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(FLOAT_NUMBER);
				}
				break;
			case L_CURLY:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				obj();
				}
				break;
			case L_BRACKET:
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
				arr();
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 6);
				{
				setState(121);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 7);
				{
				setState(122);
				match(FALSE);
				}
				break;
			case NIL_LIT:
				enterOuterAlt(_localctx, 8);
				{
				setState(123);
				match(NIL_LIT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjContext extends ParserRuleContext {
		public TerminalNode L_CURLY() { return getToken(ValuateParser.L_CURLY, 0); }
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public TerminalNode R_CURLY() { return getToken(ValuateParser.R_CURLY, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ValuateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValuateParser.COMMA, i);
		}
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_obj);
		int _la;
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(L_CURLY);
				setState(127);
				pair();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(128);
					match(COMMA);
					setState(129);
					pair();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(R_CURLY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(L_CURLY);
				setState(138);
				match(R_CURLY);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ValuateParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(ValuateParser.COLON, 0); }
		public BasicLitContext basicLit() {
			return getRuleContext(BasicLitContext.class,0);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(STRING);
			setState(142);
			match(COLON);
			setState(143);
			basicLit();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(ValuateParser.L_BRACKET, 0); }
		public List<BasicLitContext> basicLit() {
			return getRuleContexts(BasicLitContext.class);
		}
		public BasicLitContext basicLit(int i) {
			return getRuleContext(BasicLitContext.class,i);
		}
		public TerminalNode R_BRACKET() { return getToken(ValuateParser.R_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ValuateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValuateParser.COMMA, i);
		}
		public ArrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitArr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrContext arr() throws RecognitionException {
		ArrContext _localctx = new ArrContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arr);
		int _la;
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(L_BRACKET);
				setState(146);
				basicLit();
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(147);
					match(COMMA);
					setState(148);
					basicLit();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(154);
				match(R_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(L_BRACKET);
				setState(157);
				match(R_BRACKET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(ValuateParser.L_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_BRACKET() { return getToken(ValuateParser.R_BRACKET, 0); }
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValuateParserVisitor ) return ((ValuateParserVisitor<? extends T>)visitor).visitIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(L_BRACKET);
			setState(161);
			expression(0);
			setState(162);
			match(R_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 3:
			return primaryExpr_sempred((PrimaryExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean primaryExpr_sempred(PrimaryExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00a7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\3\7\3%\n"+
		"\3\f\3\16\3(\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4\61\n\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4B\n\4\f\4\16\4E\13\4"+
		"\3\5\3\5\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\5\5\5Q\n\5\7\5S\n\5\f\5\16\5V"+
		"\13\5\3\6\3\6\3\6\3\7\3\7\5\7]\n\7\3\7\3\7\3\b\3\b\3\b\7\bd\n\b\f\b\16"+
		"\bg\13\b\3\t\3\t\3\t\3\t\5\tm\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\nu\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\177\n\13\3\f\3\f\3\f\3\f\7\f"+
		"\u0085\n\f\f\f\16\f\u0088\13\f\3\f\3\f\3\f\3\f\5\f\u008e\n\f\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\7\16\u0098\n\16\f\16\16\16\u009b\13\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00a1\n\16\3\17\3\17\3\17\3\17\3\17\2\4\6\b\20\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\2\6\4\2\31\31\34\35\3\2\32\33\3\2\22"+
		"\27\4\2\30\30\33\33\2\u00b2\2\36\3\2\2\2\4!\3\2\2\2\6\60\3\2\2\2\bJ\3"+
		"\2\2\2\nW\3\2\2\2\fZ\3\2\2\2\16`\3\2\2\2\20l\3\2\2\2\22t\3\2\2\2\24~\3"+
		"\2\2\2\26\u008d\3\2\2\2\30\u008f\3\2\2\2\32\u00a0\3\2\2\2\34\u00a2\3\2"+
		"\2\2\36\37\5\6\4\2\37 \7\2\2\3 \3\3\2\2\2!&\5\20\t\2\"#\7\16\2\2#%\7 "+
		"\2\2$\"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*"+
		"\7\17\2\2*+\5\6\4\2+,\7\2\2\3,\5\3\2\2\2-.\b\4\1\2.\61\5\b\5\2/\61\5\n"+
		"\6\2\60-\3\2\2\2\60/\3\2\2\2\61C\3\2\2\2\62\63\f\7\2\2\63\64\t\2\2\2\64"+
		"B\5\6\4\b\65\66\f\6\2\2\66\67\t\3\2\2\67B\5\6\4\789\f\5\2\29:\t\4\2\2"+
		":B\5\6\4\6;<\f\4\2\2<=\7\21\2\2=B\5\6\4\5>?\f\3\2\2?@\7\20\2\2@B\5\6\4"+
		"\4A\62\3\2\2\2A\65\3\2\2\2A8\3\2\2\2A;\3\2\2\2A>\3\2\2\2BE\3\2\2\2CA\3"+
		"\2\2\2CD\3\2\2\2D\7\3\2\2\2EC\3\2\2\2FG\b\5\1\2GK\5\22\n\2HI\7 \2\2IK"+
		"\5\f\7\2JF\3\2\2\2JH\3\2\2\2KT\3\2\2\2LP\f\4\2\2MN\7\16\2\2NQ\7 \2\2O"+
		"Q\5\34\17\2PM\3\2\2\2PO\3\2\2\2QS\3\2\2\2RL\3\2\2\2SV\3\2\2\2TR\3\2\2"+
		"\2TU\3\2\2\2U\t\3\2\2\2VT\3\2\2\2WX\t\5\2\2XY\5\6\4\2Y\13\3\2\2\2Z\\\7"+
		"\6\2\2[]\5\16\b\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7\7\2\2_\r\3\2\2\2"+
		"`e\5\6\4\2ab\7\f\2\2bd\5\6\4\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2"+
		"f\17\3\2\2\2ge\3\2\2\2hi\7!\2\2ij\7(\2\2jm\7)\2\2km\7 \2\2lh\3\2\2\2l"+
		"k\3\2\2\2m\21\3\2\2\2nu\5\24\13\2ou\5\20\t\2pq\7\6\2\2qr\5\6\4\2rs\7\7"+
		"\2\2su\3\2\2\2tn\3\2\2\2to\3\2\2\2tp\3\2\2\2u\23\3\2\2\2v\177\7\"\2\2"+
		"w\177\7%\2\2x\177\7\'\2\2y\177\5\26\f\2z\177\5\32\16\2{\177\7\3\2\2|\177"+
		"\7\4\2\2}\177\7\5\2\2~v\3\2\2\2~w\3\2\2\2~x\3\2\2\2~y\3\2\2\2~z\3\2\2"+
		"\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\25\3\2\2\2\u0080\u0081\7\b\2\2\u0081"+
		"\u0086\5\30\r\2\u0082\u0083\7\f\2\2\u0083\u0085\5\30\r\2\u0084\u0082\3"+
		"\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\t\2\2\u008a\u008e\3\2"+
		"\2\2\u008b\u008c\7\b\2\2\u008c\u008e\7\t\2\2\u008d\u0080\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\27\3\2\2\2\u008f\u0090\7\"\2\2\u0090\u0091\7\r\2"+
		"\2\u0091\u0092\5\24\13\2\u0092\31\3\2\2\2\u0093\u0094\7\n\2\2\u0094\u0099"+
		"\5\24\13\2\u0095\u0096\7\f\2\2\u0096\u0098\5\24\13\2\u0097\u0095\3\2\2"+
		"\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7\13\2\2\u009d\u00a1\3\2\2\2"+
		"\u009e\u009f\7\n\2\2\u009f\u00a1\7\13\2\2\u00a0\u0093\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\33\3\2\2\2\u00a2\u00a3\7\n\2\2\u00a3\u00a4\5\6\4\2\u00a4"+
		"\u00a5\7\13\2\2\u00a5\35\3\2\2\2\22&\60ACJPT\\elt~\u0086\u008d\u0099\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}