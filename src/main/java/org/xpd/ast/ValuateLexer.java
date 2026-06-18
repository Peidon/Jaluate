package org.xpd.ast;
// Generated from ValuateLexer.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
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
			null, "'true'", "'false'", "'null'", "'('", "')'", "'{'", null, "'['", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u01b2\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\5\35\u00cb\n\35\3\35\3\35\3\36\6\36\u00d0\n\36\r\36\16\36\u00d1\3\36"+
		"\3\36\3\37\7\37\u00d7\n\37\f\37\16\37\u00da\13\37\3\37\3\37\3\37\7\37"+
		"\u00df\n\37\f\37\16\37\u00e2\13\37\3 \3 \3 \3 \3 \3!\3!\3!\5!\u00ec\n"+
		"!\3\"\3\"\3\"\7\"\u00f1\n\"\f\"\16\"\u00f4\13\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\5#\u00fd\n#\3#\3#\5#\u0101\n#\3$\3$\5$\u0105\n$\3%\3%\7%\u0109\n%\f"+
		"%\16%\u010c\13%\3&\3&\5&\u0110\n&\3\'\5\'\u0113\n\'\3(\3(\3)\3)\3*\3*"+
		"\3+\3+\3,\3,\3-\5-\u0120\n-\3-\3-\3-\3-\5-\u0126\n-\3.\3.\5.\u012a\n."+
		"\3.\3.\3/\6/\u012f\n/\r/\16/\u0130\3\60\3\60\6\60\u0135\n\60\r\60\16\60"+
		"\u0136\3\61\3\61\5\61\u013b\n\61\3\61\6\61\u013e\n\61\r\61\16\61\u013f"+
		"\3\62\3\62\3\62\7\62\u0145\n\62\f\62\16\62\u0148\13\62\3\62\3\62\3\62"+
		"\3\62\7\62\u014e\n\62\f\62\16\62\u0151\13\62\3\62\5\62\u0154\n\62\3\63"+
		"\3\63\3\63\3\63\3\63\7\63\u015b\n\63\f\63\16\63\u015e\13\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\7\63\u0168\n\63\f\63\16\63\u016b\13\63"+
		"\3\63\3\63\3\63\5\63\u0170\n\63\3\64\3\64\5\64\u0174\n\64\3\65\5\65\u0177"+
		"\n\65\3\66\5\66\u017a\n\66\3\67\5\67\u017d\n\67\38\38\38\39\69\u0183\n"+
		"9\r9\169\u0184\3:\3:\5:\u0189\n:\3:\5:\u018c\n:\3:\3:\5:\u0190\n:\3;\3"+
		";\3;\5;\u0195\n;\3<\3<\3<\3<\3<\3<\3=\3=\3>\3>\3?\3?\3?\3?\7?\u01a5\n"+
		"?\f?\16?\u01a8\13?\7?\u01aa\n?\f?\16?\u01ad\13?\3@\3@\3@\3@\4\u015c\u0169"+
		"\2A\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36"+
		"\20 \21\"\22$\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35:\36<"+
		"\37> @!B\"D#F$H%J&L\'N\2P\2R\2T\2V\2X\2Z\2\\\2^\2`\2b\2d\2f\2h\2j\2l\2"+
		"n\2p\2r\2t\2v\2x\2z\2|\2~(\u0080)\4\2\3\24\5\2\13\f\17\17\"\"\4\2DDdd"+
		"\4\2TTtt\5\2C\\aac|\3\2\63;\3\2\62;\3\2\629\5\2\62;CHch\3\2\62\63\4\2"+
		"GGgg\4\2--//\7\2\2\13\r\16\20(*]_\u0081\7\2\2\13\r\16\20#%]_\u0081\4\2"+
		"\2]_\u0081\3\2\2\u0081\4\2\13\13\"\"\n\2$$\61\61^^ddhhppttvv\5\2\2!$$"+
		"^^\2\u01bf\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2"+
		"\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30"+
		"\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2"+
		"\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60"+
		"\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2"+
		"\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H"+
		"\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\3~\3\2\2\2\3\u0080\3\2\2\2\4\u0082\3\2"+
		"\2\2\6\u0087\3\2\2\2\b\u008d\3\2\2\2\n\u0092\3\2\2\2\f\u0094\3\2\2\2\16"+
		"\u0096\3\2\2\2\20\u0098\3\2\2\2\22\u009a\3\2\2\2\24\u009c\3\2\2\2\26\u009e"+
		"\3\2\2\2\30\u00a0\3\2\2\2\32\u00a2\3\2\2\2\34\u00a4\3\2\2\2\36\u00a6\3"+
		"\2\2\2 \u00a9\3\2\2\2\"\u00ac\3\2\2\2$\u00af\3\2\2\2&\u00b2\3\2\2\2(\u00b4"+
		"\3\2\2\2*\u00b7\3\2\2\2,\u00b9\3\2\2\2.\u00bc\3\2\2\2\60\u00be\3\2\2\2"+
		"\62\u00c0\3\2\2\2\64\u00c2\3\2\2\2\66\u00c4\3\2\2\28\u00c6\3\2\2\2:\u00ca"+
		"\3\2\2\2<\u00cf\3\2\2\2>\u00d8\3\2\2\2@\u00e3\3\2\2\2B\u00eb\3\2\2\2D"+
		"\u00ed\3\2\2\2F\u00fc\3\2\2\2H\u0104\3\2\2\2J\u0106\3\2\2\2L\u010f\3\2"+
		"\2\2N\u0112\3\2\2\2P\u0114\3\2\2\2R\u0116\3\2\2\2T\u0118\3\2\2\2V\u011a"+
		"\3\2\2\2X\u011c\3\2\2\2Z\u0125\3\2\2\2\\\u0129\3\2\2\2^\u012e\3\2\2\2"+
		"`\u0132\3\2\2\2b\u0138\3\2\2\2d\u0153\3\2\2\2f\u016f\3\2\2\2h\u0173\3"+
		"\2\2\2j\u0176\3\2\2\2l\u0179\3\2\2\2n\u017c\3\2\2\2p\u017e\3\2\2\2r\u0182"+
		"\3\2\2\2t\u0186\3\2\2\2v\u0191\3\2\2\2x\u0196\3\2\2\2z\u019c\3\2\2\2|"+
		"\u019e\3\2\2\2~\u01a0\3\2\2\2\u0080\u01ae\3\2\2\2\u0082\u0083\7v\2\2\u0083"+
		"\u0084\7t\2\2\u0084\u0085\7w\2\2\u0085\u0086\7g\2\2\u0086\5\3\2\2\2\u0087"+
		"\u0088\7h\2\2\u0088\u0089\7c\2\2\u0089\u008a\7n\2\2\u008a\u008b\7u\2\2"+
		"\u008b\u008c\7g\2\2\u008c\7\3\2\2\2\u008d\u008e\7p\2\2\u008e\u008f\7w"+
		"\2\2\u008f\u0090\7n\2\2\u0090\u0091\7n\2\2\u0091\t\3\2\2\2\u0092\u0093"+
		"\7*\2\2\u0093\13\3\2\2\2\u0094\u0095\7+\2\2\u0095\r\3\2\2\2\u0096\u0097"+
		"\7}\2\2\u0097\17\3\2\2\2\u0098\u0099\7\177\2\2\u0099\21\3\2\2\2\u009a"+
		"\u009b\7]\2\2\u009b\23\3\2\2\2\u009c\u009d\7_\2\2\u009d\25\3\2\2\2\u009e"+
		"\u009f\7.\2\2\u009f\27\3\2\2\2\u00a0\u00a1\7<\2\2\u00a1\31\3\2\2\2\u00a2"+
		"\u00a3\7\60\2\2\u00a3\33\3\2\2\2\u00a4\u00a5\7?\2\2\u00a5\35\3\2\2\2\u00a6"+
		"\u00a7\7~\2\2\u00a7\u00a8\7~\2\2\u00a8\37\3\2\2\2\u00a9\u00aa\7(\2\2\u00aa"+
		"\u00ab\7(\2\2\u00ab!\3\2\2\2\u00ac\u00ad\7?\2\2\u00ad\u00ae\7?\2\2\u00ae"+
		"#\3\2\2\2\u00af\u00b0\7#\2\2\u00b0\u00b1\7?\2\2\u00b1%\3\2\2\2\u00b2\u00b3"+
		"\7>\2\2\u00b3\'\3\2\2\2\u00b4\u00b5\7>\2\2\u00b5\u00b6\7?\2\2\u00b6)\3"+
		"\2\2\2\u00b7\u00b8\7@\2\2\u00b8+\3\2\2\2\u00b9\u00ba\7@\2\2\u00ba\u00bb"+
		"\7?\2\2\u00bb-\3\2\2\2\u00bc\u00bd\7#\2\2\u00bd/\3\2\2\2\u00be\u00bf\7"+
		"\61\2\2\u00bf\61\3\2\2\2\u00c0\u00c1\7-\2\2\u00c1\63\3\2\2\2\u00c2\u00c3"+
		"\7/\2\2\u00c3\65\3\2\2\2\u00c4\u00c5\7,\2\2\u00c5\67\3\2\2\2\u00c6\u00c7"+
		"\7\'\2\2\u00c79\3\2\2\2\u00c8\u00cb\5r9\2\u00c9\u00cb\5t:\2\u00ca\u00c8"+
		"\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b\35\2\2"+
		"\u00cd;\3\2\2\2\u00ce\u00d0\t\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3"+
		"\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\b\36\2\2\u00d4=\3\2\2\2\u00d5\u00d7\5R)\2\u00d6\u00d5\3\2\2\2\u00d7"+
		"\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2"+
		"\2\2\u00da\u00d8\3\2\2\2\u00db\u00e0\5N\'\2\u00dc\u00df\5N\'\2\u00dd\u00df"+
		"\5R)\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1?\3\2\2\2\u00e2\u00e0\3\2\2\2"+
		"\u00e3\u00e4\7&\2\2\u00e4\u00e5\7}\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7"+
		"\b \3\2\u00e7A\3\2\2\2\u00e8\u00ec\5D\"\2\u00e9\u00ec\5d\62\2\u00ea\u00ec"+
		"\5f\63\2\u00eb\u00e8\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec"+
		"C\3\2\2\2\u00ed\u00f2\7$\2\2\u00ee\u00f1\5v;\2\u00ef\u00f1\5z=\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5"+
		"\u00f6\7$\2\2\u00f6E\3\2\2\2\u00f7\u00fd\t\3\2\2\u00f8\u00f9\t\3\2\2\u00f9"+
		"\u00fd\t\4\2\2\u00fa\u00fb\t\4\2\2\u00fb\u00fd\t\3\2\2\u00fc\u00f7\3\2"+
		"\2\2\u00fc\u00f8\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe"+
		"\u0101\5d\62\2\u00ff\u0101\5f\63\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2"+
		"\2\2\u0101G\3\2\2\2\u0102\u0105\5J%\2\u0103\u0105\7\62\2\2\u0104\u0102"+
		"\3\2\2\2\u0104\u0103\3\2\2\2\u0105I\3\2\2\2\u0106\u010a\5P(\2\u0107\u0109"+
		"\5R)\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010bK\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u0110\5Z-\2\u010e"+
		"\u0110\5\\.\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2\u0110M\3\2\2\2\u0111"+
		"\u0113\t\5\2\2\u0112\u0111\3\2\2\2\u0113O\3\2\2\2\u0114\u0115\t\6\2\2"+
		"\u0115Q\3\2\2\2\u0116\u0117\t\7\2\2\u0117S\3\2\2\2\u0118\u0119\t\b\2\2"+
		"\u0119U\3\2\2\2\u011a\u011b\t\t\2\2\u011bW\3\2\2\2\u011c\u011d\t\n\2\2"+
		"\u011dY\3\2\2\2\u011e\u0120\5^/\2\u011f\u011e\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0126\5`\60\2\u0122\u0123\5^/\2\u0123\u0124"+
		"\7\60\2\2\u0124\u0126\3\2\2\2\u0125\u011f\3\2\2\2\u0125\u0122\3\2\2\2"+
		"\u0126[\3\2\2\2\u0127\u012a\5^/\2\u0128\u012a\5Z-\2\u0129\u0127\3\2\2"+
		"\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\5b\61\2\u012c]"+
		"\3\2\2\2\u012d\u012f\5R)\2\u012e\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131_\3\2\2\2\u0132\u0134\7\60\2\2"+
		"\u0133\u0135\5R)\2\u0134\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0134"+
		"\3\2\2\2\u0136\u0137\3\2\2\2\u0137a\3\2\2\2\u0138\u013a\t\13\2\2\u0139"+
		"\u013b\t\f\2\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2"+
		"\2\2\u013c\u013e\5R)\2\u013d\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u013d"+
		"\3\2\2\2\u013f\u0140\3\2\2\2\u0140c\3\2\2\2\u0141\u0146\7)\2\2\u0142\u0145"+
		"\5j\65\2\u0143\u0145\5p8\2\u0144\u0142\3\2\2\2\u0144\u0143\3\2\2\2\u0145"+
		"\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2"+
		"\2\2\u0148\u0146\3\2\2\2\u0149\u0154\7)\2\2\u014a\u014f\7$\2\2\u014b\u014e"+
		"\5l\66\2\u014c\u014e\5p8\2\u014d\u014b\3\2\2\2\u014d\u014c\3\2\2\2\u014e"+
		"\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2"+
		"\2\2\u0151\u014f\3\2\2\2\u0152\u0154\7$\2\2\u0153\u0141\3\2\2\2\u0153"+
		"\u014a\3\2\2\2\u0154e\3\2\2\2\u0155\u0156\7)\2\2\u0156\u0157\7)\2\2\u0157"+
		"\u0158\7)\2\2\u0158\u015c\3\2\2\2\u0159\u015b\5h\64\2\u015a\u0159\3\2"+
		"\2\2\u015b\u015e\3\2\2\2\u015c\u015d\3\2\2\2\u015c\u015a\3\2\2\2\u015d"+
		"\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0160\7)\2\2\u0160\u0161\7)\2"+
		"\2\u0161\u0170\7)\2\2\u0162\u0163\7$\2\2\u0163\u0164\7$\2\2\u0164\u0165"+
		"\7$\2\2\u0165\u0169\3\2\2\2\u0166\u0168\5h\64\2\u0167\u0166\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u016a\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016c\3\2"+
		"\2\2\u016b\u0169\3\2\2\2\u016c\u016d\7$\2\2\u016d\u016e\7$\2\2\u016e\u0170"+
		"\7$\2\2\u016f\u0155\3\2\2\2\u016f\u0162\3\2\2\2\u0170g\3\2\2\2\u0171\u0174"+
		"\5n\67\2\u0172\u0174\5p8\2\u0173\u0171\3\2\2\2\u0173\u0172\3\2\2\2\u0174"+
		"i\3\2\2\2\u0175\u0177\t\r\2\2\u0176\u0175\3\2\2\2\u0177k\3\2\2\2\u0178"+
		"\u017a\t\16\2\2\u0179\u0178\3\2\2\2\u017am\3\2\2\2\u017b\u017d\t\17\2"+
		"\2\u017c\u017b\3\2\2\2\u017do\3\2\2\2\u017e\u017f\7^\2\2\u017f\u0180\t"+
		"\20\2\2\u0180q\3\2\2\2\u0181\u0183\t\21\2\2\u0182\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185s\3\2\2\2"+
		"\u0186\u0188\7^\2\2\u0187\u0189\5r9\2\u0188\u0187\3\2\2\2\u0188\u0189"+
		"\3\2\2\2\u0189\u018f\3\2\2\2\u018a\u018c\7\17\2\2\u018b\u018a\3\2\2\2"+
		"\u018b\u018c\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u0190\7\f\2\2\u018e\u0190"+
		"\4\16\17\2\u018f\u018b\3\2\2\2\u018f\u018e\3\2\2\2\u0190u\3\2\2\2\u0191"+
		"\u0194\7^\2\2\u0192\u0195\t\22\2\2\u0193\u0195\5x<\2\u0194\u0192\3\2\2"+
		"\2\u0194\u0193\3\2\2\2\u0195w\3\2\2\2\u0196\u0197\7w\2\2\u0197\u0198\5"+
		"|>\2\u0198\u0199\5|>\2\u0199\u019a\5|>\2\u019a\u019b\5|>\2\u019by\3\2"+
		"\2\2\u019c\u019d\n\23\2\2\u019d{\3\2\2\2\u019e\u019f\t\t\2\2\u019f}\3"+
		"\2\2\2\u01a0\u01ab\5>\37\2\u01a1\u01a6\5\32\r\2\u01a2\u01a5\5N\'\2\u01a3"+
		"\u01a5\5R)\2\u01a4\u01a2\3\2\2\2\u01a4\u01a3\3\2\2\2\u01a5\u01a8\3\2\2"+
		"\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6"+
		"\3\2\2\2\u01a9\u01a1\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab"+
		"\u01ac\3\2\2\2\u01ac\177\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ae\u01af\7\177"+
		"\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\b@\4\2\u01b1\u0081\3\2\2\2-\2\3\u00ca"+
		"\u00d1\u00d8\u00de\u00e0\u00eb\u00f0\u00f2\u00fc\u0100\u0104\u010a\u010f"+
		"\u0112\u011f\u0125\u0129\u0130\u0136\u013a\u013f\u0144\u0146\u014d\u014f"+
		"\u0153\u015c\u0169\u016f\u0173\u0176\u0179\u017c\u0184\u0188\u018b\u018f"+
		"\u0194\u01a4\u01a6\u01ab\5\b\2\2\7\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}