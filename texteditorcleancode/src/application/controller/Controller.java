package application.controller;

import application.editor.Editor;
import application.editor.EditorMenuBar;
import application.editor.EditorStatusBar;
import application.editor.EditorTextArea;
import application.editor.EditorToolBar;
import application.editor.events.EventFunctionsEdit;
import application.editor.events.EventFunctionsFile;
import application.editor.events.EventFunctionsOther;
import application.editor.events.ListenerFunctions;
import application.font.Font;
import application.font.FontElements;
import application.font.events.EventFunctionsFont;
import application.info.Info;
import application.info.InfoElements;
import application.saverequest.SaveRequest;
import application.saverequest.SaveRequestElements;
import application.saverequest.events.EventFunctionsSaveRequest;
import application.searchreplace.SearchReplace;
import application.searchreplace.SearchReplaceElements;
import application.searchreplace.events.EventFunctionsSearchReplace;
import javafx.stage.Stage;

public class Controller {

	/*****************************************************
	 * Konstruktor
	 *****************************************************/
	public Controller(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private Values values = new Values();

	/********************************************************************************
	 * ******************************************************************************
	 * Alles zur primaryStage
	 * ******************************************************************************
	 ********************************************************************************/

	// Stage
	private Stage primaryStage;

	// Events --> siehe unten "Notwendige Bidirektionalität"
	private EventFunctionsFile eventFunctionsFile;
	private EventFunctionsEdit eventFunctionsEdit;
	private EventFunctionsOther eventFunctionsOther;
	
	// Listener
	private ListenerFunctions listenerFunctions;

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
		eventFunctionsFile = new EventFunctionsFile();
		eventFunctionsEdit = new EventFunctionsEdit();
		eventFunctionsOther = new EventFunctionsOther();
		
		listenerFunctions = new ListenerFunctions();

		editorMenuBar = new EditorMenuBar(eventFunctionsFile, eventFunctionsEdit, eventFunctionsOther);
		editorToolBar = new EditorToolBar(eventFunctionsFile, eventFunctionsEdit, eventFunctionsOther);
		editorTextArea = new EditorTextArea(values, eventFunctionsFile, listenerFunctions);
		editorStatusBar = new EditorStatusBar();

		editor = new Editor(eventFunctionsFile, editorMenuBar, editorToolBar, editorTextArea, editorStatusBar, primaryStage);
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Alles zur saveRequestStage
	 * ******************************************************************************
	 ********************************************************************************/

	// Stage
	private Stage saveRequestStage;

	// Events
	private EventFunctionsSaveRequest eventFunctionsSaveRequest;

	// Elemente der saveRequestStage
	private SaveRequestElements saveRequestElements;

	// Scene für die saveRequestStage
	private SaveRequest saveRequest;

	/*****************************************************
	 * Innitialisieren der SaveRequestStage
	 *****************************************************/
	public void initSaveRequestStage() {
		saveRequestStage = new Stage();

		eventFunctionsSaveRequest = new EventFunctionsSaveRequest(values, editorTextArea, primaryStage,
				saveRequestStage);

		saveRequestElements = new SaveRequestElements(eventFunctionsSaveRequest);

		saveRequest = new SaveRequest(eventFunctionsSaveRequest, saveRequestElements, saveRequestStage);
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Alles zur SearchReplaceStage
	 * ******************************************************************************
	 ********************************************************************************/

	// Stage
	private Stage searchReplaceStage;

	// Events
	private EventFunctionsSearchReplace eventFunctionsSearchReplace;

	// Elemente der SearchReplaceStage
	private SearchReplaceElements searchReplaceElements;

	// Scene für die SearchReplaceStage
	private SearchReplace searchReplace;

	/*****************************************************
	 * Innitialisieren der SearchReplaceStage
	 *****************************************************/
	public void initSearchReplaceStage() {
		searchReplaceStage = new Stage();

		eventFunctionsSearchReplace = new EventFunctionsSearchReplace(editorTextArea);

		searchReplaceElements = new SearchReplaceElements(eventFunctionsSearchReplace);

		searchReplace = new SearchReplace(searchReplaceElements, searchReplaceStage);
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Alles zur FontStage
	 * ******************************************************************************
	 ********************************************************************************/

	// Stage
	private Stage fontStage;

	// Events
	EventFunctionsFont eventFunctionsFont;

	// Elemente der SearchReplaceStage
	private FontElements fontElements;

	// Scene für die FontStage
	private Font font;

	/*****************************************************
	 * Innitialisieren der FontStage
	 *****************************************************/
	public void initFontStage() {
		fontStage = new Stage();

		eventFunctionsFont = new EventFunctionsFont(editorTextArea, editorToolBar);

		fontElements = new FontElements(values, eventFunctionsFont);

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
		infoStage = new Stage();

		infoElements = new InfoElements();

		info = new Info(infoElements, infoStage);
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Notwendige Bidirektionalität
	 * ******************************************************************************
	 ********************************************************************************/
	public void initBidirectionality() {
		eventFunctionsFile.setNeeds(values, editorTextArea, saveRequestStage, primaryStage, fontStage, infoStage, searchReplaceStage);
		eventFunctionsEdit.setNeeds(editorTextArea, searchReplaceStage);
		eventFunctionsOther.setNeeds(values, editor, editorTextArea, editorToolBar, fontStage, infoStage);
		listenerFunctions.setNeeds(values, editorStatusBar, editorMenuBar, editorToolBar, primaryStage);
	}
}
