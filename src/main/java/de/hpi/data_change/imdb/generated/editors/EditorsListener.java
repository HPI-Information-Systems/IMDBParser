// Generated from C:/Users/Leon.Bornemann/IdeaProjects/IMDBParser/resources/grammars\Editors.g4 by ANTLR 4.7
package de.hpi.data_change.imdb.generated.editors;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EditorsParser}.
 */
public interface EditorsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EditorsParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(EditorsParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link EditorsParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(EditorsParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link EditorsParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void enterAnythingButStart(EditorsParser.AnythingButStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link EditorsParser#anythingButStart}.
	 * @param ctx the parse tree
	 */
	void exitAnythingButStart(EditorsParser.AnythingButStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link EditorsParser#anyline}.
	 * @param ctx the parse tree
	 */
	void enterAnyline(EditorsParser.AnylineContext ctx);
	/**
	 * Exit a parse tree produced by {@link EditorsParser#anyline}.
	 * @param ctx the parse tree
	 */
	void exitAnyline(EditorsParser.AnylineContext ctx);
	/**
	 * Enter a parse tree produced by {@link EditorsParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void enterAnyLineOrEOF(EditorsParser.AnyLineOrEOFContext ctx);
	/**
	 * Exit a parse tree produced by {@link EditorsParser#anyLineOrEOF}.
	 * @param ctx the parse tree
	 */
	void exitAnyLineOrEOF(EditorsParser.AnyLineOrEOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link EditorsParser#editorList}.
	 * @param ctx the parse tree
	 */
	void enterEditorList(EditorsParser.EditorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EditorsParser#editorList}.
	 * @param ctx the parse tree
	 */
	void exitEditorList(EditorsParser.EditorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EditorsParser#editorAndWork}.
	 * @param ctx the parse tree
	 */
	void enterEditorAndWork(EditorsParser.EditorAndWorkContext ctx);
	/**
	 * Exit a parse tree produced by {@link EditorsParser#editorAndWork}.
	 * @param ctx the parse tree
	 */
	void exitEditorAndWork(EditorsParser.EditorAndWorkContext ctx);
	/**
	 * Enter a parse tree produced by {@link EditorsParser#editorName}.
	 * @param ctx the parse tree
	 */
	void enterEditorName(EditorsParser.EditorNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EditorsParser#editorName}.
	 * @param ctx the parse tree
	 */
	void exitEditorName(EditorsParser.EditorNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link EditorsParser#workList}.
	 * @param ctx the parse tree
	 */
	void enterWorkList(EditorsParser.WorkListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EditorsParser#workList}.
	 * @param ctx the parse tree
	 */
	void exitWorkList(EditorsParser.WorkListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EditorsParser#workElement}.
	 * @param ctx the parse tree
	 */
	void enterWorkElement(EditorsParser.WorkElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EditorsParser#workElement}.
	 * @param ctx the parse tree
	 */
	void exitWorkElement(EditorsParser.WorkElementContext ctx);
}