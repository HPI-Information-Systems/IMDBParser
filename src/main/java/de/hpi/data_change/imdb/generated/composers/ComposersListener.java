// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Composers.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.composers;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ComposersParser}.
 */
public interface ComposersListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ComposersParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(ComposersParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComposersParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(ComposersParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComposersParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void enterAnythingButStart(ComposersParser.AnythingButStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComposersParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void exitAnythingButStart(ComposersParser.AnythingButStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComposersParser#anyline}.
	 * @param ctx the parse tree
	 */
	void enterAnyline(ComposersParser.AnylineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComposersParser#anyline}.
	 * @param ctx the parse tree
	 */
	void exitAnyline(ComposersParser.AnylineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComposersParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void enterAnyLineOrEOF(ComposersParser.AnyLineOrEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComposersParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void exitAnyLineOrEOF(ComposersParser.AnyLineOrEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComposersParser#composerList}.
	 * @param ctx the parse tree
	 */
	void enterComposerList(ComposersParser.ComposerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComposersParser#composerList}.
	 * @param ctx the parse tree
	 */
	void exitComposerList(ComposersParser.ComposerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComposersParser#composerAndWork}.
	 * @param ctx the parse tree
	 */
	void enterComposerAndWork(ComposersParser.ComposerAndWorkContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComposersParser#composerAndWork}.
	 * @param ctx the parse tree
	 */
	void exitComposerAndWork(ComposersParser.ComposerAndWorkContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComposersParser#composerName}.
	 * @param ctx the parse tree
	 */
	void enterComposerName(ComposersParser.ComposerNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComposersParser#composerName}.
	 * @param ctx the parse tree
	 */
	void exitComposerName(ComposersParser.ComposerNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComposersParser#workList}.
	 * @param ctx the parse tree
	 */
	void enterWorkList(ComposersParser.WorkListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComposersParser#workList}.
	 * @param ctx the parse tree
	 */
	void exitWorkList(ComposersParser.WorkListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComposersParser#workElement}.
	 * @param ctx the parse tree
	 */
	void enterWorkElement(ComposersParser.WorkElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComposersParser#workElement}.
	 * @param ctx the parse tree
	 */
	void exitWorkElement(ComposersParser.WorkElementContext ctx);
}