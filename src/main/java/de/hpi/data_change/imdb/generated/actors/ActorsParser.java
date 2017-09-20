// Generated from /home/leon/IdeaProjects/IMDBParser/resources/grammars/Actors.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.actors;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ActorsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, STARTSIGNAL=2, SEP=3, ENDSIGNAL=4, ANYTHING=5;
	public static final int
		RULE_r = 0, RULE_anythingButStart = 1, RULE_anyline = 2, RULE_anyLineOrEOF = 3, 
		RULE_actorList = 4, RULE_actorAndWork = 5, RULE_actorName = 6, RULE_workList = 7, 
		RULE_workElement = 8;
	public static final String[] ruleNames = {
		"r", "anythingButStart", "anyline", "anyLineOrEOF", "actorList", "actorAndWork", 
		"actorName", "workList", "workElement"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NEWLINE", "STARTSIGNAL", "SEP", "ENDSIGNAL", "ANYTHING"
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
	public String getGrammarFileName() { return "Actors.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ActorsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public AnythingButStartContext anythingButStart() {
			return getRuleContext(AnythingButStartContext.class,0);
		}
		public TerminalNode STARTSIGNAL() { return getToken(ActorsParser.STARTSIGNAL, 0); }
		public ActorListContext actorList() {
			return getRuleContext(ActorListContext.class,0);
		}
		public TerminalNode ENDSIGNAL() { return getToken(ActorsParser.ENDSIGNAL, 0); }
		public AnyLineOrEOFContext anyLineOrEOF() {
			return getRuleContext(AnyLineOrEOFContext.class,0);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).exitR(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			anythingButStart();
			setState(19);
			match(STARTSIGNAL);
			System.out.println("Matched Start Signal");
			System.out.println("Starting actor/actress List parsing");
			setState(22);
			actorList();
			System.out.println("Finished actor/actress List parsing");
			setState(24);
			match(ENDSIGNAL);
			setState(25);
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
		public List<TerminalNode> ENDSIGNAL() { return getTokens(ActorsParser.ENDSIGNAL); }
		public TerminalNode ENDSIGNAL(int i) {
			return getToken(ActorsParser.ENDSIGNAL, i);
		}
		public AnythingButStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anythingButStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).enterAnythingButStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).exitAnythingButStart(this);
		}
	}

	public final AnythingButStartContext anythingButStart() throws RecognitionException {
		AnythingButStartContext _localctx = new AnythingButStartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_anythingButStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << SEP) | (1L << ENDSIGNAL) | (1L << ANYTHING))) != 0)) {
				{
				setState(29);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWLINE:
				case SEP:
				case ANYTHING:
					{
					setState(27);
					anyline();
					}
					break;
				case ENDSIGNAL:
					{
					setState(28);
					match(ENDSIGNAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(33);
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
		public TerminalNode NEWLINE() { return getToken(ActorsParser.NEWLINE, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(ActorsParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(ActorsParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(ActorsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(ActorsParser.SEP, i);
		}
		public AnylineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).enterAnyline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).exitAnyline(this);
		}
	}

	public final AnylineContext anyline() throws RecognitionException {
		AnylineContext _localctx = new AnylineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_anyline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP || _la==ANYTHING) {
				{
				{
				setState(36);
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
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
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
		public TerminalNode NEWLINE() { return getToken(ActorsParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(ActorsParser.EOF, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(ActorsParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(ActorsParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(ActorsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(ActorsParser.SEP, i);
		}
		public AnyLineOrEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyLineOrEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).enterAnyLineOrEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).exitAnyLineOrEOF(this);
		}
	}

	public final AnyLineOrEOFContext anyLineOrEOF() throws RecognitionException {
		AnyLineOrEOFContext _localctx = new AnyLineOrEOFContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_anyLineOrEOF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP || _la==ANYTHING) {
				{
				{
				setState(44);
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
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
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

	public static class ActorListContext extends ParserRuleContext {
		public List<ActorAndWorkContext> actorAndWork() {
			return getRuleContexts(ActorAndWorkContext.class);
		}
		public ActorAndWorkContext actorAndWork(int i) {
			return getRuleContext(ActorAndWorkContext.class,i);
		}
		public ActorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).enterActorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).exitActorList(this);
		}
	}

	public final ActorListContext actorList() throws RecognitionException {
		ActorListContext _localctx = new ActorListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_actorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ANYTHING) {
				{
				{
				setState(52);
				actorAndWork();
				}
				}
				setState(57);
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

	public static class ActorAndWorkContext extends ParserRuleContext {
		public ActorNameContext actorName() {
			return getRuleContext(ActorNameContext.class,0);
		}
		public TerminalNode SEP() { return getToken(ActorsParser.SEP, 0); }
		public WorkListContext workList() {
			return getRuleContext(WorkListContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ActorsParser.NEWLINE, 0); }
		public ActorAndWorkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actorAndWork; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).enterActorAndWork(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).exitActorAndWork(this);
		}
	}

	public final ActorAndWorkContext actorAndWork() throws RecognitionException {
		ActorAndWorkContext _localctx = new ActorAndWorkContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_actorAndWork);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			actorName();
			setState(59);
			match(SEP);
			setState(60);
			workList();
			setState(61);
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

	public static class ActorNameContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(ActorsParser.ANYTHING, 0); }
		public ActorNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actorName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).enterActorName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).exitActorName(this);
		}
	}

	public final ActorNameContext actorName() throws RecognitionException {
		ActorNameContext _localctx = new ActorNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_actorName);
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

	public static class WorkListContext extends ParserRuleContext {
		public List<WorkElementContext> workElement() {
			return getRuleContexts(WorkElementContext.class);
		}
		public WorkElementContext workElement(int i) {
			return getRuleContext(WorkElementContext.class,i);
		}
		public WorkListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_workList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).enterWorkList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).exitWorkList(this);
		}
	}

	public final WorkListContext workList() throws RecognitionException {
		WorkListContext _localctx = new WorkListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_workList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				workElement();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SEP || _la==ANYTHING );
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

	public static class WorkElementContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(ActorsParser.ANYTHING, 0); }
		public TerminalNode NEWLINE() { return getToken(ActorsParser.NEWLINE, 0); }
		public List<TerminalNode> SEP() { return getTokens(ActorsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(ActorsParser.SEP, i);
		}
		public WorkElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_workElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).enterWorkElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ActorsListener ) ((ActorsListener)listener).exitWorkElement(this);
		}
	}

	public final WorkElementContext workElement() throws RecognitionException {
		WorkElementContext _localctx = new WorkElementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_workElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(70);
				match(SEP);
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(ANYTHING);
			setState(77);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7R\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\3\3\3\3\4\7"+
		"\4(\n\4\f\4\16\4+\13\4\3\4\3\4\3\5\7\5\60\n\5\f\5\16\5\63\13\5\3\5\3\5"+
		"\3\6\7\68\n\6\f\6\16\6;\13\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\6\tE\n\t"+
		"\r\t\16\tF\3\n\7\nJ\n\n\f\n\16\nM\13\n\3\n\3\n\3\n\3\n\2\2\13\2\4\6\b"+
		"\n\f\16\20\22\2\4\4\2\5\5\7\7\3\3\3\3\2O\2\24\3\2\2\2\4!\3\2\2\2\6)\3"+
		"\2\2\2\b\61\3\2\2\2\n9\3\2\2\2\f<\3\2\2\2\16A\3\2\2\2\20D\3\2\2\2\22K"+
		"\3\2\2\2\24\25\5\4\3\2\25\26\7\4\2\2\26\27\b\2\1\2\27\30\b\2\1\2\30\31"+
		"\5\n\6\2\31\32\b\2\1\2\32\33\7\6\2\2\33\34\5\b\5\2\34\3\3\2\2\2\35 \5"+
		"\6\4\2\36 \7\6\2\2\37\35\3\2\2\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!"+
		"\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\b\3\1\2%\5\3\2\2\2&(\t\2\2\2\'&\3\2"+
		"\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\3\2\2-\7\3"+
		"\2\2\2.\60\t\2\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62"+
		"\64\3\2\2\2\63\61\3\2\2\2\64\65\t\3\2\2\65\t\3\2\2\2\668\5\f\7\2\67\66"+
		"\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\13\3\2\2\2;9\3\2\2\2<=\5\16"+
		"\b\2=>\7\5\2\2>?\5\20\t\2?@\7\3\2\2@\r\3\2\2\2AB\7\7\2\2B\17\3\2\2\2C"+
		"E\5\22\n\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\21\3\2\2\2HJ\7\5\2"+
		"\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\7\7\2"+
		"\2OP\7\3\2\2P\23\3\2\2\2\t\37!)\619FK";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}