package application.editor;

import application.editor.events.EventFunctionsEdit;
import application.editor.events.EventFunctionsFile;
import application.editor.events.EventFunctionsOther;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class EditorMenuBar {

	public EditorMenuBar(EventFunctionsFile eventFunctionsFile, EventFunctionsEdit eventFunctionsEdit,
			EventFunctionsOther eventFunctionsOther) {
		this.eventFunctionsFile = eventFunctionsFile;
		this.eventFunctionsEdit = eventFunctionsEdit;
		this.eventFunctionsOther = eventFunctionsOther;
		initMenuBar();
		initFileMenu();
		initEditMenu();
		initFormatMenu();
		initViewMenu();
		initHelpMenu();
	}

	EventFunctionsFile eventFunctionsFile;
	EventFunctionsEdit eventFunctionsEdit;
	EventFunctionsOther eventFunctionsOther;

	/********************************************************************************
	 * ******************************************************************************
	 * Elemente der MenuBar
	 * ******************************************************************************
	 ********************************************************************************/

	// MenuBar
	private MenuBar menuBar = new MenuBar();
	// Datei Menu
	private Menu fileMenu = new Menu("Datei");
	private MenuItem menuItemNew = new MenuItem("Neu");
	private MenuItem menuItemNewWindow = new MenuItem("Neues Fenster");
	private MenuItem menuItemOpen = new MenuItem("Öffnen");
	private MenuItem menuItemSave = new MenuItem("Speichern");
	private MenuItem menuItemSaveUnder = new MenuItem("Speichern unter...");
	private MenuItem menuItemClose = new MenuItem("Beenden");
	// Bearbeitungs Menu
	private Menu editMenu = new Menu("Bearbeiten");
	private MenuItem menuItemUndo = new MenuItem("Rückgängig");
	private MenuItem menuItemRedo = new MenuItem("Wiederholen");
	private MenuItem menuItemCut = new MenuItem("Ausschneiden");
	private MenuItem menuItemCopy = new MenuItem("Kopieren");
	private MenuItem menuItemPaste = new MenuItem("Einfügen");
	private MenuItem menuItemDelete = new MenuItem("Löschen");
	private MenuItem menuItemSearch = new MenuItem("Suchen");
	private MenuItem menuItemSelectAll = new MenuItem("Alles markieren");
	private MenuItem menuItemDate = new MenuItem("Datum & Uhrzeit");
	// Format Menu
	private Menu formatMenu = new Menu("Format");
	private CheckMenuItem checkMenuItemWordwrap = new CheckMenuItem("Zeilenumbruch");
	private MenuItem menuItemFont = new MenuItem("Schrifftart...");
	// Ansicht Menu
	private Menu viewMenu = new Menu("Ansicht");
	private CheckMenuItem checkMenuItemToolBar = new CheckMenuItem("Tools");
	private CheckMenuItem checkMenuItemStatusbar = new CheckMenuItem("Statusleiste");
	// Hilfe Menu
	private Menu helpMenu = new Menu("Hilfe");
	private MenuItem menuItemInfo = new MenuItem("Info");

	/********************************************************************************
	 * ******************************************************************************
	 * initialisierung der MenuBar
	 * ******************************************************************************
	 ********************************************************************************/

	/*****************************************************
	 * Initialisiere MenuBar
	 *****************************************************/
	private void initMenuBar() {

		menuBar.getMenus().addAll(fileMenu, editMenu, formatMenu, viewMenu, helpMenu);
	}

	/*****************************************************
	 * Initialisiere Menüpunkt Datei
	 *****************************************************/
	private void initFileMenu() {
		menuItemNew.setOnAction(e -> eventFunctionsFile.newFile());
		menuItemNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

		menuItemNewWindow.setOnAction(e -> eventFunctionsFile.launchAnotherApplication());
		menuItemNewWindow.setAccelerator(
				new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));

		menuItemOpen.setOnAction(e -> eventFunctionsFile.openFile());
		menuItemOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
		
		menuItemSave.setOnAction(e -> eventFunctionsFile.saveFile());
		menuItemSave.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		
		menuItemSaveUnder.setOnAction(e -> eventFunctionsFile.saveFileUnder());
		menuItemSaveUnder.setAccelerator(
				new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
		
		menuItemClose.setOnAction(e -> eventFunctionsFile.close());
		
		fileMenu.getItems().addAll(menuItemNew, menuItemNewWindow, menuItemOpen, menuItemSave, menuItemSaveUnder,
				new SeparatorMenuItem(), menuItemClose);
	}

	/*****************************************************
	 * Initialisiere Menüpunkt Bearbeiten
	 *****************************************************/
	private void initEditMenu() {
		menuItemUndo.setDisable(true); // WIP
		menuItemUndo.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));
		menuItemRedo.setDisable(true); // WIP
		menuItemRedo.setAccelerator(new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN));
		
		menuItemCut.setOnAction(e -> eventFunctionsEdit.cutOutSelectedText());
		menuItemCut.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
		menuItemCut.setDisable(true);
		
		menuItemCopy.setOnAction(e -> eventFunctionsEdit.copySelectedText());
		menuItemCopy.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
		menuItemCopy.setDisable(true);
		
		menuItemPaste.setOnAction(e -> eventFunctionsEdit.paste());
		menuItemPaste.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
		menuItemDelete.setDisable(true);
		
		menuItemDelete.setOnAction(e -> eventFunctionsEdit.deleteSelectedText());
		menuItemDelete.setAccelerator(new KeyCodeCombination(KeyCode.DELETE));
		
		menuItemSearch.setOnAction(e -> eventFunctionsEdit.searchReplace());
		menuItemSearch.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN));
		
		menuItemSelectAll.setOnAction(e -> eventFunctionsEdit.selectAll());
		menuItemSelectAll.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
		
		menuItemDate.setOnAction(e -> eventFunctionsEdit.timestamp());
		menuItemDate.setAccelerator(new KeyCodeCombination(KeyCode.F5));
		
		editMenu.getItems().addAll(menuItemUndo, menuItemRedo, new SeparatorMenuItem(), menuItemCut, menuItemCopy,
				menuItemPaste, menuItemDelete, new SeparatorMenuItem(), menuItemSearch, new SeparatorMenuItem(),
				menuItemSelectAll, menuItemDate);
	}

	/*****************************************************
	 * Initialisiere Menüpunkt Format
	 *****************************************************/
	private void initFormatMenu() {
		checkMenuItemWordwrap.setOnAction(e -> eventFunctionsOther.wordWrap(checkMenuItemWordwrap.isSelected()));
		menuItemFont.setOnAction(e -> eventFunctionsOther.font());
		formatMenu.getItems().addAll(checkMenuItemWordwrap, menuItemFont);
	}

	/*****************************************************
	 * Initialisiere Menüpunkt Ansicht
	 *****************************************************/
	private void initViewMenu() {
		checkMenuItemToolBar.setSelected(true);
		checkMenuItemToolBar.setOnAction(e -> eventFunctionsOther.displayToolBar(checkMenuItemToolBar.isSelected()));
		checkMenuItemStatusbar.setSelected(true);
		checkMenuItemStatusbar
				.setOnAction(e -> eventFunctionsOther.displayStatusBar(checkMenuItemStatusbar.isSelected()));
		viewMenu.getItems().addAll(checkMenuItemToolBar, checkMenuItemStatusbar);
	}

	/*****************************************************
	 * Initialisiere Menüpunkt Hilfe
	 *****************************************************/
	private void initHelpMenu() {
		menuItemInfo.setOnAction(e -> eventFunctionsOther.info());
		helpMenu.getItems().add(menuItemInfo);
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Getter & Setter
	 * ******************************************************************************
	 ********************************************************************************/

	public MenuBar getMenuBar() {

		return menuBar;
	}
}
