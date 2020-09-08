package application.controller;

import application.editor.Editor;
import application.editor.EditorMenuBar;
import application.editor.EditorStatusBar;
import application.editor.EditorTextArea;
import application.editor.EditorToolBar;
import application.editor.events.EventFunctionsEdit;
import application.editor.events.EventFunctionsFile;
import application.editor.events.EventFunctionsOther;
import application.font.Font;
import application.font.FontElements;
import application.info.Info;
import application.info.InfoElements;
import application.saverequest.SaveRequest;
import application.saverequest.SaveRequestElements;
import application.searchreplace.SearchReplace;
import application.searchreplace.SearchReplaceElements;
import javafx.stage.Stage;

public class Controller {

	/*****************************************************
	 * Konstruktor
	 *****************************************************/
	public Controller(Stage primaryStage) {
		this.primaryStage = primaryStage;
		initEditorNeeds();
	}

	Values values = new Values();

	/********************************************************************************
	 * ******************************************************************************
	 * Alles zur primaryStage
	 * ******************************************************************************
	 ********************************************************************************/

	// Stage
	private Stage primaryStage;

	// Events
	private EventFunctionsFile eventFunctionsFile;
	private EventFunctionsEdit eventFunctionsEdit;
	private EventFunctionsOther eventFunctionsOther;

	// Elemente der PrimaryScene
	private EditorMenuBar editorMenuBar;
	private EditorToolBar editorToolBar;
	private EditorTextArea editorTextArea;
	private EditorStatusBar editorStatusBar;

	// Scene für die primaryStage
	private Editor editor;

	/*****************************************************
	 * Innitialisieren der PrimaryStage
	 *****************************************************/
	public void initEditor() {

		editor = new Editor(editorMenuBar, editorToolBar, editorTextArea, editorStatusBar, primaryStage);
	}

	/*****************************************************
	 * Innitialisieren der Notwendigen Utensilien
	 *****************************************************/
	private void initEditorNeeds() {
		editorTextArea = new EditorTextArea();
		eventFunctionsFile = new EventFunctionsFile(values, editorTextArea, saveRequestStage, primaryStage);
		eventFunctionsEdit = new EventFunctionsEdit(editorTextArea, searchReplaceStage);
		eventFunctionsOther = new EventFunctionsOther(values, editor, editorTextArea, fontStage, infoStage);

		editorMenuBar = new EditorMenuBar(eventFunctionsFile, eventFunctionsEdit, eventFunctionsOther);
		editorToolBar = new EditorToolBar();
		
		editorStatusBar = new EditorStatusBar();
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Alles zur saveRequestStage
	 * ******************************************************************************
	 ********************************************************************************/

	// Stage
	private Stage saveRequestStage = new Stage();

	// Elemente der saveRequestStage
	private SaveRequestElements saveRequestElements = new SaveRequestElements(values, editorTextArea, primaryStage, saveRequestStage);

	// Scene für die saveRequestStage
	private SaveRequest saveRequest;

	/*****************************************************
	 * Innitialisieren der SaveRequestStage
	 *****************************************************/
	public void initSaveRequestStage() {

		saveRequest = new SaveRequest(saveRequestElements, saveRequestStage);
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Alles zur SearchReplaceStage
	 * ******************************************************************************
	 ********************************************************************************/

	// Stage
	private Stage searchReplaceStage = new Stage();

	// Elemente der SearchReplaceStage
	private SearchReplaceElements searchReplaceElements = new SearchReplaceElements(editorTextArea);

	// Scene für die SearchReplaceStage
	private SearchReplace searchReplace;

	/*****************************************************
	 * Innitialisieren der SearchReplaceStage
	 *****************************************************/
	public void initSearchReplaceStage() {

		searchReplace = new SearchReplace(searchReplaceElements, searchReplaceStage);
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Alles zur FontStage
	 * ******************************************************************************
	 ********************************************************************************/

	// Stage
	private Stage fontStage = new Stage();

	// Elemente der SearchReplaceStage
	private FontElements fontElements = new FontElements(values, editorTextArea);

	// Scene für die FontStage
	private Font font;

	/*****************************************************
	 * Innitialisieren der FontStage
	 *****************************************************/
	public void initFontStage() {

		font = new Font(fontElements, fontStage);
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Alles zur InfoStage
	 * ******************************************************************************
	 ********************************************************************************/

	// Stage
	private Stage infoStage = new Stage();

	// Elemente der InfoStage
	private InfoElements infoElements = new InfoElements();

	// Scene für die InfoStage
	private Info info;

	/*****************************************************
	 * Innitialisieren der InfoStage
	 *****************************************************/
	public void initInfoStage() {

		info = new Info(infoElements, infoStage);
	}
}
