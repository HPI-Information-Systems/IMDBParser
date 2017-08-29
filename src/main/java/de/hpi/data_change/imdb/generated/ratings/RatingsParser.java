// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Ratings.g4 by ANTLR 4.7
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
public class RatingsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEP=1, STARTSIGNAL=2, ENDSIGNAL=3, NEWLINE=4, ANYTHING=5;
	public static final int
		RULE_r = 0, RULE_anythingButStart = 1, RULE_anyline = 2, RULE_rating = 3, 
		RULE_anyLineOrEOF = 4, RULE_new_ = 5, RULE_distribution = 6, RULE_votes = 7, 
		RULE_rank = 8, RULE_title = 9;
	public static final String[] ruleNames = {
		"r", "anythingButStart", "anyline", "rating", "anyLineOrEOF", "new_", 
		"distribution", "votes", "rank", "title"
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
	public String getGrammarFileName() { return "Ratings.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RatingsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public AnythingButStartContext anythingButStart() {
			return getRuleContext(AnythingButStartContext.class,0);
		}
		public TerminalNode STARTSIGNAL() { return getToken(RatingsParser.STARTSIGNAL, 0); }
		public TerminalNode ENDSIGNAL() { return getToken(RatingsParser.ENDSIGNAL, 0); }
		public AnyLineOrEOFContext anyLineOrEOF() {
			return getRuleContext(AnyLineOrEOFContext.class,0);
		}
		public List<RatingContext> rating() {
			return getRuleContexts(RatingContext.class);
		}
		public RatingContext rating(int i) {
			return getRuleContext(RatingContext.class,i);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).exitR(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			anythingButStart();
			setState(21);
			match(STARTSIGNAL);
			System.out.println("Starting Rating parsing");
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(23);
				rating();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Finished Director List parsing");
			setState(30);
			match(ENDSIGNAL);
			setState(31);
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
		public List<TerminalNode> ENDSIGNAL() { return getTokens(RatingsParser.ENDSIGNAL); }
		public TerminalNode ENDSIGNAL(int i) {
			return getToken(RatingsParser.ENDSIGNAL, i);
		}
		public AnythingButStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anythingButStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).enterAnythingButStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).exitAnythingButStart(this);
		}
	}

	public final AnythingButStartContext anythingButStart() throws RecognitionException {
		AnythingButStartContext _localctx = new AnythingButStartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_anythingButStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEP) | (1L << ENDSIGNAL) | (1L << NEWLINE) | (1L << ANYTHING))) != 0)) {
				{
				setState(35);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEP:
				case NEWLINE:
				case ANYTHING:
					{
					setState(33);
					anyline();
					}
					break;
				case ENDSIGNAL:
					{
					setState(34);
					match(ENDSIGNAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(39);
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
		public TerminalNode NEWLINE() { return getToken(RatingsParser.NEWLINE, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(RatingsParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(RatingsParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(RatingsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(RatingsParser.SEP, i);
		}
		public AnylineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).enterAnyline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).exitAnyline(this);
		}
	}

	public final AnylineContext anyline() throws RecognitionException {
		AnylineContext _localctx = new AnylineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_anyline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP || _la==ANYTHING) {
				{
				{
				setState(42);
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
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
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

	public static class RatingContext extends ParserRuleContext {
		public List<TerminalNode> SEP() { return getTokens(RatingsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(RatingsParser.SEP, i);
		}
		public DistributionContext distribution() {
			return getRuleContext(DistributionContext.class,0);
		}
		public VotesContext votes() {
			return getRuleContext(VotesContext.class,0);
		}
		public RankContext rank() {
			return getRuleContext(RankContext.class,0);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(RatingsParser.NEWLINE, 0); }
		public RatingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rating; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).enterRating(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).exitRating(this);
		}
	}

	public final RatingContext rating() throws RecognitionException {
		RatingContext _localctx = new RatingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rating);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(SEP);
			setState(51);
			distribution();
			setState(52);
			match(SEP);
			setState(53);
			votes();
			setState(54);
			match(SEP);
			setState(55);
			rank();
			setState(56);
			match(SEP);
			setState(57);
			title();
			setState(58);
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
		public TerminalNode NEWLINE() { return getToken(RatingsParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(RatingsParser.EOF, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(RatingsParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(RatingsParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(RatingsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(RatingsParser.SEP, i);
		}
		public AnyLineOrEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyLineOrEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).enterAnyLineOrEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).exitAnyLineOrEOF(this);
		}
	}

	public final AnyLineOrEOFContext anyLineOrEOF() throws RecognitionException {
		AnyLineOrEOFContext _localctx = new AnyLineOrEOFContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_anyLineOrEOF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP || _la==ANYTHING) {
				{
				{
				setState(60);
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
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
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

	public static class New_Context extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(RatingsParser.ANYTHING, 0); }
		public New_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).enterNew_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).exitNew_(this);
		}
	}

	public final New_Context new_() throws RecognitionException {
		New_Context _localctx = new New_Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_new_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
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

	public static class DistributionContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(RatingsParser.ANYTHING, 0); }
		public DistributionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distribution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).enterDistribution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).exitDistribution(this);
		}
	}

	public final DistributionContext distribution() throws RecognitionException {
		DistributionContext _localctx = new DistributionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_distribution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
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

	public static class VotesContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(RatingsParser.ANYTHING, 0); }
		public VotesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_votes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).enterVotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).exitVotes(this);
		}
	}

	public final VotesContext votes() throws RecognitionException {
		VotesContext _localctx = new VotesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_votes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
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

	public static class RankContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(RatingsParser.ANYTHING, 0); }
		public RankContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rank; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).enterRank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).exitRank(this);
		}
	}

	public final RankContext rank() throws RecognitionException {
		RankContext _localctx = new RankContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rank);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
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
		public List<TerminalNode> ANYTHING() { return getTokens(RatingsParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(RatingsParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(RatingsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(RatingsParser.SEP, i);
		}
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RatingsListener ) ((RatingsListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_title);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP || _la==ANYTHING) {
				{
				{
				setState(76);
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
				setState(81);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7U\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\3\2\3\2\3\2\3\3\3\3\7\3"+
		"&\n\3\f\3\16\3)\13\3\3\3\3\3\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\7\6@\n\6\f\6\16\6C\13\6\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\7\13P\n\13\f\13\16\13S\13\13\3"+
		"\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\4\4\2\3\3\7\7\3\3\6\6\2P\2\26\3\2"+
		"\2\2\4\'\3\2\2\2\6/\3\2\2\2\b\64\3\2\2\2\nA\3\2\2\2\fF\3\2\2\2\16H\3\2"+
		"\2\2\20J\3\2\2\2\22L\3\2\2\2\24Q\3\2\2\2\26\27\5\4\3\2\27\30\7\4\2\2\30"+
		"\34\b\2\1\2\31\33\5\b\5\2\32\31\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34"+
		"\35\3\2\2\2\35\37\3\2\2\2\36\34\3\2\2\2\37 \b\2\1\2 !\7\5\2\2!\"\5\n\6"+
		"\2\"\3\3\2\2\2#&\5\6\4\2$&\7\5\2\2%#\3\2\2\2%$\3\2\2\2&)\3\2\2\2\'%\3"+
		"\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\b\3\1\2+\5\3\2\2\2,.\t\2\2\2"+
		"-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2"+
		"\62\63\7\6\2\2\63\7\3\2\2\2\64\65\7\3\2\2\65\66\5\16\b\2\66\67\7\3\2\2"+
		"\678\5\20\t\289\7\3\2\29:\5\22\n\2:;\7\3\2\2;<\5\24\13\2<=\7\6\2\2=\t"+
		"\3\2\2\2>@\t\2\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2C"+
		"A\3\2\2\2DE\t\3\2\2E\13\3\2\2\2FG\7\7\2\2G\r\3\2\2\2HI\7\7\2\2I\17\3\2"+
		"\2\2JK\7\7\2\2K\21\3\2\2\2LM\7\7\2\2M\23\3\2\2\2NP\t\2\2\2ON\3\2\2\2P"+
		"S\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\25\3\2\2\2SQ\3\2\2\2\b\34%\'/AQ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}