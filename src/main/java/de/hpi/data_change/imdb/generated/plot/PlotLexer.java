// Generated from /home/leon/IdeaProjects/IMDBParser/resources/grammars/Plot.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.plot;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PlotLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STARTSIGNAL=1, PLOTSTARTLINE=2, NEWLINE=3, TITLESTART=4, PLOTSTART=5, 
		AUTHORSTART=6, ANYSTRING=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"STARTSIGNAL", "PLOTSTARTLINE", "NEWLINE", "TITLESTART", "PLOTSTART", 
		"AUTHORSTART", "ANYSTRING", "MV", "PL", "BY", "ANYTHING", "NL"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STARTSIGNAL", "PLOTSTARTLINE", "NEWLINE", "TITLESTART", "PLOTSTART", 
		"AUTHORSTART", "ANYSTRING"
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


	public PlotLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Plot.g4"; }

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
		case 0:
			STARTSIGNAL_action((RuleContext)_localctx, actionIndex);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\u00ac\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\6\b\u008e\n"+
		"\b\r\b\16\b\u008f\3\b\3\b\3\b\5\b\u0095\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\5\r\u00ab"+
		"\n\r\3\u008f\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\2\27\2\31"+
		"\2\3\2\3\4\2\f\f\17\17\2\u00ab\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\33\3\2\2\2\5\62\3\2\2"+
		"\2\7\u0084\3\2\2\2\t\u0086\3\2\2\2\13\u0088\3\2\2\2\r\u008a\3\2\2\2\17"+
		"\u0094\3\2\2\2\21\u0096\3\2\2\2\23\u009b\3\2\2\2\25\u00a0\3\2\2\2\27\u00a5"+
		"\3\2\2\2\31\u00aa\3\2\2\2\33\34\7?\2\2\34\35\7?\2\2\35\36\7?\2\2\36\37"+
		"\7?\2\2\37 \7?\2\2 !\7?\2\2!\"\7?\2\2\"#\7?\2\2#$\7?\2\2$%\7?\2\2%&\7"+
		"?\2\2&\'\7?\2\2\'(\7?\2\2()\7?\2\2)*\7?\2\2*+\7?\2\2+,\7?\2\2,-\7?\2\2"+
		"-.\7?\2\2./\3\2\2\2/\60\5\31\r\2\60\61\b\2\2\2\61\4\3\2\2\2\62\63\7/\2"+
		"\2\63\64\7/\2\2\64\65\7/\2\2\65\66\7/\2\2\66\67\7/\2\2\678\7/\2\289\7"+
		"/\2\29:\7/\2\2:;\7/\2\2;<\7/\2\2<=\7/\2\2=>\7/\2\2>?\7/\2\2?@\7/\2\2@"+
		"A\7/\2\2AB\7/\2\2BC\7/\2\2CD\7/\2\2DE\7/\2\2EF\7/\2\2FG\7/\2\2GH\7/\2"+
		"\2HI\7/\2\2IJ\7/\2\2JK\7/\2\2KL\7/\2\2LM\7/\2\2MN\7/\2\2NO\7/\2\2OP\7"+
		"/\2\2PQ\7/\2\2QR\7/\2\2RS\7/\2\2ST\7/\2\2TU\7/\2\2UV\7/\2\2VW\7/\2\2W"+
		"X\7/\2\2XY\7/\2\2YZ\7/\2\2Z[\7/\2\2[\\\7/\2\2\\]\7/\2\2]^\7/\2\2^_\7/"+
		"\2\2_`\7/\2\2`a\7/\2\2ab\7/\2\2bc\7/\2\2cd\7/\2\2de\7/\2\2ef\7/\2\2fg"+
		"\7/\2\2gh\7/\2\2hi\7/\2\2ij\7/\2\2jk\7/\2\2kl\7/\2\2lm\7/\2\2mn\7/\2\2"+
		"no\7/\2\2op\7/\2\2pq\7/\2\2qr\7/\2\2rs\7/\2\2st\7/\2\2tu\7/\2\2uv\7/\2"+
		"\2vw\7/\2\2wx\7/\2\2xy\7/\2\2yz\7/\2\2z{\7/\2\2{|\7/\2\2|}\7/\2\2}~\7"+
		"/\2\2~\177\7/\2\2\177\u0080\7/\2\2\u0080\u0081\7/\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\u0083\5\31\r\2\u0083\6\3\2\2\2\u0084\u0085\5\31\r\2\u0085\b"+
		"\3\2\2\2\u0086\u0087\5\21\t\2\u0087\n\3\2\2\2\u0088\u0089\5\23\n\2\u0089"+
		"\f\3\2\2\2\u008a\u008b\5\25\13\2\u008b\16\3\2\2\2\u008c\u008e\5\27\f\2"+
		"\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u0090\u0095\3\2\2\2\u0091\u0095\5\21\t\2\u0092\u0095\5\23\n\2"+
		"\u0093\u0095\5\25\13\2\u0094\u008d\3\2\2\2\u0094\u0091\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0093\3\2\2\2\u0095\20\3\2\2\2\u0096\u0097\7O\2\2\u0097"+
		"\u0098\7X\2\2\u0098\u0099\7<\2\2\u0099\u009a\7\"\2\2\u009a\22\3\2\2\2"+
		"\u009b\u009c\7R\2\2\u009c\u009d\7N\2\2\u009d\u009e\7<\2\2\u009e\u009f"+
		"\7\"\2\2\u009f\24\3\2\2\2\u00a0\u00a1\7D\2\2\u00a1\u00a2\7[\2\2\u00a2"+
		"\u00a3\7<\2\2\u00a3\u00a4\7\"\2\2\u00a4\26\3\2\2\2\u00a5\u00a6\n\2\2\2"+
		"\u00a6\30\3\2\2\2\u00a7\u00ab\7\f\2\2\u00a8\u00a9\7\17\2\2\u00a9\u00ab"+
		"\7\f\2\2\u00aa\u00a7\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\32\3\2\2\2\6\2"+
		"\u008f\u0094\u00aa\3\3\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}