// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Composers.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.composers;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ComposersParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEP=1, STARTSIGNAL=2, ENDSIGNAL=3, NEWLINE=4, ANYTHING=5;
	public static final int
		RULE_r = 0, RULE_anythingButStart = 1, RULE_anyline = 2, RULE_anyLineOrEOF = 3, 
		RULE_composerList = 4, RULE_composerAndWork = 5, RULE_composerName = 6, 
		RULE_workList = 7, RULE_workElement = 8;
	public static final String[] ruleNames = {
		"r", "anythingButStart", "anyline", "anyLineOrEOF", "composerList", "composerAndWork", 
		"composerName", "workList", "workElement"
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
	public String getGrammarFileName() { return "Composers.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ComposersParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public AnythingButStartContext anythingButStart() {
			return getRuleContext(AnythingButStartContext.class,0);
		}
		public TerminalNode STARTSIGNAL() { return getToken(ComposersParser.STARTSIGNAL, 0); }
		public ComposerListContext composerList() {
			return getRuleContext(ComposerListContext.class,0);
		}
		public TerminalNode ENDSIGNAL() { return getToken(ComposersParser.ENDSIGNAL, 0); }
		public AnyLineOrEOFContext anyLineOrEOF() {
			return getRuleContext(AnyLineOrEOFContext.class,0);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).exitR(this);
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
			System.out.println("Starting composer List parsing");
			setState(21);
			composerList();
			System.out.println("Finished composer List parsing");
			setState(23);
			match(ENDSIGNAL);
			setState(24);
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
		public List<TerminalNode> ENDSIGNAL() { return getTokens(ComposersParser.ENDSIGNAL); }
		public TerminalNode ENDSIGNAL(int i) {
			return getToken(ComposersParser.ENDSIGNAL, i);
		}
		public AnythingButStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anythingButStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).enterAnythingButStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).exitAnythingButStart(this);
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
		public TerminalNode NEWLINE() { return getToken(ComposersParser.NEWLINE, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(ComposersParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(ComposersParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(ComposersParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(ComposersParser.SEP, i);
		}
		public AnylineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).enterAnyline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).exitAnyline(this);
		}
	}

	public final AnylineContext anyline() throws RecognitionException {
		AnylineContext _localctx = new AnylineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_anyline);
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

	public static class AnyLineOrEOFContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(ComposersParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(ComposersParser.EOF, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(ComposersParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(ComposersParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(ComposersParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(ComposersParser.SEP, i);
		}
		public AnyLineOrEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyLineOrEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).enterAnyLineOrEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).exitAnyLineOrEOF(this);
		}
	}

	public final AnyLineOrEOFContext anyLineOrEOF() throws RecognitionException {
		AnyLineOrEOFContext _localctx = new AnyLineOrEOFContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_anyLineOrEOF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP || _la==ANYTHING) {
				{
				{
				setState(43);
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
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
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

	public static class ComposerListContext extends ParserRuleContext {
		public List<ComposerAndWorkContext> composerAndWork() {
			return getRuleContexts(ComposerAndWorkContext.class);
		}
		public ComposerAndWorkContext composerAndWork(int i) {
			return getRuleContext(ComposerAndWorkContext.class,i);
		}
		public ComposerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).enterComposerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).exitComposerList(this);
		}
	}

	public final ComposerListContext composerList() throws RecognitionException {
		ComposerListContext _localctx = new ComposerListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_composerList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ANYTHING) {
				{
				{
				setState(51);
				composerAndWork();
				}
				}
				setState(56);
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

	public static class ComposerAndWorkContext extends ParserRuleContext {
		public ComposerNameContext composerName() {
			return getRuleContext(ComposerNameContext.class,0);
		}
		public TerminalNode SEP() { return getToken(ComposersParser.SEP, 0); }
		public WorkListContext workList() {
			return getRuleContext(WorkListContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ComposersParser.NEWLINE, 0); }
		public ComposerAndWorkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composerAndWork; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).enterComposerAndWork(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).exitComposerAndWork(this);
		}
	}

	public final ComposerAndWorkContext composerAndWork() throws RecognitionException {
		ComposerAndWorkContext _localctx = new ComposerAndWorkContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_composerAndWork);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			composerName();
			setState(58);
			match(SEP);
			setState(59);
			workList();
			setState(60);
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

	public static class ComposerNameContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(ComposersParser.ANYTHING, 0); }
		public ComposerNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composerName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).enterComposerName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).exitComposerName(this);
		}
	}

	public final ComposerNameContext composerName() throws RecognitionException {
		ComposerNameContext _localctx = new ComposerNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_composerName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
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
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).enterWorkList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).exitWorkList(this);
		}
	}

	public final WorkListContext workList() throws RecognitionException {
		WorkListContext _localctx = new WorkListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_workList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				workElement();
				}
				}
				setState(67); 
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
		public TerminalNode ANYTHING() { return getToken(ComposersParser.ANYTHING, 0); }
		public TerminalNode NEWLINE() { return getToken(ComposersParser.NEWLINE, 0); }
		public TerminalNode SEP() { return getToken(ComposersParser.SEP, 0); }
		public WorkElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_workElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).enterWorkElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ComposersListener ) ((ComposersListener)listener).exitWorkElement(this);
		}
	}

	public final WorkElementContext workElement() throws RecognitionException {
		WorkElementContext _localctx = new WorkElementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_workElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEP) {
				{
				setState(69);
				match(SEP);
				}
			}

			setState(72);
			match(ANYTHING);
			setState(73);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7N\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\3\3\3\3\4\7"+
		"\4\'\n\4\f\4\16\4*\13\4\3\4\3\4\3\5\7\5/\n\5\f\5\16\5\62\13\5\3\5\3\5"+
		"\3\6\7\6\67\n\6\f\6\16\6:\13\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\6\tD\n"+
		"\t\r\t\16\tE\3\n\5\nI\n\n\3\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22"+
		"\2\4\4\2\3\3\7\7\3\3\6\6\2K\2\24\3\2\2\2\4 \3\2\2\2\6(\3\2\2\2\b\60\3"+
		"\2\2\2\n8\3\2\2\2\f;\3\2\2\2\16@\3\2\2\2\20C\3\2\2\2\22H\3\2\2\2\24\25"+
		"\5\4\3\2\25\26\7\4\2\2\26\27\b\2\1\2\27\30\5\n\6\2\30\31\b\2\1\2\31\32"+
		"\7\5\2\2\32\33\5\b\5\2\33\3\3\2\2\2\34\37\5\6\4\2\35\37\7\5\2\2\36\34"+
		"\3\2\2\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\""+
		" \3\2\2\2#$\b\3\1\2$\5\3\2\2\2%\'\t\2\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2"+
		"\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\6\2\2,\7\3\2\2\2-/\t\2\2\2.-\3\2"+
		"\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2"+
		"\63\64\t\3\2\2\64\t\3\2\2\2\65\67\5\f\7\2\66\65\3\2\2\2\67:\3\2\2\28\66"+
		"\3\2\2\289\3\2\2\29\13\3\2\2\2:8\3\2\2\2;<\5\16\b\2<=\7\3\2\2=>\5\20\t"+
		"\2>?\7\6\2\2?\r\3\2\2\2@A\7\7\2\2A\17\3\2\2\2BD\5\22\n\2CB\3\2\2\2DE\3"+
		"\2\2\2EC\3\2\2\2EF\3\2\2\2F\21\3\2\2\2GI\7\3\2\2HG\3\2\2\2HI\3\2\2\2I"+
		"J\3\2\2\2JK\7\7\2\2KL\7\6\2\2L\23\3\2\2\2\t\36 (\608EH";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}