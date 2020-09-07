package application.editor;

import javafx.scene.control.TextArea;

public class EditorTextArea {

	public EditorTextArea() {
		initTextArea();
	}

	// TextArea
	private TextArea textArea = new TextArea();

	/********************************************************************************
	 * ******************************************************************************
	 * Initialisiere alle Elemente
	 * ******************************************************************************
	 ********************************************************************************/

	private void initTextArea() {

	}

	/********************************************************************************
	 * ******************************************************************************
	 * Getter & Setter
	 * ******************************************************************************
	 ********************************************************************************/

	public TextArea getTextArea() {
		textArea.setPrefHeight(5000);
		return textArea;
	}

	public void setText(String text) {
		textArea.setText(text);
	}
	
	public String getText() {
		return textArea.getText();
	}

	public void requestFocus() {
		textArea.requestFocus();
	}
}
