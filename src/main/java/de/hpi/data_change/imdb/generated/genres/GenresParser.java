// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Genres.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.genres;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GenresParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEP=1, STARTSIGNAL=2, ENDSIGNAL=3, NEWLINE=4, ANYTHING=5;
	public static final int
		RULE_r = 0, RULE_anythingButStart = 1, RULE_startSignal = 2, RULE_anyline = 3, 
		RULE_genre = 4, RULE_genreName = 5, RULE_title = 6;
	public static final String[] ruleNames = {
		"r", "anythingButStart", "startSignal", "anyline", "genre", "genreName", 
		"title"
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
	public String getGrammarFileName() { return "Genres.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GenresParser(TokenStream input) {
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
		public TerminalNode EOF() { return getToken(GenresParser.EOF, 0); }
		public List<GenreContext> genre() {
			return getRuleContexts(GenreContext.class);
		}
		public GenreContext genre(int i) {
			return getRuleContext(GenreContext.class,i);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).exitR(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			anythingButStart();
			setState(15);
			startSignal();
			System.out.println("Starting Genre parsing");
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ANYTHING) {
				{
				{
				setState(17);
				genre();
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Finished Genre parsing");
			setState(24);
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
		public List<TerminalNode> ENDSIGNAL() { return getTokens(GenresParser.ENDSIGNAL); }
		public TerminalNode ENDSIGNAL(int i) {
			return getToken(GenresParser.ENDSIGNAL, i);
		}
		public AnythingButStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anythingButStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).enterAnythingButStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).exitAnythingButStart(this);
		}
	}

	public final AnythingButStartContext anythingButStart() throws RecognitionException {
		AnythingButStartContext _localctx = new AnythingButStartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_anythingButStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEP) | (1L << ENDSIGNAL) | (1L << NEWLINE) | (1L << ANYTHING))) != 0)) {
				{
				setState(28);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEP:
				case NEWLINE:
				case ANYTHING:
					{
					setState(26);
					anyline();
					}
					break;
				case ENDSIGNAL:
					{
					setState(27);
					match(ENDSIGNAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(32);
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

	public static class StartSignalContext extends ParserRuleContext {
		public TerminalNode STARTSIGNAL() { return getToken(GenresParser.STARTSIGNAL, 0); }
		public StartSignalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startSignal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).enterStartSignal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).exitStartSignal(this);
		}
	}

	public final StartSignalContext startSignal() throws RecognitionException {
		StartSignalContext _localctx = new StartSignalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_startSignal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(STARTSIGNAL);
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
		public TerminalNode NEWLINE() { return getToken(GenresParser.NEWLINE, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(GenresParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(GenresParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(GenresParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(GenresParser.SEP, i);
		}
		public AnylineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).enterAnyline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).exitAnyline(this);
		}
	}

	public final AnylineContext anyline() throws RecognitionException {
		AnylineContext _localctx = new AnylineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_anyline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP || _la==ANYTHING) {
				{
				{
				setState(35);
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
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
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

	public static class GenreContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public TerminalNode SEP() { return getToken(GenresParser.SEP, 0); }
		public GenreNameContext genreName() {
			return getRuleContext(GenreNameContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GenresParser.NEWLINE, 0); }
		public GenreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).enterGenre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).exitGenre(this);
		}
	}

	public final GenreContext genre() throws RecognitionException {
		GenreContext _localctx = new GenreContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_genre);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			title();
			setState(44);
			match(SEP);
			setState(45);
			genreName();
			setState(46);
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

	public static class GenreNameContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(GenresParser.ANYTHING, 0); }
		public GenreNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genreName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).enterGenreName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).exitGenreName(this);
		}
	}

	public final GenreNameContext genreName() throws RecognitionException {
		GenreNameContext _localctx = new GenreNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_genreName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
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
		public TerminalNode ANYTHING() { return getToken(GenresParser.ANYTHING, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GenresListener ) ((GenresListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7\67\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\7\2\25\n"+
		"\2\f\2\16\2\30\13\2\3\2\3\2\3\2\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\4"+
		"\3\4\3\5\7\5\'\n\5\f\5\16\5*\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\3\4\2\3\3\7\7\2\63\2\20\3\2\2\2\4"+
		" \3\2\2\2\6#\3\2\2\2\b(\3\2\2\2\n-\3\2\2\2\f\62\3\2\2\2\16\64\3\2\2\2"+
		"\20\21\5\4\3\2\21\22\5\6\4\2\22\26\b\2\1\2\23\25\5\n\6\2\24\23\3\2\2\2"+
		"\25\30\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\31\3\2\2\2\30\26\3\2\2\2"+
		"\31\32\b\2\1\2\32\33\7\2\2\3\33\3\3\2\2\2\34\37\5\b\5\2\35\37\7\5\2\2"+
		"\36\34\3\2\2\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\5\3\2"+
		"\2\2\" \3\2\2\2#$\7\4\2\2$\7\3\2\2\2%\'\t\2\2\2&%\3\2\2\2\'*\3\2\2\2("+
		"&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\6\2\2,\t\3\2\2\2-.\5\16\b"+
		"\2./\7\3\2\2/\60\5\f\7\2\60\61\7\6\2\2\61\13\3\2\2\2\62\63\7\7\2\2\63"+
		"\r\3\2\2\2\64\65\7\7\2\2\65\17\3\2\2\2\6\26\36 (";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}