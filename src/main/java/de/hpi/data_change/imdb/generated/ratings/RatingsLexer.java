// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Ratings.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.ratings;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RatingsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEP=1, STARTSIGNAL=2, ENDSIGNAL=3, NEWLINE=4, ANYTHING=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SEP", "STARTSIGNAL", "ENDSIGNAL", "NEWLINE", "ANYTHING", "NL", "SPACE"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SEP", "STARTSIGNAL", "ENDSIGNAL", "NEWLINE", "ANYTHING"
	};
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


	public RatingsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Ratings.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1:
			STARTSIGNAL_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			ENDSIGNAL_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STARTSIGNAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			System.out.println("Matched STARTSIGNAL");
			break;
		}
	}
	private void ENDSIGNAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			System.out.println("Matched ENDSIGNAL");
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\7\u00b9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\23\n\2\r\2"+
		"\16\2\24\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\6\6\u00af\n"+
		"\6\r\6\16\6\u00b0\3\7\3\7\3\7\5\7\u00b6\n\7\3\b\3\b\2\2\t\3\3\5\4\7\5"+
		"\t\6\13\7\r\2\17\2\3\2\3\5\2\f\f\17\17\"\"\2\u00ba\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\22\3\2\2\2\5\26\3\2\2\2\7"+
		"X\3\2\2\2\t\u00ab\3\2\2\2\13\u00ae\3\2\2\2\r\u00b5\3\2\2\2\17\u00b7\3"+
		"\2\2\2\21\23\5\17\b\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25"+
		"\3\2\2\2\25\4\3\2\2\2\26\27\7O\2\2\27\30\7Q\2\2\30\31\7X\2\2\31\32\7K"+
		"\2\2\32\33\7G\2\2\33\34\7\"\2\2\34\35\7T\2\2\35\36\7C\2\2\36\37\7V\2\2"+
		"\37 \7K\2\2 !\7P\2\2!\"\7I\2\2\"#\7U\2\2#$\7\"\2\2$%\7T\2\2%&\7G\2\2&"+
		"\'\7R\2\2\'(\7Q\2\2()\7T\2\2)*\7V\2\2*+\3\2\2\2+-\5\r\7\2,.\5\r\7\2-,"+
		"\3\2\2\2-.\3\2\2\2./\3\2\2\2/\60\7P\2\2\60\61\7g\2\2\61\62\7y\2\2\62\63"+
		"\7\"\2\2\63\64\7\"\2\2\64\65\7F\2\2\65\66\7k\2\2\66\67\7u\2\2\678\7v\2"+
		"\289\7t\2\29:\7k\2\2:;\7d\2\2;<\7w\2\2<=\7v\2\2=>\7k\2\2>?\7q\2\2?@\7"+
		"p\2\2@A\7\"\2\2AB\7\"\2\2BC\7X\2\2CD\7q\2\2DE\7v\2\2EF\7g\2\2FG\7u\2\2"+
		"GH\7\"\2\2HI\7\"\2\2IJ\7T\2\2JK\7c\2\2KL\7p\2\2LM\7m\2\2MN\7\"\2\2NO\7"+
		"\"\2\2OP\7V\2\2PQ\7k\2\2QR\7v\2\2RS\7n\2\2ST\7g\2\2TU\3\2\2\2UV\5\r\7"+
		"\2VW\b\3\2\2W\6\3\2\2\2XY\5\r\7\2YZ\7/\2\2Z[\7/\2\2[\\\7/\2\2\\]\7/\2"+
		"\2]^\7/\2\2^_\7/\2\2_`\7/\2\2`a\7/\2\2ab\7/\2\2bc\7/\2\2cd\7/\2\2de\7"+
		"/\2\2ef\7/\2\2fg\7/\2\2gh\7/\2\2hi\7/\2\2ij\7/\2\2jk\7/\2\2kl\7/\2\2l"+
		"m\7/\2\2mn\7/\2\2no\7/\2\2op\7/\2\2pq\7/\2\2qr\7/\2\2rs\7/\2\2st\7/\2"+
		"\2tu\7/\2\2uv\7/\2\2vw\7/\2\2wx\7/\2\2xy\7/\2\2yz\7/\2\2z{\7/\2\2{|\7"+
		"/\2\2|}\7/\2\2}~\7/\2\2~\177\7/\2\2\177\u0080\7/\2\2\u0080\u0081\7/\2"+
		"\2\u0081\u0082\7/\2\2\u0082\u0083\7/\2\2\u0083\u0084\7/\2\2\u0084\u0085"+
		"\7/\2\2\u0085\u0086\7/\2\2\u0086\u0087\7/\2\2\u0087\u0088\7/\2\2\u0088"+
		"\u0089\7/\2\2\u0089\u008a\7/\2\2\u008a\u008b\7/\2\2\u008b\u008c\7/\2\2"+
		"\u008c\u008d\7/\2\2\u008d\u008e\7/\2\2\u008e\u008f\7/\2\2\u008f\u0090"+
		"\7/\2\2\u0090\u0091\7/\2\2\u0091\u0092\7/\2\2\u0092\u0093\7/\2\2\u0093"+
		"\u0094\7/\2\2\u0094\u0095\7/\2\2\u0095\u0096\7/\2\2\u0096\u0097\7/\2\2"+
		"\u0097\u0098\7/\2\2\u0098\u0099\7/\2\2\u0099\u009a\7/\2\2\u009a\u009b"+
		"\7/\2\2\u009b\u009c\7/\2\2\u009c\u009d\7/\2\2\u009d\u009e\7/\2\2\u009e"+
		"\u009f\7/\2\2\u009f\u00a0\7/\2\2\u00a0\u00a1\7/\2\2\u00a1\u00a2\7/\2\2"+
		"\u00a2\u00a3\7/\2\2\u00a3\u00a4\7/\2\2\u00a4\u00a5\7/\2\2\u00a5\u00a6"+
		"\7/\2\2\u00a6\u00a7\7/\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\5\r\7\2\u00a9"+
		"\u00aa\b\4\3\2\u00aa\b\3\2\2\2\u00ab\u00ac\5\r\7\2\u00ac\n\3\2\2\2\u00ad"+
		"\u00af\n\2\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\f\3\2\2\2\u00b2\u00b6\7\f\2\2\u00b3\u00b4"+
		"\7\17\2\2\u00b4\u00b6\7\f\2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2"+
		"\u00b6\16\3\2\2\2\u00b7\u00b8\7\"\2\2\u00b8\20\3\2\2\2\7\2\24-\u00b0\u00b5"+
		"\4\3\3\2\3\4\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}