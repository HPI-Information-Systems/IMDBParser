// Generated from /home/leon/IdeaProjects/IMDBParser/resources/grammars/Locations.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.locations;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LocationsParser}.
 */
public interface LocationsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LocationsParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(LocationsParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link LocationsParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(LocationsParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link LocationsParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void enterAnythingButStart(LocationsParser.AnythingButStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LocationsParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void exitAnythingButStart(LocationsParser.AnythingButStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LocationsParser#anyline}.
	 * @param ctx the parse tree
	 */
	void enterAnyline(LocationsParser.AnylineContext ctx);
	/**
	 * Exit a parse tree produced by {@link LocationsParser#anyline}.
	 * @param ctx the parse tree
	 */
	void exitAnyline(LocationsParser.AnylineContext ctx);
	/**
	 * Enter a parse tree produced by {@link LocationsParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(LocationsParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LocationsParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(LocationsParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LocationsParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void enterAnyLineOrEOF(LocationsParser.AnyLineOrEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link LocationsParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void exitAnyLineOrEOF(LocationsParser.AnyLineOrEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link LocationsParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(LocationsParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LocationsParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(LocationsParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LocationsParser#locationName}.
	 * @param ctx the parse tree
	 */
	void enterLocationName(LocationsParser.LocationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LocationsParser#locationName}.
	 * @param ctx the parse tree
	 */
	void exitLocationName(LocationsParser.LocationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LocationsParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(LocationsParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LocationsParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(LocationsParser.DescriptionContext ctx);
}