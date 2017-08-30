// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\TEst.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.ratings;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TEstParser}.
 */
public interface TEstListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TEstParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(TEstParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link TEstParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(TEstParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link TEstParser#anyToken}.
	 * @param ctx the parse tree
	 */
	void enterAnyToken(TEstParser.AnyTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link TEstParser#anyToken}.
	 * @param ctx the parse tree
	 */
	void exitAnyToken(TEstParser.AnyTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link TEstParser#sep}.
	 * @param ctx the parse tree
	 */
	void enterSep(TEstParser.SepContext ctx);
	/**
	 * Exit a parse tree produced by {@link TEstParser#sep}.
	 * @param ctx the parse tree
	 */
	void exitSep(TEstParser.SepContext ctx);
	/**
	 * Enter a parse tree produced by {@link TEstParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(TEstParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TEstParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(TEstParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TEstParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(TEstParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link TEstParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(TEstParser.EndContext ctx);
	/**
	 * Enter a parse tree produced by {@link TEstParser#nl}.
	 * @param ctx the parse tree
	 */
	void enterNl(TEstParser.NlContext ctx);
	/**
	 * Exit a parse tree produced by {@link TEstParser#nl}.
	 * @param ctx the parse tree
	 */
	void exitNl(TEstParser.NlContext ctx);
	/**
	 * Enter a parse tree produced by {@link TEstParser#any}.
	 * @param ctx the parse tree
	 */
	void enterAny(TEstParser.AnyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TEstParser#any}.
	 * @param ctx the parse tree
	 */
	void exitAny(TEstParser.AnyContext ctx);
}