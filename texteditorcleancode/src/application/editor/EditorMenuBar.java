package application.editor;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class EditorMenuBar {

	public EditorMenuBar() {
		initMenuBar();
		initFileMenu();
		initEditMenu();
		initFormatMenu();
		initViewMenu();
		initHelpMenu();
	}

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
	private MenuItem menuItemOpen = new MenuItem("�ffnen");
	private MenuItem menuItemSave = new MenuItem("Speichern");
	private MenuItem menuItemSaveUnder = new MenuItem("Speichern unter...");
	private MenuItem menuItemClose = new MenuItem("Beenden");
	// Bearbeitungs Menu
	private Menu editMenu = new Menu("Bearbeiten");
	private MenuItem menuItemUndo = new MenuItem("R�ckg�ngig");
	private MenuItem menuItemRedo = new MenuItem("Wiederholen");
	private MenuItem menuItemCut = new MenuItem("Ausschneiden");
	private MenuItem menuItemCopy = new MenuItem("Kopieren");
	private MenuItem menuItemPaste = new MenuItem("Einf�gen");
	private MenuItem menuItemDelete = new MenuItem("L�schen");
	private MenuItem menuItemSearch = new MenuItem("Suchen");
	private MenuItem menuItemSelectAll = new MenuItem("Alles markieren");
	private MenuItem menuItemDate = new MenuItem("Datum & Uhrzeit");
	// Format Menu
	private Menu formatMenu = new Menu("Format");
	private CheckMenuItem checkMenuItemWordwrap = new CheckMenuItem("Zeilenumbruch");
	private MenuItem menuItemFont = new MenuItem("Schrifftart...");
	// Ansicht Menu
	private Menu viewMenu = new Menu("Ansicht");
	private MenuItem menuItemStatusbar = new MenuItem("Statusleiste");
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
	 * Initialisiere Men�punkt Datei
	 *****************************************************/
	private void initFileMenu() {

		fileMenu.getItems().addAll(menuItemNew, menuItemNewWindow, menuItemOpen, menuItemSave, menuItemSaveUnder,
				new SeparatorMenuItem(), menuItemClose);
	}

	/*****************************************************
	 * Initialisiere Men�punkt Bearbeiten
	 *****************************************************/
	private void initEditMenu() {

		editMenu.getItems().addAll(menuItemUndo, menuItemRedo, new SeparatorMenuItem(), menuItemCut, menuItemCopy,
				menuItemPaste, menuItemDelete, new SeparatorMenuItem(), menuItemSearch, new SeparatorMenuItem(),
				menuItemSelectAll, menuItemDate);
	}

	/*****************************************************
	 * Initialisiere Men�punkt Format
	 *****************************************************/
	private void initFormatMenu() {

		formatMenu.getItems().addAll(checkMenuItemWordwrap, menuItemFont);
	}

	/*****************************************************
	 * Initialisiere Men�punkt Ansicht
	 *****************************************************/
	private void initViewMenu() {

		viewMenu.getItems().add(menuItemStatusbar);
	}

	/*****************************************************
	 * Initialisiere Men�punkt Hilfe
	 *****************************************************/
	private void initHelpMenu() {

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