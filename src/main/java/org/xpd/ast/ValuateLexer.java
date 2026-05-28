package org.xpd.ast;
// Generated from ValuateLexer.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValuateLexer extends Lexer {
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
		VAR=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "VAR"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TRUE", "FALSE", "NIL_LIT", "LP", "RP", "L_CURLY", "R_CURLY", "L_BRACKET", 
			"R_BRACKET", "COMMA", "COLON", "DOT", "ASSIGN", "LOGICAL_OR", "LOGICAL_AND", 
			"EQUALS", "NOT_EQUALS", "LESS", "LESS_OR_EQUALS", "GREATER", "GREATER_OR_EQUALS", 
			"EXCLAMATION", "DIV", "PLUS", "MINUS", "STAR", "MODULUS", "SKIP_", "WHITESPACE", 
			"IDENTIFIER", "VARKEY_OPEN", "STRING", "STRING_LITERAL", "BYTES_LITERAL", 
			"INT", "DECIMAL_LIT", "FLOAT_NUMBER", "LETTER", "NON_ZERO_DIGIT", "DIGIT", 
			"OCT_DIGIT", "HEX_DIGIT", "BIN_DIGIT", "POINT_FLOAT", "EXPONENT_FLOAT", 
			"INT_PART", "FRACTION", "EXPONENT", "SHORT_BYTES", "LONG_BYTES", "LONG_BYTES_ITEM", 
			"SHORT_BYTES_CHAR_NO_SINGLE_QUOTE", "SHORT_BYTES_CHAR_NO_DOUBLE_QUOTE", 
			"LONG_BYTES_CHAR", "BYTES_ESCAPE_SEQ", "SPACES", "LINE_JOINING", "ESC", 
			"UNICODE", "SAFECODEPOINT", "HEX", "VARID", "VARKEY_CLOSE"
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


	public ValuateLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ValuateLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u01b1\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\5\35"+
		"\u00ca\n\35\3\35\3\35\3\36\6\36\u00cf\n\36\r\36\16\36\u00d0\3\36\3\36"+
		"\3\37\7\37\u00d6\n\37\f\37\16\37\u00d9\13\37\3\37\3\37\3\37\7\37\u00de"+
		"\n\37\f\37\16\37\u00e1\13\37\3 \3 \3 \3 \3 \3!\3!\3!\5!\u00eb\n!\3\"\3"+
		"\"\3\"\7\"\u00f0\n\"\f\"\16\"\u00f3\13\"\3\"\3\"\3#\3#\3#\3#\3#\5#\u00fc"+
		"\n#\3#\3#\5#\u0100\n#\3$\3$\5$\u0104\n$\3%\3%\7%\u0108\n%\f%\16%\u010b"+
		"\13%\3&\3&\5&\u010f\n&\3\'\5\'\u0112\n\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3"+
		",\3-\5-\u011f\n-\3-\3-\3-\3-\5-\u0125\n-\3.\3.\5.\u0129\n.\3.\3.\3/\6"+
		"/\u012e\n/\r/\16/\u012f\3\60\3\60\6\60\u0134\n\60\r\60\16\60\u0135\3\61"+
		"\3\61\5\61\u013a\n\61\3\61\6\61\u013d\n\61\r\61\16\61\u013e\3\62\3\62"+
		"\3\62\7\62\u0144\n\62\f\62\16\62\u0147\13\62\3\62\3\62\3\62\3\62\7\62"+
		"\u014d\n\62\f\62\16\62\u0150\13\62\3\62\5\62\u0153\n\62\3\63\3\63\3\63"+
		"\3\63\3\63\7\63\u015a\n\63\f\63\16\63\u015d\13\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\7\63\u0167\n\63\f\63\16\63\u016a\13\63\3\63\3\63"+
		"\3\63\5\63\u016f\n\63\3\64\3\64\5\64\u0173\n\64\3\65\5\65\u0176\n\65\3"+
		"\66\5\66\u0179\n\66\3\67\5\67\u017c\n\67\38\38\38\39\69\u0182\n9\r9\16"+
		"9\u0183\3:\3:\5:\u0188\n:\3:\5:\u018b\n:\3:\3:\5:\u018f\n:\3;\3;\3;\5"+
		";\u0194\n;\3<\3<\3<\3<\3<\3<\3=\3=\3>\3>\3?\3?\3?\3?\7?\u01a4\n?\f?\16"+
		"?\u01a7\13?\7?\u01a9\n?\f?\16?\u01ac\13?\3@\3@\3@\3@\4\u015b\u0168\2A"+
		"\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20"+
		" \21\"\22$\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35:\36<\37"+
		"> @!B\"D#F$H%J&L\'N\2P\2R\2T\2V\2X\2Z\2\\\2^\2`\2b\2d\2f\2h\2j\2l\2n\2"+
		"p\2r\2t\2v\2x\2z\2|\2~(\u0080)\4\2\3\24\5\2\13\f\17\17\"\"\4\2DDdd\4\2"+
		"TTtt\5\2C\\aac|\3\2\63;\3\2\62;\3\2\629\5\2\62;CHch\3\2\62\63\4\2GGgg"+
		"\4\2--//\7\2\2\13\r\16\20(*]_\u0081\7\2\2\13\r\16\20#%]_\u0081\4\2\2]"+
		"_\u0081\3\2\2\u0081\4\2\13\13\"\"\n\2$$\61\61^^ddhhppttvv\5\2\2!$$^^\2"+
		"\u01be\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16"+
		"\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2"+
		"\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$"+
		"\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3"+
		"\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2"+
		"<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3"+
		"\2\2\2\2J\3\2\2\2\2L\3\2\2\2\3~\3\2\2\2\3\u0080\3\2\2\2\4\u0082\3\2\2"+
		"\2\6\u0087\3\2\2\2\b\u008d\3\2\2\2\n\u0091\3\2\2\2\f\u0093\3\2\2\2\16"+
		"\u0095\3\2\2\2\20\u0097\3\2\2\2\22\u0099\3\2\2\2\24\u009b\3\2\2\2\26\u009d"+
		"\3\2\2\2\30\u009f\3\2\2\2\32\u00a1\3\2\2\2\34\u00a3\3\2\2\2\36\u00a5\3"+
		"\2\2\2 \u00a8\3\2\2\2\"\u00ab\3\2\2\2$\u00ae\3\2\2\2&\u00b1\3\2\2\2(\u00b3"+
		"\3\2\2\2*\u00b6\3\2\2\2,\u00b8\3\2\2\2.\u00bb\3\2\2\2\60\u00bd\3\2\2\2"+
		"\62\u00bf\3\2\2\2\64\u00c1\3\2\2\2\66\u00c3\3\2\2\28\u00c5\3\2\2\2:\u00c9"+
		"\3\2\2\2<\u00ce\3\2\2\2>\u00d7\3\2\2\2@\u00e2\3\2\2\2B\u00ea\3\2\2\2D"+
		"\u00ec\3\2\2\2F\u00fb\3\2\2\2H\u0103\3\2\2\2J\u0105\3\2\2\2L\u010e\3\2"+
		"\2\2N\u0111\3\2\2\2P\u0113\3\2\2\2R\u0115\3\2\2\2T\u0117\3\2\2\2V\u0119"+
		"\3\2\2\2X\u011b\3\2\2\2Z\u0124\3\2\2\2\\\u0128\3\2\2\2^\u012d\3\2\2\2"+
		"`\u0131\3\2\2\2b\u0137\3\2\2\2d\u0152\3\2\2\2f\u016e\3\2\2\2h\u0172\3"+
		"\2\2\2j\u0175\3\2\2\2l\u0178\3\2\2\2n\u017b\3\2\2\2p\u017d\3\2\2\2r\u0181"+
		"\3\2\2\2t\u0185\3\2\2\2v\u0190\3\2\2\2x\u0195\3\2\2\2z\u019b\3\2\2\2|"+
		"\u019d\3\2\2\2~\u019f\3\2\2\2\u0080\u01ad\3\2\2\2\u0082\u0083\7v\2\2\u0083"+
		"\u0084\7t\2\2\u0084\u0085\7w\2\2\u0085\u0086\7g\2\2\u0086\5\3\2\2\2\u0087"+
		"\u0088\7h\2\2\u0088\u0089\7c\2\2\u0089\u008a\7n\2\2\u008a\u008b\7u\2\2"+
		"\u008b\u008c\7g\2\2\u008c\7\3\2\2\2\u008d\u008e\7p\2\2\u008e\u008f\7k"+
		"\2\2\u008f\u0090\7n\2\2\u0090\t\3\2\2\2\u0091\u0092\7*\2\2\u0092\13\3"+
		"\2\2\2\u0093\u0094\7+\2\2\u0094\r\3\2\2\2\u0095\u0096\7}\2\2\u0096\17"+
		"\3\2\2\2\u0097\u0098\7\177\2\2\u0098\21\3\2\2\2\u0099\u009a\7]\2\2\u009a"+
		"\23\3\2\2\2\u009b\u009c\7_\2\2\u009c\25\3\2\2\2\u009d\u009e\7.\2\2\u009e"+
		"\27\3\2\2\2\u009f\u00a0\7<\2\2\u00a0\31\3\2\2\2\u00a1\u00a2\7\60\2\2\u00a2"+
		"\33\3\2\2\2\u00a3\u00a4\7?\2\2\u00a4\35\3\2\2\2\u00a5\u00a6\7~\2\2\u00a6"+
		"\u00a7\7~\2\2\u00a7\37\3\2\2\2\u00a8\u00a9\7(\2\2\u00a9\u00aa\7(\2\2\u00aa"+
		"!\3\2\2\2\u00ab\u00ac\7?\2\2\u00ac\u00ad\7?\2\2\u00ad#\3\2\2\2\u00ae\u00af"+
		"\7#\2\2\u00af\u00b0\7?\2\2\u00b0%\3\2\2\2\u00b1\u00b2\7>\2\2\u00b2\'\3"+
		"\2\2\2\u00b3\u00b4\7>\2\2\u00b4\u00b5\7?\2\2\u00b5)\3\2\2\2\u00b6\u00b7"+
		"\7@\2\2\u00b7+\3\2\2\2\u00b8\u00b9\7@\2\2\u00b9\u00ba\7?\2\2\u00ba-\3"+
		"\2\2\2\u00bb\u00bc\7#\2\2\u00bc/\3\2\2\2\u00bd\u00be\7\61\2\2\u00be\61"+
		"\3\2\2\2\u00bf\u00c0\7-\2\2\u00c0\63\3\2\2\2\u00c1\u00c2\7/\2\2\u00c2"+
		"\65\3\2\2\2\u00c3\u00c4\7,\2\2\u00c4\67\3\2\2\2\u00c5\u00c6\7\'\2\2\u00c6"+
		"9\3\2\2\2\u00c7\u00ca\5r9\2\u00c8\u00ca\5t:\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\b\35\2\2\u00cc;\3\2\2\2"+
		"\u00cd\u00cf\t\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\36\2\2"+
		"\u00d3=\3\2\2\2\u00d4\u00d6\5R)\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\u00df\5N\'\2\u00db\u00de\5N\'\2\u00dc\u00de\5R)\2"+
		"\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0?\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e3\7&\2\2\u00e3\u00e4\7}\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\b \3"+
		"\2\u00e6A\3\2\2\2\u00e7\u00eb\5D\"\2\u00e8\u00eb\5d\62\2\u00e9\u00eb\5"+
		"f\63\2\u00ea\u00e7\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb"+
		"C\3\2\2\2\u00ec\u00f1\7$\2\2\u00ed\u00f0\5v;\2\u00ee\u00f0\5z=\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2"+
		"\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4"+
		"\u00f5\7$\2\2\u00f5E\3\2\2\2\u00f6\u00fc\t\3\2\2\u00f7\u00f8\t\3\2\2\u00f8"+
		"\u00fc\t\4\2\2\u00f9\u00fa\t\4\2\2\u00fa\u00fc\t\3\2\2\u00fb\u00f6\3\2"+
		"\2\2\u00fb\u00f7\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd"+
		"\u0100\5d\62\2\u00fe\u0100\5f\63\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe\3\2"+
		"\2\2\u0100G\3\2\2\2\u0101\u0104\5J%\2\u0102\u0104\7\62\2\2\u0103\u0101"+
		"\3\2\2\2\u0103\u0102\3\2\2\2\u0104I\3\2\2\2\u0105\u0109\5P(\2\u0106\u0108"+
		"\5R)\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010aK\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010f\5Z-\2\u010d"+
		"\u010f\5\\.\2\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2\u010fM\3\2\2\2\u0110"+
		"\u0112\t\5\2\2\u0111\u0110\3\2\2\2\u0112O\3\2\2\2\u0113\u0114\t\6\2\2"+
		"\u0114Q\3\2\2\2\u0115\u0116\t\7\2\2\u0116S\3\2\2\2\u0117\u0118\t\b\2\2"+
		"\u0118U\3\2\2\2\u0119\u011a\t\t\2\2\u011aW\3\2\2\2\u011b\u011c\t\n\2\2"+
		"\u011cY\3\2\2\2\u011d\u011f\5^/\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2"+
		"\2\2\u011f\u0120\3\2\2\2\u0120\u0125\5`\60\2\u0121\u0122\5^/\2\u0122\u0123"+
		"\7\60\2\2\u0123\u0125\3\2\2\2\u0124\u011e\3\2\2\2\u0124\u0121\3\2\2\2"+
		"\u0125[\3\2\2\2\u0126\u0129\5^/\2\u0127\u0129\5Z-\2\u0128\u0126\3\2\2"+
		"\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\5b\61\2\u012b]"+
		"\3\2\2\2\u012c\u012e\5R)\2\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130_\3\2\2\2\u0131\u0133\7\60\2\2"+
		"\u0132\u0134\5R)\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0133"+
		"\3\2\2\2\u0135\u0136\3\2\2\2\u0136a\3\2\2\2\u0137\u0139\t\13\2\2\u0138"+
		"\u013a\t\f\2\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2"+
		"\2\2\u013b\u013d\5R)\2\u013c\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013c"+
		"\3\2\2\2\u013e\u013f\3\2\2\2\u013fc\3\2\2\2\u0140\u0145\7)\2\2\u0141\u0144"+
		"\5j\65\2\u0142\u0144\5p8\2\u0143\u0141\3\2\2\2\u0143\u0142\3\2\2\2\u0144"+
		"\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0148\3\2"+
		"\2\2\u0147\u0145\3\2\2\2\u0148\u0153\7)\2\2\u0149\u014e\7$\2\2\u014a\u014d"+
		"\5l\66\2\u014b\u014d\5p8\2\u014c\u014a\3\2\2\2\u014c\u014b\3\2\2\2\u014d"+
		"\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2"+
		"\2\2\u0150\u014e\3\2\2\2\u0151\u0153\7$\2\2\u0152\u0140\3\2\2\2\u0152"+
		"\u0149\3\2\2\2\u0153e\3\2\2\2\u0154\u0155\7)\2\2\u0155\u0156\7)\2\2\u0156"+
		"\u0157\7)\2\2\u0157\u015b\3\2\2\2\u0158\u015a\5h\64\2\u0159\u0158\3\2"+
		"\2\2\u015a\u015d\3\2\2\2\u015b\u015c\3\2\2\2\u015b\u0159\3\2\2\2\u015c"+
		"\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7)\2\2\u015f\u0160\7)\2"+
		"\2\u0160\u016f\7)\2\2\u0161\u0162\7$\2\2\u0162\u0163\7$\2\2\u0163\u0164"+
		"\7$\2\2\u0164\u0168\3\2\2\2\u0165\u0167\5h\64\2\u0166\u0165\3\2\2\2\u0167"+
		"\u016a\3\2\2\2\u0168\u0169\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016b\3\2"+
		"\2\2\u016a\u0168\3\2\2\2\u016b\u016c\7$\2\2\u016c\u016d\7$\2\2\u016d\u016f"+
		"\7$\2\2\u016e\u0154\3\2\2\2\u016e\u0161\3\2\2\2\u016fg\3\2\2\2\u0170\u0173"+
		"\5n\67\2\u0171\u0173\5p8\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173"+
		"i\3\2\2\2\u0174\u0176\t\r\2\2\u0175\u0174\3\2\2\2\u0176k\3\2\2\2\u0177"+
		"\u0179\t\16\2\2\u0178\u0177\3\2\2\2\u0179m\3\2\2\2\u017a\u017c\t\17\2"+
		"\2\u017b\u017a\3\2\2\2\u017co\3\2\2\2\u017d\u017e\7^\2\2\u017e\u017f\t"+
		"\20\2\2\u017fq\3\2\2\2\u0180\u0182\t\21\2\2\u0181\u0180\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184s\3\2\2\2"+
		"\u0185\u0187\7^\2\2\u0186\u0188\5r9\2\u0187\u0186\3\2\2\2\u0187\u0188"+
		"\3\2\2\2\u0188\u018e\3\2\2\2\u0189\u018b\7\17\2\2\u018a\u0189\3\2\2\2"+
		"\u018a\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018f\7\f\2\2\u018d\u018f"+
		"\4\16\17\2\u018e\u018a\3\2\2\2\u018e\u018d\3\2\2\2\u018fu\3\2\2\2\u0190"+
		"\u0193\7^\2\2\u0191\u0194\t\22\2\2\u0192\u0194\5x<\2\u0193\u0191\3\2\2"+
		"\2\u0193\u0192\3\2\2\2\u0194w\3\2\2\2\u0195\u0196\7w\2\2\u0196\u0197\5"+
		"|>\2\u0197\u0198\5|>\2\u0198\u0199\5|>\2\u0199\u019a\5|>\2\u019ay\3\2"+
		"\2\2\u019b\u019c\n\23\2\2\u019c{\3\2\2\2\u019d\u019e\t\t\2\2\u019e}\3"+
		"\2\2\2\u019f\u01aa\5>\37\2\u01a0\u01a5\5\32\r\2\u01a1\u01a4\5N\'\2\u01a2"+
		"\u01a4\5R)\2\u01a3\u01a1\3\2\2\2\u01a3\u01a2\3\2\2\2\u01a4\u01a7\3\2\2"+
		"\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5"+
		"\3\2\2\2\u01a8\u01a0\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa"+
		"\u01ab\3\2\2\2\u01ab\177\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01ae\7\177"+
		"\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\b@\4\2\u01b0\u0081\3\2\2\2-\2\3\u00c9"+
		"\u00d0\u00d7\u00dd\u00df\u00ea\u00ef\u00f1\u00fb\u00ff\u0103\u0109\u010e"+
		"\u0111\u011e\u0124\u0128\u012f\u0135\u0139\u013e\u0143\u0145\u014c\u014e"+
		"\u0152\u015b\u0168\u016e\u0172\u0175\u0178\u017b\u0183\u0187\u018a\u018e"+
		"\u0193\u01a3\u01a5\u01aa\5\b\2\2\7\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}