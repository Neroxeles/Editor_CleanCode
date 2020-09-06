package application.editor;

import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;

public class EditorToolBar {

	public EditorToolBar() {
		initToolBar();
		initFileTool();
		initEditTool();
		initSearchRequestTool();
		initUndoRedoTool();
		initFontTool();
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Elemente der ToolBar
	 * ******************************************************************************
	 ********************************************************************************/

	// ToolBar
	private ToolBar toolBar = new ToolBar();
	// Datei-Gruppe
	private Button buttonItemNewFile = new Button();
	private Button buttonItemOpenFile = new Button();
	private Button buttonItemSaveFile = new Button();
	// Bearbeitungs-Gruppe
	private Button buttonItemCut = new Button();
	private Button buttonItemCopy = new Button();
	private Button buttonItemPaste = new Button();
	// Suchen&Ersetzen-Gruppe
	private Button buttonItemSearch = new Button();
	// Undo-Redo-Gruppe
	private Button buttonItemUndo = new Button();
	private Button buttonItemRedo = new Button();
	// Font-Gruppe
	private Button buttonItemSmallerFont = new Button();
	private Button buttonItemLargerFont = new Button();

	/********************************************************************************
	 * ******************************************************************************
	 * initialisierung der ToolBar
	 * ******************************************************************************
	 ********************************************************************************/

	/*****************************************************
	 * Initialisiere ToolBar
	 *****************************************************/
	private void initToolBar() {

		toolBar.getItems().addAll(buttonItemNewFile, buttonItemOpenFile, buttonItemSaveFile, new Separator(),
				buttonItemCut, buttonItemCopy, buttonItemPaste, new Separator(), buttonItemSearch, new Separator(),
				buttonItemUndo, buttonItemRedo, new Separator(), buttonItemSmallerFont, buttonItemLargerFont);
	}

	/*****************************************************
	 * Initialisiere Datei-Gruppe
	 *****************************************************/
	private void initFileTool() {
		buttonItemNewFile.setId("buttonNewFile"); // CSS-ID
		buttonItemOpenFile.setId("buttonOpenFile"); // CSS-ID
		buttonItemSaveFile.setId("buttonSaveFile"); // CSS-ID
	}

	/*****************************************************
	 * Initialisiere Bearbeitungs-Gruppe
	 *****************************************************/
	private void initEditTool() {
		buttonItemCut.setId("buttonCut"); // CSS-ID
		buttonItemCopy.setId("buttonCopy"); // CSS-ID
		buttonItemPaste.setId("buttonPaste"); // CSS-ID
	}

	/*****************************************************
	 * Initialisiere Suchen&Ersetzen-Gruppe
	 *****************************************************/
	private void initSearchRequestTool() {
		buttonItemSearch.setId("buttonSearch"); // CSS-ID
	}

	/*****************************************************
	 * Initialisiere Undo-Redo-Gruppe
	 *****************************************************/
	private void initUndoRedoTool() {
		buttonItemUndo.setId("buttonUndo"); // CSS-ID
		buttonItemRedo.setId("buttonRedo"); // CSS-ID
	}

	/*****************************************************
	 * Initialisiere Font-Gruppe
	 *****************************************************/
	private void initFontTool() {
		buttonItemSmallerFont.setId("buttonSmallerFont"); // CSS-ID
		buttonItemLargerFont.setId("buttonLargerFont"); // CSS-ID
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Getter & Setter
	 * ******************************************************************************
	 ********************************************************************************/

	public ToolBar getToolBar() {
		return toolBar;
	}
}
