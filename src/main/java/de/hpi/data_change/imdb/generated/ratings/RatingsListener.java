// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Ratings.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.ratings;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RatingsParser}.
 */
public interface RatingsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RatingsParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(RatingsParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link RatingsParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(RatingsParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link RatingsParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void enterAnythingButStart(RatingsParser.AnythingButStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RatingsParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void exitAnythingButStart(RatingsParser.AnythingButStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RatingsParser#anyline}.
	 * @param ctx the parse tree
	 */
	void enterAnyline(RatingsParser.AnylineContext ctx);
	/**
	 * Exit a parse tree produced by {@link RatingsParser#anyline}.
	 * @param ctx the parse tree
	 */
	void exitAnyline(RatingsParser.AnylineContext ctx);
	/**
	 * Enter a parse tree produced by {@link RatingsParser#rating}.
	 * @param ctx the parse tree
	 */
	void enterRating(RatingsParser.RatingContext ctx);
	/**
	 * Exit a parse tree produced by {@link RatingsParser#rating}.
	 * @param ctx the parse tree
	 */
	void exitRating(RatingsParser.RatingContext ctx);
	/**
	 * Enter a parse tree produced by {@link RatingsParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void enterAnyLineOrEOF(RatingsParser.AnyLineOrEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link RatingsParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void exitAnyLineOrEOF(RatingsParser.AnyLineOrEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link RatingsParser#new_}.
	 * @param ctx the parse tree
	 */
	void enterNew_(RatingsParser.New_Context ctx);
	/**
	 * Exit a parse tree produced by {@link RatingsParser#new_}.
	 * @param ctx the parse tree
	 */
	void exitNew_(RatingsParser.New_Context ctx);
	/**
	 * Enter a parse tree produced by {@link RatingsParser#distribution}.
	 * @param ctx the parse tree
	 */
	void enterDistribution(RatingsParser.DistributionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RatingsParser#distribution}.
	 * @param ctx the parse tree
	 */
	void exitDistribution(RatingsParser.DistributionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RatingsParser#votes}.
	 * @param ctx the parse tree
	 */
	void enterVotes(RatingsParser.VotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RatingsParser#votes}.
	 * @param ctx the parse tree
	 */
	void exitVotes(RatingsParser.VotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RatingsParser#rank}.
	 * @param ctx the parse tree
	 */
	void enterRank(RatingsParser.RankContext ctx);
	/**
	 * Exit a parse tree produced by {@link RatingsParser#rank}.
	 * @param ctx the parse tree
	 */
	void exitRank(RatingsParser.RankContext ctx);
	/**
	 * Enter a parse tree produced by {@link RatingsParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(RatingsParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link RatingsParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(RatingsParser.TitleContext ctx);
}