// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources\Directors.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DirectorsParser}.
 */
public interface DirectorsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DirectorsParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(DirectorsParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link DirectorsParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(DirectorsParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link DirectorsParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void enterAnythingButStart(DirectorsParser.AnythingButStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DirectorsParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void exitAnythingButStart(DirectorsParser.AnythingButStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DirectorsParser#anyline}.
	 * @param ctx the parse tree
	 */
	void enterAnyline(DirectorsParser.AnylineContext ctx);
	/**
	 * Exit a parse tree produced by {@link DirectorsParser#anyline}.
	 * @param ctx the parse tree
	 */
	void exitAnyline(DirectorsParser.AnylineContext ctx);
	/**
	 * Enter a parse tree produced by {@link DirectorsParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void enterAnyLineOrEOF(DirectorsParser.AnyLineOrEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link DirectorsParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void exitAnyLineOrEOF(DirectorsParser.AnyLineOrEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link DirectorsParser#directorList}.
	 * @param ctx the parse tree
	 */
	void enterDirectorList(DirectorsParser.DirectorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DirectorsParser#directorList}.
	 * @param ctx the parse tree
	 */
	void exitDirectorList(DirectorsParser.DirectorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DirectorsParser#directorName}.
	 * @param ctx the parse tree
	 */
	void enterDirectorName(DirectorsParser.DirectorNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DirectorsParser#directorName}.
	 * @param ctx the parse tree
	 */
	void exitDirectorName(DirectorsParser.DirectorNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DirectorsParser#workList}.
	 * @param ctx the parse tree
	 */
	void enterWorkList(DirectorsParser.WorkListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DirectorsParser#workList}.
	 * @param ctx the parse tree
	 */
	void exitWorkList(DirectorsParser.WorkListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DirectorsParser#workElement}.
	 * @param ctx the parse tree
	 */
	void enterWorkElement(DirectorsParser.WorkElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DirectorsParser#workElement}.
	 * @param ctx the parse tree
	 */
	void exitWorkElement(DirectorsParser.WorkElementContext ctx);
}