// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Genres.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.genres;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GenresParser}.
 */
public interface GenresListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GenresParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(GenresParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenresParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(GenresParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenresParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void enterAnythingButStart(GenresParser.AnythingButStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenresParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void exitAnythingButStart(GenresParser.AnythingButStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenresParser#startSignal}.
	 * @param ctx the parse tree
	 */
	void enterStartSignal(GenresParser.StartSignalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenresParser#startSignal}.
	 * @param ctx the parse tree
	 */
	void exitStartSignal(GenresParser.StartSignalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenresParser#anyline}.
	 * @param ctx the parse tree
	 */
	void enterAnyline(GenresParser.AnylineContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenresParser#anyline}.
	 * @param ctx the parse tree
	 */
	void exitAnyline(GenresParser.AnylineContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenresParser#genre}.
	 * @param ctx the parse tree
	 */
	void enterGenre(GenresParser.GenreContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenresParser#genre}.
	 * @param ctx the parse tree
	 */
	void exitGenre(GenresParser.GenreContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenresParser#genreName}.
	 * @param ctx the parse tree
	 */
	void enterGenreName(GenresParser.GenreNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenresParser#genreName}.
	 * @param ctx the parse tree
	 */
	void exitGenreName(GenresParser.GenreNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GenresParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(GenresParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GenresParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(GenresParser.TitleContext ctx);
}