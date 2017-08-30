// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Countries.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.countries;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CountriesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEP=1, STARTSIGNAL=2, ENDSIGNAL=3, NEWLINE=4, ANYTHING=5;
	public static final int
		RULE_r = 0, RULE_anythingButStart = 1, RULE_startSignal = 2, RULE_anyline = 3, 
		RULE_country = 4, RULE_anyLineOrEOF = 5, RULE_countryName = 6, RULE_title = 7;
	public static final String[] ruleNames = {
		"r", "anythingButStart", "startSignal", "anyline", "country", "anyLineOrEOF", 
		"countryName", "title"
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
	public String getGrammarFileName() { return "Countries.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CountriesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public AnythingButStartContext anythingButStart() {
			return getRuleContext(AnythingButStartContext.class,0);
		}
		public StartSignalContext startSignal() {
			return getRuleContext(StartSignalContext.class,0);
		}
		public TerminalNode ENDSIGNAL() { return getToken(CountriesParser.ENDSIGNAL, 0); }
		public AnyLineOrEOFContext anyLineOrEOF() {
			return getRuleContext(AnyLineOrEOFContext.class,0);
		}
		public List<CountryContext> country() {
			return getRuleContexts(CountryContext.class);
		}
		public CountryContext country(int i) {
			return getRuleContext(CountryContext.class,i);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).exitR(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			anythingButStart();
			setState(17);
			startSignal();
			System.out.println("Starting Country parsing");
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ANYTHING) {
				{
				{
				setState(19);
				country();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Finished Country parsing");
			setState(26);
			match(ENDSIGNAL);
			setState(27);
			anyLineOrEOF();
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

	public static class AnythingButStartContext extends ParserRuleContext {
		public List<AnylineContext> anyline() {
			return getRuleContexts(AnylineContext.class);
		}
		public AnylineContext anyline(int i) {
			return getRuleContext(AnylineContext.class,i);
		}
		public List<TerminalNode> ENDSIGNAL() { return getTokens(CountriesParser.ENDSIGNAL); }
		public TerminalNode ENDSIGNAL(int i) {
			return getToken(CountriesParser.ENDSIGNAL, i);
		}
		public AnythingButStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anythingButStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).enterAnythingButStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).exitAnythingButStart(this);
		}
	}

	public final AnythingButStartContext anythingButStart() throws RecognitionException {
		AnythingButStartContext _localctx = new AnythingButStartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_anythingButStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEP) | (1L << ENDSIGNAL) | (1L << NEWLINE) | (1L << ANYTHING))) != 0)) {
				{
				setState(31);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEP:
				case NEWLINE:
				case ANYTHING:
					{
					setState(29);
					anyline();
					}
					break;
				case ENDSIGNAL:
					{
					setState(30);
					match(ENDSIGNAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Matched Anything but start");
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

	public static class StartSignalContext extends ParserRuleContext {
		public TerminalNode STARTSIGNAL() { return getToken(CountriesParser.STARTSIGNAL, 0); }
		public StartSignalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startSignal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).enterStartSignal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).exitStartSignal(this);
		}
	}

	public final StartSignalContext startSignal() throws RecognitionException {
		StartSignalContext _localctx = new StartSignalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_startSignal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(STARTSIGNAL);
			System.out.println("Matched Startsignal");
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

	public static class AnylineContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(CountriesParser.NEWLINE, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(CountriesParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(CountriesParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(CountriesParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(CountriesParser.SEP, i);
		}
		public AnylineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).enterAnyline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).exitAnyline(this);
		}
	}

	public final AnylineContext anyline() throws RecognitionException {
		AnylineContext _localctx = new AnylineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_anyline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP || _la==ANYTHING) {
				{
				{
				setState(41);
				_la = _input.LA(1);
				if ( !(_la==SEP || _la==ANYTHING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
			match(NEWLINE);
			System.out.println("Matched Anyline");
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

	public static class CountryContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public TerminalNode SEP() { return getToken(CountriesParser.SEP, 0); }
		public CountryNameContext countryName() {
			return getRuleContext(CountryNameContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(CountriesParser.NEWLINE, 0); }
		public CountryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_country; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).enterCountry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).exitCountry(this);
		}
	}

	public final CountryContext country() throws RecognitionException {
		CountryContext _localctx = new CountryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_country);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			title();
			setState(51);
			match(SEP);
			setState(52);
			countryName();
			setState(53);
			match(NEWLINE);
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

	public static class AnyLineOrEOFContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(CountriesParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(CountriesParser.EOF, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(CountriesParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(CountriesParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(CountriesParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(CountriesParser.SEP, i);
		}
		public AnyLineOrEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyLineOrEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).enterAnyLineOrEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).exitAnyLineOrEOF(this);
		}
	}

	public final AnyLineOrEOFContext anyLineOrEOF() throws RecognitionException {
		AnyLineOrEOFContext _localctx = new AnyLineOrEOFContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_anyLineOrEOF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP || _la==ANYTHING) {
				{
				{
				setState(55);
				_la = _input.LA(1);
				if ( !(_la==SEP || _la==ANYTHING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class CountryNameContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(CountriesParser.ANYTHING, 0); }
		public CountryNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_countryName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).enterCountryName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).exitCountryName(this);
		}
	}

	public final CountryNameContext countryName() throws RecognitionException {
		CountryNameContext _localctx = new CountryNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_countryName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(ANYTHING);
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

	public static class TitleContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(CountriesParser.ANYTHING, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CountriesListener ) ((CountriesListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(ANYTHING);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7F\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\7\2"+
		"\27\n\2\f\2\16\2\32\13\2\3\2\3\2\3\2\3\2\3\3\3\3\7\3\"\n\3\f\3\16\3%\13"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\5\7\5-\n\5\f\5\16\5\60\13\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\7\7;\n\7\f\7\16\7>\13\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t"+
		"\2\2\n\2\4\6\b\n\f\16\20\2\4\4\2\3\3\7\7\3\3\6\6\2B\2\22\3\2\2\2\4#\3"+
		"\2\2\2\6(\3\2\2\2\b.\3\2\2\2\n\64\3\2\2\2\f<\3\2\2\2\16A\3\2\2\2\20C\3"+
		"\2\2\2\22\23\5\4\3\2\23\24\5\6\4\2\24\30\b\2\1\2\25\27\5\n\6\2\26\25\3"+
		"\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\33\3\2\2\2\32\30\3"+
		"\2\2\2\33\34\b\2\1\2\34\35\7\5\2\2\35\36\5\f\7\2\36\3\3\2\2\2\37\"\5\b"+
		"\5\2 \"\7\5\2\2!\37\3\2\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$"+
		"&\3\2\2\2%#\3\2\2\2&\'\b\3\1\2\'\5\3\2\2\2()\7\4\2\2)*\b\4\1\2*\7\3\2"+
		"\2\2+-\t\2\2\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60"+
		".\3\2\2\2\61\62\7\6\2\2\62\63\b\5\1\2\63\t\3\2\2\2\64\65\5\20\t\2\65\66"+
		"\7\3\2\2\66\67\5\16\b\2\678\7\6\2\28\13\3\2\2\29;\t\2\2\2:9\3\2\2\2;>"+
		"\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\t\3\2\2@\r\3\2\2\2"+
		"AB\7\7\2\2B\17\3\2\2\2CD\7\7\2\2D\21\3\2\2\2\7\30!#.<";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}