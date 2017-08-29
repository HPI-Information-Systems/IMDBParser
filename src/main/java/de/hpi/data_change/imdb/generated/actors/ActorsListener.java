// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Actors.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.actors;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ActorsParser}.
 */
public interface ActorsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ActorsParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(ActorsParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorsParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(ActorsParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorsParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void enterAnythingButStart(ActorsParser.AnythingButStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorsParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void exitAnythingButStart(ActorsParser.AnythingButStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorsParser#anyline}.
	 * @param ctx the parse tree
	 */
	void enterAnyline(ActorsParser.AnylineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorsParser#anyline}.
	 * @param ctx the parse tree
	 */
	void exitAnyline(ActorsParser.AnylineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorsParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void enterAnyLineOrEOF(ActorsParser.AnyLineOrEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorsParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void exitAnyLineOrEOF(ActorsParser.AnyLineOrEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorsParser#actorList}.
	 * @param ctx the parse tree
	 */
	void enterActorList(ActorsParser.ActorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorsParser#actorList}.
	 * @param ctx the parse tree
	 */
	void exitActorList(ActorsParser.ActorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorsParser#actorAndWork}.
	 * @param ctx the parse tree
	 */
	void enterActorAndWork(ActorsParser.ActorAndWorkContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorsParser#actorAndWork}.
	 * @param ctx the parse tree
	 */
	void exitActorAndWork(ActorsParser.ActorAndWorkContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorsParser#actorName}.
	 * @param ctx the parse tree
	 */
	void enterActorName(ActorsParser.ActorNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorsParser#actorName}.
	 * @param ctx the parse tree
	 */
	void exitActorName(ActorsParser.ActorNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorsParser#workList}.
	 * @param ctx the parse tree
	 */
	void enterWorkList(ActorsParser.WorkListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorsParser#workList}.
	 * @param ctx the parse tree
	 */
	void exitWorkList(ActorsParser.WorkListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ActorsParser#workElement}.
	 * @param ctx the parse tree
	 */
	void enterWorkElement(ActorsParser.WorkElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ActorsParser#workElement}.
	 * @param ctx the parse tree
	 */
	void exitWorkElement(ActorsParser.WorkElementContext ctx);
}