// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\TEst.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.ratings;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TEstParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEP=1, STARTSIGNAL=2, ENDSIGNAL=3, NEWLINE=4, ANYTHING=5;
	public static final int
		RULE_r = 0, RULE_anyToken = 1, RULE_sep = 2, RULE_start = 3, RULE_end = 4, 
		RULE_nl = 5, RULE_any = 6;
	public static final String[] ruleNames = {
		"r", "anyToken", "sep", "start", "end", "nl", "any"
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

	@Override
	public String getGrammarFileName() { return "TEst.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TEstParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TEstParser.EOF, 0); }
		public List<AnyTokenContext> anyToken() {
			return getRuleContexts(AnyTokenContext.class);
		}
		public AnyTokenContext anyToken(int i) {
			return getRuleContext(AnyTokenContext.class,i);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).exitR(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEP) | (1L << STARTSIGNAL) | (1L << ENDSIGNAL) | (1L << NEWLINE) | (1L << ANYTHING))) != 0)) {
				{
				{
				setState(14);
				anyToken();
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
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

	public static class AnyTokenContext extends ParserRuleContext {
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public NlContext nl() {
			return getRuleContext(NlContext.class,0);
		}
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public AnyTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).enterAnyToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).exitAnyToken(this);
		}
	}

	public final AnyTokenContext anyToken() throws RecognitionException {
		AnyTokenContext _localctx = new AnyTokenContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_anyToken);
		try {
			setState(27);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEP:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				sep();
				}
				break;
			case STARTSIGNAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				start();
				}
				break;
			case ENDSIGNAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				end();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(25);
				nl();
				}
				break;
			case ANYTHING:
				enterOuterAlt(_localctx, 5);
				{
				setState(26);
				any();
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

	public static class SepContext extends ParserRuleContext {
		public TerminalNode SEP() { return getToken(TEstParser.SEP, 0); }
		public SepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).enterSep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).exitSep(this);
		}
	}

	public final SepContext sep() throws RecognitionException {
		SepContext _localctx = new SepContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(SEP);
			System.out.println("Matched SEP");
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

	public static class StartContext extends ParserRuleContext {
		public TerminalNode STARTSIGNAL() { return getToken(TEstParser.STARTSIGNAL, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(STARTSIGNAL);
			System.out.println("Matched STARTSIGNAL");
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

	public static class EndContext extends ParserRuleContext {
		public TerminalNode ENDSIGNAL() { return getToken(TEstParser.ENDSIGNAL, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).exitEnd(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(ENDSIGNAL);
			System.out.println("Matched ENDSIGNAL");
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

	public static class NlContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(TEstParser.NEWLINE, 0); }
		public NlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).enterNl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).exitNl(this);
		}
	}

	public final NlContext nl() throws RecognitionException {
		NlContext _localctx = new NlContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_nl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(NEWLINE);
			System.out.println("Matched NEWLINE");
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

	public static class AnyContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(TEstParser.ANYTHING, 0); }
		public AnyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).enterAny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TEstListener ) ((TEstListener)listener).exitAny(this);
		}
	}

	public final AnyContext any() throws RecognitionException {
		AnyContext _localctx = new AnyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_any);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(ANYTHING);
			System.out.println("Matched ANYTHING");
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7/\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\7\2\22\n\2\f\2\16\2\25"+
		"\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2,\2\23"+
		"\3\2\2\2\4\35\3\2\2\2\6\37\3\2\2\2\b\"\3\2\2\2\n%\3\2\2\2\f(\3\2\2\2\16"+
		"+\3\2\2\2\20\22\5\4\3\2\21\20\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24"+
		"\3\2\2\2\24\26\3\2\2\2\25\23\3\2\2\2\26\27\7\2\2\3\27\3\3\2\2\2\30\36"+
		"\5\6\4\2\31\36\5\b\5\2\32\36\5\n\6\2\33\36\5\f\7\2\34\36\5\16\b\2\35\30"+
		"\3\2\2\2\35\31\3\2\2\2\35\32\3\2\2\2\35\33\3\2\2\2\35\34\3\2\2\2\36\5"+
		"\3\2\2\2\37 \7\3\2\2 !\b\4\1\2!\7\3\2\2\2\"#\7\4\2\2#$\b\5\1\2$\t\3\2"+
		"\2\2%&\7\5\2\2&\'\b\6\1\2\'\13\3\2\2\2()\7\6\2\2)*\b\7\1\2*\r\3\2\2\2"+
		"+,\7\7\2\2,-\b\b\1\2-\17\3\2\2\2\4\23\35";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}