package application.editor;

import javafx.scene.control.Label;

public class EditorStatusBar {

	public EditorStatusBar() {
		
	}
	
	/********************************************************************************
	 * ******************************************************************************
	 * Elemente der StatusBar
	 * ******************************************************************************
	 ********************************************************************************/
	
	private Label statusBar = new Label("TEST");
	
	/********************************************************************************
	 * ******************************************************************************
	 * initialisierung der StatusBar
	 * ******************************************************************************
	 ********************************************************************************/
	
	/********************************************************************************
	 * ******************************************************************************
	 * Getter & Setter
	 * ******************************************************************************
	 ********************************************************************************/
	
	public Label getStatusBar() {
		return statusBar;
	}
}