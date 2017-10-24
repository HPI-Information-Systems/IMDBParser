// Generated from /home/leon/IdeaProjects/IMDBParser/resources/grammars/Plot.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.plot;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PlotParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STARTSIGNAL=1, PLOTSTARTLINE=2, NEWLINE=3, TITLESTART=4, PLOTSTART=5, 
		AUTHORSTART=6, ANYSTRING=7;
	public static final int
		RULE_r = 0, RULE_anythingButStart = 1, RULE_anyline = 2, RULE_plot = 3, 
		RULE_plotstartline = 4, RULE_plotDescription = 5, RULE_plotlines = 6, 
		RULE_plotline = 7, RULE_anyLineOrEOF = 8, RULE_titleline = 9, RULE_author = 10, 
		RULE_anystring = 11;
	public static final String[] ruleNames = {
		"r", "anythingButStart", "anyline", "plot", "plotstartline", "plotDescription", 
		"plotlines", "plotline", "anyLineOrEOF", "titleline", "author", "anystring"
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

	@Override
	public String getGrammarFileName() { return "Plot.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PlotParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public AnythingButStartContext anythingButStart() {
			return getRuleContext(AnythingButStartContext.class,0);
		}
		public TerminalNode STARTSIGNAL() { return getToken(PlotParser.STARTSIGNAL, 0); }
		public TerminalNode EOF() { return getToken(PlotParser.EOF, 0); }
		public List<PlotContext> plot() {
			return getRuleContexts(PlotContext.class);
		}
		public PlotContext plot(int i) {
			return getRuleContext(PlotContext.class,i);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitR(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			anythingButStart();
			setState(25);
			match(STARTSIGNAL);
			System.out.println("Starting Plot parsing");
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLOTSTARTLINE) {
				{
				{
				setState(27);
				plot();
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Finished Plot parsing");
			setState(34);
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

	public static class AnythingButStartContext extends ParserRuleContext {
		public List<AnylineContext> anyline() {
			return getRuleContexts(AnylineContext.class);
		}
		public AnylineContext anyline(int i) {
			return getRuleContext(AnylineContext.class,i);
		}
		public AnythingButStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anythingButStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterAnythingButStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitAnythingButStart(this);
		}
	}

	public final AnythingButStartContext anythingButStart() throws RecognitionException {
		AnythingButStartContext _localctx = new AnythingButStartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_anythingButStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE || _la==ANYSTRING) {
				{
				{
				setState(36);
				anyline();
				}
				}
				setState(41);
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

	public static class AnylineContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(PlotParser.NEWLINE, 0); }
		public List<AnystringContext> anystring() {
			return getRuleContexts(AnystringContext.class);
		}
		public AnystringContext anystring(int i) {
			return getRuleContext(AnystringContext.class,i);
		}
		public AnylineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterAnyline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitAnyline(this);
		}
	}

	public final AnylineContext anyline() throws RecognitionException {
		AnylineContext _localctx = new AnylineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_anyline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ANYSTRING) {
				{
				{
				setState(44);
				anystring();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
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

	public static class PlotContext extends ParserRuleContext {
		public PlotstartlineContext plotstartline() {
			return getRuleContext(PlotstartlineContext.class,0);
		}
		public TitlelineContext titleline() {
			return getRuleContext(TitlelineContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PlotParser.NEWLINE, 0); }
		public List<PlotDescriptionContext> plotDescription() {
			return getRuleContexts(PlotDescriptionContext.class);
		}
		public PlotDescriptionContext plotDescription(int i) {
			return getRuleContext(PlotDescriptionContext.class,i);
		}
		public PlotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterPlot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitPlot(this);
		}
	}

	public final PlotContext plot() throws RecognitionException {
		PlotContext _localctx = new PlotContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_plot);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			plotstartline();
			setState(53);
			titleline();
			setState(54);
			match(NEWLINE);
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				plotDescription();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PLOTSTART );
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

	public static class PlotstartlineContext extends ParserRuleContext {
		public TerminalNode PLOTSTARTLINE() { return getToken(PlotParser.PLOTSTARTLINE, 0); }
		public PlotstartlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plotstartline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterPlotstartline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitPlotstartline(this);
		}
	}

	public final PlotstartlineContext plotstartline() throws RecognitionException {
		PlotstartlineContext _localctx = new PlotstartlineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_plotstartline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(PLOTSTARTLINE);
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

	public static class PlotDescriptionContext extends ParserRuleContext {
		public PlotlinesContext plotlines() {
			return getRuleContext(PlotlinesContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(PlotParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PlotParser.NEWLINE, i);
		}
		public AuthorContext author() {
			return getRuleContext(AuthorContext.class,0);
		}
		public PlotDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plotDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterPlotDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitPlotDescription(this);
		}
	}

	public final PlotDescriptionContext plotDescription() throws RecognitionException {
		PlotDescriptionContext _localctx = new PlotDescriptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_plotDescription);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			plotlines();
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(63);
				match(NEWLINE);
				setState(64);
				author();
				setState(65);
				match(NEWLINE);
				}
				break;
			}
			setState(69);
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

	public static class PlotlinesContext extends ParserRuleContext {
		public List<PlotlineContext> plotline() {
			return getRuleContexts(PlotlineContext.class);
		}
		public PlotlineContext plotline(int i) {
			return getRuleContext(PlotlineContext.class,i);
		}
		public PlotlinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plotlines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterPlotlines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitPlotlines(this);
		}
	}

	public final PlotlinesContext plotlines() throws RecognitionException {
		PlotlinesContext _localctx = new PlotlinesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_plotlines);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				plotline();
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PLOTSTART );
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

	public static class PlotlineContext extends ParserRuleContext {
		public TerminalNode PLOTSTART() { return getToken(PlotParser.PLOTSTART, 0); }
		public AnystringContext anystring() {
			return getRuleContext(AnystringContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PlotParser.NEWLINE, 0); }
		public PlotlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plotline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterPlotline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitPlotline(this);
		}
	}

	public final PlotlineContext plotline() throws RecognitionException {
		PlotlineContext _localctx = new PlotlineContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_plotline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(PLOTSTART);
			setState(77);
			anystring();
			setState(78);
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
		public TerminalNode NEWLINE() { return getToken(PlotParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(PlotParser.EOF, 0); }
		public List<AnystringContext> anystring() {
			return getRuleContexts(AnystringContext.class);
		}
		public AnystringContext anystring(int i) {
			return getRuleContext(AnystringContext.class,i);
		}
		public AnyLineOrEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyLineOrEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterAnyLineOrEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitAnyLineOrEOF(this);
		}
	}

	public final AnyLineOrEOFContext anyLineOrEOF() throws RecognitionException {
		AnyLineOrEOFContext _localctx = new AnyLineOrEOFContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_anyLineOrEOF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ANYSTRING) {
				{
				{
				setState(80);
				anystring();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
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

	public static class TitlelineContext extends ParserRuleContext {
		public TerminalNode TITLESTART() { return getToken(PlotParser.TITLESTART, 0); }
		public AnystringContext anystring() {
			return getRuleContext(AnystringContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PlotParser.NEWLINE, 0); }
		public TitlelineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_titleline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterTitleline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitTitleline(this);
		}
	}

	public final TitlelineContext titleline() throws RecognitionException {
		TitlelineContext _localctx = new TitlelineContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_titleline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(TITLESTART);
			setState(89);
			anystring();
			setState(90);
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

	public static class AuthorContext extends ParserRuleContext {
		public TerminalNode AUTHORSTART() { return getToken(PlotParser.AUTHORSTART, 0); }
		public AnystringContext anystring() {
			return getRuleContext(AnystringContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PlotParser.NEWLINE, 0); }
		public AuthorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_author; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterAuthor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitAuthor(this);
		}
	}

	public final AuthorContext author() throws RecognitionException {
		AuthorContext _localctx = new AuthorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_author);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(AUTHORSTART);
			setState(93);
			anystring();
			setState(94);
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

	public static class AnystringContext extends ParserRuleContext {
		public TerminalNode ANYSTRING() { return getToken(PlotParser.ANYSTRING, 0); }
		public AnystringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anystring; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).enterAnystring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PlotListener ) ((PlotListener)listener).exitAnystring(this);
		}
	}

	public final AnystringContext anystring() throws RecognitionException {
		AnystringContext _localctx = new AnystringContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_anystring);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(ANYSTRING);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\te\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\2\3\2\3\2"+
		"\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\3\3\3\4\7\4\60\n\4\f\4\16\4\63\13\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\6\5;\n\5\r\5\16\5<\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\5\7F\n\7\3\7\3\7\3\b\6\bK\n\b\r\b\16\bL\3\t\3\t\3\t\3\t\3\n\7\nT\n\n"+
		"\f\n\16\nW\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\3\3\5\5\2_\2\32\3\2\2\2\4"+
		")\3\2\2\2\6\61\3\2\2\2\b\66\3\2\2\2\n>\3\2\2\2\f@\3\2\2\2\16J\3\2\2\2"+
		"\20N\3\2\2\2\22U\3\2\2\2\24Z\3\2\2\2\26^\3\2\2\2\30b\3\2\2\2\32\33\5\4"+
		"\3\2\33\34\7\3\2\2\34 \b\2\1\2\35\37\5\b\5\2\36\35\3\2\2\2\37\"\3\2\2"+
		"\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\" \3\2\2\2#$\b\2\1\2$%\7\2\2\3%\3\3"+
		"\2\2\2&(\5\6\4\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+"+
		")\3\2\2\2,-\b\3\1\2-\5\3\2\2\2.\60\5\30\r\2/.\3\2\2\2\60\63\3\2\2\2\61"+
		"/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\5\2\2\65\7"+
		"\3\2\2\2\66\67\5\n\6\2\678\5\24\13\28:\7\5\2\29;\5\f\7\2:9\3\2\2\2;<\3"+
		"\2\2\2<:\3\2\2\2<=\3\2\2\2=\t\3\2\2\2>?\7\4\2\2?\13\3\2\2\2@E\5\16\b\2"+
		"AB\7\5\2\2BC\5\26\f\2CD\7\5\2\2DF\3\2\2\2EA\3\2\2\2EF\3\2\2\2FG\3\2\2"+
		"\2GH\7\5\2\2H\r\3\2\2\2IK\5\20\t\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2"+
		"\2\2M\17\3\2\2\2NO\7\7\2\2OP\5\30\r\2PQ\7\5\2\2Q\21\3\2\2\2RT\5\30\r\2"+
		"SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\t\2\2\2"+
		"Y\23\3\2\2\2Z[\7\6\2\2[\\\5\30\r\2\\]\7\5\2\2]\25\3\2\2\2^_\7\b\2\2_`"+
		"\5\30\r\2`a\7\5\2\2a\27\3\2\2\2bc\7\t\2\2c\31\3\2\2\2\t )\61<ELU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}