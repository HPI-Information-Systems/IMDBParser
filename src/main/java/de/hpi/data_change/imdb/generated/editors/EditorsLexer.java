// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Editors.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.editors;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EditorsLexer extends Lexer {
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
		"SEP", "STARTSIGNAL", "ENDSIGNAL", "NEWLINE", "ANYTHING", "NL", "TAB"
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


	public EditorsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Editors.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\7\u0097\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\23\n\2\r\2"+
		"\16\2\24\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\6\6\u008d"+
		"\n\6\r\6\16\6\u008e\3\7\3\7\3\7\5\7\u0094\n\7\3\b\3\b\2\2\t\3\3\5\4\7"+
		"\5\t\6\13\7\r\2\17\2\3\2\3\4\2\13\f\17\17\2\u0097\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\22\3\2\2\2\5\26\3\2\2\2\7"+
		"8\3\2\2\2\t\u0089\3\2\2\2\13\u008c\3\2\2\2\r\u0093\3\2\2\2\17\u0095\3"+
		"\2\2\2\21\23\5\17\b\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25"+
		"\3\2\2\2\25\4\3\2\2\2\26\27\7/\2\2\27\30\7/\2\2\30\31\7/\2\2\31\32\7/"+
		"\2\2\32\33\7\"\2\2\33\34\7\"\2\2\34\35\7\"\2\2\35\36\7\"\2\2\36\37\7\""+
		"\2\2\37 \7\"\2\2 !\7\"\2\2!\"\7\"\2\2\"#\7\"\2\2#$\7\"\2\2$%\7\"\2\2%"+
		"&\7\"\2\2&\'\7\"\2\2\'(\7\"\2\2()\7\"\2\2)*\7\"\2\2*+\7\"\2\2+,\7\"\2"+
		"\2,-\7\"\2\2-.\7\"\2\2./\7/\2\2/\60\7/\2\2\60\61\7/\2\2\61\62\7/\2\2\62"+
		"\63\7/\2\2\63\64\7/\2\2\64\65\3\2\2\2\65\66\5\r\7\2\66\67\b\3\2\2\67\6"+
		"\3\2\2\289\7/\2\29:\7/\2\2:;\7/\2\2;<\7/\2\2<=\7/\2\2=>\7/\2\2>?\7/\2"+
		"\2?@\7/\2\2@A\7/\2\2AB\7/\2\2BC\7/\2\2CD\7/\2\2DE\7/\2\2EF\7/\2\2FG\7"+
		"/\2\2GH\7/\2\2HI\7/\2\2IJ\7/\2\2JK\7/\2\2KL\7/\2\2LM\7/\2\2MN\7/\2\2N"+
		"O\7/\2\2OP\7/\2\2PQ\7/\2\2QR\7/\2\2RS\7/\2\2ST\7/\2\2TU\7/\2\2UV\7/\2"+
		"\2VW\7/\2\2WX\7/\2\2XY\7/\2\2YZ\7/\2\2Z[\7/\2\2[\\\7/\2\2\\]\7/\2\2]^"+
		"\7/\2\2^_\7/\2\2_`\7/\2\2`a\7/\2\2ab\7/\2\2bc\7/\2\2cd\7/\2\2de\7/\2\2"+
		"ef\7/\2\2fg\7/\2\2gh\7/\2\2hi\7/\2\2ij\7/\2\2jk\7/\2\2kl\7/\2\2lm\7/\2"+
		"\2mn\7/\2\2no\7/\2\2op\7/\2\2pq\7/\2\2qr\7/\2\2rs\7/\2\2st\7/\2\2tu\7"+
		"/\2\2uv\7/\2\2vw\7/\2\2wx\7/\2\2xy\7/\2\2yz\7/\2\2z{\7/\2\2{|\7/\2\2|"+
		"}\7/\2\2}~\7/\2\2~\177\7/\2\2\177\u0080\7/\2\2\u0080\u0081\7/\2\2\u0081"+
		"\u0082\7/\2\2\u0082\u0083\7/\2\2\u0083\u0084\7/\2\2\u0084\u0085\7/\2\2"+
		"\u0085\u0086\3\2\2\2\u0086\u0087\5\r\7\2\u0087\u0088\b\4\3\2\u0088\b\3"+
		"\2\2\2\u0089\u008a\5\r\7\2\u008a\n\3\2\2\2\u008b\u008d\n\2\2\2\u008c\u008b"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\f\3\2\2\2\u0090\u0094\7\f\2\2\u0091\u0092\7\17\2\2\u0092\u0094\7\f\2"+
		"\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2\2\2\u0094\16\3\2\2\2\u0095\u0096"+
		"\7\13\2\2\u0096\20\3\2\2\2\6\2\24\u008e\u0093\4\3\3\2\3\4\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}