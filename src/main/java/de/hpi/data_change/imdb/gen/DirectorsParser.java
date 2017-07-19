// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources\Directors.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DirectorsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEP=1, STARTSIGNAL=2, ENDSIGNAL=3, NEWLINE=4, ANYTHING=5;
	public static final int
		RULE_r = 0, RULE_anythingButStart = 1, RULE_anyline = 2, RULE_anyLineOrEOF = 3, 
		RULE_directorList = 4, RULE_directorName = 5, RULE_workList = 6, RULE_workElement = 7;
	public static final String[] ruleNames = {
		"r", "anythingButStart", "anyline", "anyLineOrEOF", "directorList", "directorName", 
		"workList", "workElement"
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
	public String getGrammarFileName() { return "Directors.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DirectorsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public AnythingButStartContext anythingButStart() {
			return getRuleContext(AnythingButStartContext.class,0);
		}
		public TerminalNode STARTSIGNAL() { return getToken(DirectorsParser.STARTSIGNAL, 0); }
		public DirectorListContext directorList() {
			return getRuleContext(DirectorListContext.class,0);
		}
		public TerminalNode ENDSIGNAL() { return getToken(DirectorsParser.ENDSIGNAL, 0); }
		public AnyLineOrEOFContext anyLineOrEOF() {
			return getRuleContext(AnyLineOrEOFContext.class,0);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).exitR(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			anythingButStart();
			setState(17);
			match(STARTSIGNAL);
			System.out.println("Starting director List parsing");
			setState(19);
			directorList();
			System.out.println("Finished Director List parsing");
			setState(21);
			match(ENDSIGNAL);
			setState(22);
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
		public List<TerminalNode> ENDSIGNAL() { return getTokens(DirectorsParser.ENDSIGNAL); }
		public TerminalNode ENDSIGNAL(int i) {
			return getToken(DirectorsParser.ENDSIGNAL, i);
		}
		public AnythingButStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anythingButStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).enterAnythingButStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).exitAnythingButStart(this);
		}
	}

	public final AnythingButStartContext anythingButStart() throws RecognitionException {
		AnythingButStartContext _localctx = new AnythingButStartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_anythingButStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEP) | (1L << ENDSIGNAL) | (1L << NEWLINE) | (1L << ANYTHING))) != 0)) {
				{
				setState(26);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEP:
				case NEWLINE:
				case ANYTHING:
					{
					setState(24);
					anyline();
					}
					break;
				case ENDSIGNAL:
					{
					setState(25);
					match(ENDSIGNAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(30);
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
		public TerminalNode NEWLINE() { return getToken(DirectorsParser.NEWLINE, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(DirectorsParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(DirectorsParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(DirectorsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(DirectorsParser.SEP, i);
		}
		public AnylineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).enterAnyline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).exitAnyline(this);
		}
	}

	public final AnylineContext anyline() throws RecognitionException {
		AnylineContext _localctx = new AnylineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_anyline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP || _la==ANYTHING) {
				{
				{
				setState(33);
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
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
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
		public TerminalNode NEWLINE() { return getToken(DirectorsParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(DirectorsParser.EOF, 0); }
		public List<TerminalNode> ANYTHING() { return getTokens(DirectorsParser.ANYTHING); }
		public TerminalNode ANYTHING(int i) {
			return getToken(DirectorsParser.ANYTHING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(DirectorsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(DirectorsParser.SEP, i);
		}
		public AnyLineOrEOFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyLineOrEOF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).enterAnyLineOrEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).exitAnyLineOrEOF(this);
		}
	}

	public final AnyLineOrEOFContext anyLineOrEOF() throws RecognitionException {
		AnyLineOrEOFContext _localctx = new AnyLineOrEOFContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_anyLineOrEOF);
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

	public static class DirectorListContext extends ParserRuleContext {
		public List<DirectorNameContext> directorName() {
			return getRuleContexts(DirectorNameContext.class);
		}
		public DirectorNameContext directorName(int i) {
			return getRuleContext(DirectorNameContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(DirectorsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(DirectorsParser.SEP, i);
		}
		public List<WorkListContext> workList() {
			return getRuleContexts(WorkListContext.class);
		}
		public WorkListContext workList(int i) {
			return getRuleContext(WorkListContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(DirectorsParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(DirectorsParser.NEWLINE, i);
		}
		public DirectorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).enterDirectorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).exitDirectorList(this);
		}
	}

	public final DirectorListContext directorList() throws RecognitionException {
		DirectorListContext _localctx = new DirectorListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_directorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ANYTHING) {
				{
				{
				setState(49);
				directorName();
				setState(50);
				match(SEP);
				setState(51);
				workList();
				setState(52);
				match(NEWLINE);
				}
				}
				setState(58);
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

	public static class DirectorNameContext extends ParserRuleContext {
		public TerminalNode ANYTHING() { return getToken(DirectorsParser.ANYTHING, 0); }
		public DirectorNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directorName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).enterDirectorName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).exitDirectorName(this);
		}
	}

	public final DirectorNameContext directorName() throws RecognitionException {
		DirectorNameContext _localctx = new DirectorNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_directorName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
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
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).enterWorkList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).exitWorkList(this);
		}
	}

	public final WorkListContext workList() throws RecognitionException {
		WorkListContext _localctx = new WorkListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_workList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				workElement();
				}
				}
				setState(64); 
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
		public TerminalNode ANYTHING() { return getToken(DirectorsParser.ANYTHING, 0); }
		public TerminalNode NEWLINE() { return getToken(DirectorsParser.NEWLINE, 0); }
		public TerminalNode SEP() { return getToken(DirectorsParser.SEP, 0); }
		public WorkElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_workElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).enterWorkElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DirectorsListener ) ((DirectorsListener)listener).exitWorkElement(this);
		}
	}

	public final WorkElementContext workElement() throws RecognitionException {
		WorkElementContext _localctx = new WorkElementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_workElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEP) {
				{
				setState(66);
				match(SEP);
				}
			}

			setState(69);
			match(ANYTHING);
			setState(70);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7K\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3\3\3\3\4\7\4%\n\4\f"+
		"\4\16\4(\13\4\3\4\3\4\3\5\7\5-\n\5\f\5\16\5\60\13\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\7\69\n\6\f\6\16\6<\13\6\3\7\3\7\3\b\6\bA\n\b\r\b\16\bB\3\t"+
		"\5\tF\n\t\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\4\4\2\3\3\7\7\3\3"+
		"\6\6\2I\2\22\3\2\2\2\4\36\3\2\2\2\6&\3\2\2\2\b.\3\2\2\2\n:\3\2\2\2\f="+
		"\3\2\2\2\16@\3\2\2\2\20E\3\2\2\2\22\23\5\4\3\2\23\24\7\4\2\2\24\25\b\2"+
		"\1\2\25\26\5\n\6\2\26\27\b\2\1\2\27\30\7\5\2\2\30\31\5\b\5\2\31\3\3\2"+
		"\2\2\32\35\5\6\4\2\33\35\7\5\2\2\34\32\3\2\2\2\34\33\3\2\2\2\35 \3\2\2"+
		"\2\36\34\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \36\3\2\2\2!\"\b\3\1\2\"\5"+
		"\3\2\2\2#%\t\2\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2"+
		"(&\3\2\2\2)*\7\6\2\2*\7\3\2\2\2+-\t\2\2\2,+\3\2\2\2-\60\3\2\2\2.,\3\2"+
		"\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\t\3\2\2\62\t\3\2\2\2\63\64"+
		"\5\f\7\2\64\65\7\3\2\2\65\66\5\16\b\2\66\67\7\6\2\2\679\3\2\2\28\63\3"+
		"\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\13\3\2\2\2<:\3\2\2\2=>\7\7\2\2>"+
		"\r\3\2\2\2?A\5\20\t\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\17\3\2"+
		"\2\2DF\7\3\2\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\7\2\2HI\7\6\2\2I\21\3"+
		"\2\2\2\t\34\36&.:BE";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}