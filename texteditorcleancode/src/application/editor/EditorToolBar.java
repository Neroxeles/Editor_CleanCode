package application.editor;

import application.editor.events.EventFunctionsEdit;
import application.editor.events.EventFunctionsFile;
import application.editor.events.EventFunctionsOther;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;

public class EditorToolBar {

	public EditorToolBar(EventFunctionsFile eventFunctionsFile, EventFunctionsEdit eventFunctionsEdit, EventFunctionsOther eventFunctionsOther) {
		this.eventFunctionsFile = eventFunctionsFile;
		this.eventFunctionsEdit = eventFunctionsEdit;
		this.eventFunctionsOther = eventFunctionsOther;
		initToolBar();
		initFileTool();
		initEditTool();
		initSearchRequestTool();
		initUndoRedoTool();
		initFontTool();
	}
	
	private EventFunctionsFile eventFunctionsFile;
	private EventFunctionsEdit eventFunctionsEdit;
	private EventFunctionsOther eventFunctionsOther;

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
		buttonItemNewFile.setOnAction(e -> eventFunctionsFile.newFile());
		buttonItemNewFile.setTooltip(new Tooltip("Neu"));
		buttonItemNewFile.setId("buttonNewFile"); // CSS-ID
		
		buttonItemOpenFile.setOnAction(e -> eventFunctionsFile.openFile());
		buttonItemOpenFile.setTooltip(new Tooltip("Öffnen"));
		buttonItemOpenFile.setId("buttonOpenFile"); // CSS-ID
		
		buttonItemSaveFile.setOnAction(e -> eventFunctionsFile.saveFile());
		buttonItemSaveFile.setTooltip(new Tooltip("Speichern"));
		buttonItemSaveFile.setId("buttonSaveFile"); // CSS-ID
	}

	/*****************************************************
	 * Initialisiere Bearbeitungs-Gruppe
	 *****************************************************/
	private void initEditTool() {
		buttonItemCut.setOnAction(e -> eventFunctionsEdit.cutOutSelectedText());
		buttonItemCut.setTooltip(new Tooltip("Ausschneiden"));
		buttonItemCut.setDisable(true);
		buttonItemCut.setId("buttonCut"); // CSS-ID
		
		buttonItemCopy.setOnAction(e -> eventFunctionsEdit.copySelectedText());
		buttonItemCopy.setTooltip(new Tooltip("Kopieren"));
		buttonItemCopy.setDisable(true);
		buttonItemCopy.setId("buttonCopy"); // CSS-ID
		
		buttonItemPaste.setOnAction(e -> eventFunctionsEdit.paste());
		buttonItemPaste.setTooltip(new Tooltip("Einfügen"));
		buttonItemPaste.setId("buttonPaste"); // CSS-ID
	}

	/*****************************************************
	 * Initialisiere Suchen&Ersetzen-Gruppe
	 *****************************************************/
	private void initSearchRequestTool() {
		buttonItemSearch.setOnAction(e -> eventFunctionsEdit.searchReplace());
		buttonItemSearch.setTooltip(new Tooltip("Suchen / Ersetzen"));
		buttonItemSearch.setId("buttonSearch"); // CSS-ID
	}

	/*****************************************************
	 * Initialisiere Undo-Redo-Gruppe
	 *****************************************************/
	private void initUndoRedoTool() {
		buttonItemUndo.setDisable(true); // WIP
		buttonItemUndo.setTooltip(new Tooltip("Rückgängig"));
		buttonItemUndo.setId("buttonUndo"); // CSS-ID
		buttonItemRedo.setDisable(true); // WIP
		buttonItemRedo.setTooltip(new Tooltip("Wiederholen"));
		buttonItemRedo.setId("buttonRedo"); // CSS-ID
	}

	/*****************************************************
	 * Initialisiere Font-Gruppe
	 *****************************************************/
	private void initFontTool() {
		buttonItemSmallerFont.setOnAction(e -> eventFunctionsOther.fontSizeShrink());
		buttonItemSmallerFont.setTooltip(new Tooltip("Verkleinern"));
		buttonItemSmallerFont.setDisable(true);
		buttonItemSmallerFont.setId("buttonSmallerFont"); // CSS-ID
		
		buttonItemLargerFont.setOnAction(e -> eventFunctionsOther.fontSizeGrow());
		buttonItemLargerFont.setTooltip(new Tooltip("Vergrößern"));
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
