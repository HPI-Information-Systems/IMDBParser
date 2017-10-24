// Generated from /home/leon/IdeaProjects/IMDBParser/resources/grammars/Plot.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.plot;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PlotParser}.
 */
public interface PlotListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PlotParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(PlotParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(PlotParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void enterAnythingButStart(PlotParser.AnythingButStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void exitAnythingButStart(PlotParser.AnythingButStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#anyline}.
	 * @param ctx the parse tree
	 */
	void enterAnyline(PlotParser.AnylineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#anyline}.
	 * @param ctx the parse tree
	 */
	void exitAnyline(PlotParser.AnylineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#plot}.
	 * @param ctx the parse tree
	 */
	void enterPlot(PlotParser.PlotContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#plot}.
	 * @param ctx the parse tree
	 */
	void exitPlot(PlotParser.PlotContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#plotstartline}.
	 * @param ctx the parse tree
	 */
	void enterPlotstartline(PlotParser.PlotstartlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#plotstartline}.
	 * @param ctx the parse tree
	 */
	void exitPlotstartline(PlotParser.PlotstartlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#plotDescription}.
	 * @param ctx the parse tree
	 */
	void enterPlotDescription(PlotParser.PlotDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#plotDescription}.
	 * @param ctx the parse tree
	 */
	void exitPlotDescription(PlotParser.PlotDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#plotlines}.
	 * @param ctx the parse tree
	 */
	void enterPlotlines(PlotParser.PlotlinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#plotlines}.
	 * @param ctx the parse tree
	 */
	void exitPlotlines(PlotParser.PlotlinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#plotline}.
	 * @param ctx the parse tree
	 */
	void enterPlotline(PlotParser.PlotlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#plotline}.
	 * @param ctx the parse tree
	 */
	void exitPlotline(PlotParser.PlotlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void enterAnyLineOrEOF(PlotParser.AnyLineOrEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void exitAnyLineOrEOF(PlotParser.AnyLineOrEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#titleline}.
	 * @param ctx the parse tree
	 */
	void enterTitleline(PlotParser.TitlelineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#titleline}.
	 * @param ctx the parse tree
	 */
	void exitTitleline(PlotParser.TitlelineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#author}.
	 * @param ctx the parse tree
	 */
	void enterAuthor(PlotParser.AuthorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#author}.
	 * @param ctx the parse tree
	 */
	void exitAuthor(PlotParser.AuthorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlotParser#anystring}.
	 * @param ctx the parse tree
	 */
	void enterAnystring(PlotParser.AnystringContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlotParser#anystring}.
	 * @param ctx the parse tree
	 */
	void exitAnystring(PlotParser.AnystringContext ctx);
}