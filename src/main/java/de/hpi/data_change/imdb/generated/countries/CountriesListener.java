// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Countries.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.countries;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CountriesParser}.
 */
public interface CountriesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CountriesParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(CountriesParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link CountriesParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(CountriesParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link CountriesParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void enterAnythingButStart(CountriesParser.AnythingButStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CountriesParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void exitAnythingButStart(CountriesParser.AnythingButStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CountriesParser#startSignal}.
	 * @param ctx the parse tree
	 */
	void enterStartSignal(CountriesParser.StartSignalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CountriesParser#startSignal}.
	 * @param ctx the parse tree
	 */
	void exitStartSignal(CountriesParser.StartSignalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CountriesParser#anyline}.
	 * @param ctx the parse tree
	 */
	void enterAnyline(CountriesParser.AnylineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CountriesParser#anyline}.
	 * @param ctx the parse tree
	 */
	void exitAnyline(CountriesParser.AnylineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CountriesParser#country}.
	 * @param ctx the parse tree
	 */
	void enterCountry(CountriesParser.CountryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CountriesParser#country}.
	 * @param ctx the parse tree
	 */
	void exitCountry(CountriesParser.CountryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CountriesParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void enterAnyLineOrEOF(CountriesParser.AnyLineOrEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link CountriesParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void exitAnyLineOrEOF(CountriesParser.AnyLineOrEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link CountriesParser#countryName}.
	 * @param ctx the parse tree
	 */
	void enterCountryName(CountriesParser.CountryNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CountriesParser#countryName}.
	 * @param ctx the parse tree
	 */
	void exitCountryName(CountriesParser.CountryNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CountriesParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(CountriesParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CountriesParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(CountriesParser.TitleContext ctx);
}