// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources\Directors.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DirectorsLexer extends Lexer {
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


	public DirectorsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Directors.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\7\u0086\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\23\n\2\r\2"+
		"\16\2\24\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\6\6|\n"+
		"\6\r\6\16\6}\3\7\3\7\3\7\5\7\u0083\n\7\3\b\3\b\2\2\t\3\3\5\4\7\5\t\6\13"+
		"\7\r\2\17\2\3\2\3\4\2\13\f\17\17\2\u0086\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\22\3\2\2\2\5\26\3\2\2\2\7\'\3\2\2\2"+
		"\tx\3\2\2\2\13{\3\2\2\2\r\u0082\3\2\2\2\17\u0084\3\2\2\2\21\23\5\17\b"+
		"\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\4\3\2\2"+
		"\2\26\27\7/\2\2\27\30\7/\2\2\30\31\7/\2\2\31\32\7/\2\2\32\33\7\13\2\2"+
		"\33\34\7\13\2\2\34\35\7\13\2\2\35\36\7/\2\2\36\37\7/\2\2\37 \7/\2\2 !"+
		"\7/\2\2!\"\7/\2\2\"#\7/\2\2#$\3\2\2\2$%\5\r\7\2%&\b\3\2\2&\6\3\2\2\2\'"+
		"(\7/\2\2()\7/\2\2)*\7/\2\2*+\7/\2\2+,\7/\2\2,-\7/\2\2-.\7/\2\2./\7/\2"+
		"\2/\60\7/\2\2\60\61\7/\2\2\61\62\7/\2\2\62\63\7/\2\2\63\64\7/\2\2\64\65"+
		"\7/\2\2\65\66\7/\2\2\66\67\7/\2\2\678\7/\2\289\7/\2\29:\7/\2\2:;\7/\2"+
		"\2;<\7/\2\2<=\7/\2\2=>\7/\2\2>?\7/\2\2?@\7/\2\2@A\7/\2\2AB\7/\2\2BC\7"+
		"/\2\2CD\7/\2\2DE\7/\2\2EF\7/\2\2FG\7/\2\2GH\7/\2\2HI\7/\2\2IJ\7/\2\2J"+
		"K\7/\2\2KL\7/\2\2LM\7/\2\2MN\7/\2\2NO\7/\2\2OP\7/\2\2PQ\7/\2\2QR\7/\2"+
		"\2RS\7/\2\2ST\7/\2\2TU\7/\2\2UV\7/\2\2VW\7/\2\2WX\7/\2\2XY\7/\2\2YZ\7"+
		"/\2\2Z[\7/\2\2[\\\7/\2\2\\]\7/\2\2]^\7/\2\2^_\7/\2\2_`\7/\2\2`a\7/\2\2"+
		"ab\7/\2\2bc\7/\2\2cd\7/\2\2de\7/\2\2ef\7/\2\2fg\7/\2\2gh\7/\2\2hi\7/\2"+
		"\2ij\7/\2\2jk\7/\2\2kl\7/\2\2lm\7/\2\2mn\7/\2\2no\7/\2\2op\7/\2\2pq\7"+
		"/\2\2qr\7/\2\2rs\7/\2\2st\7/\2\2tu\3\2\2\2uv\5\r\7\2vw\b\4\3\2w\b\3\2"+
		"\2\2xy\5\r\7\2y\n\3\2\2\2z|\n\2\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3"+
		"\2\2\2~\f\3\2\2\2\177\u0083\7\f\2\2\u0080\u0081\7\17\2\2\u0081\u0083\7"+
		"\f\2\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0083\16\3\2\2\2\u0084\u0085"+
		"\7\13\2\2\u0085\20\3\2\2\2\6\2\24}\u0082\4\3\3\2\3\4\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}