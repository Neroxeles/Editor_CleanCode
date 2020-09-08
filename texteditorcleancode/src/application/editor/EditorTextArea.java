package application.editor;

import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

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

	public void setFont(Font font) {
		textArea.setFont(font);
	}

	public String getText() {
		return textArea.getText();
	}

	public void selectAll() {
		textArea.selectAll();
	}

	public String getSelectedText() {
		return textArea.getSelectedText();
	}

	public void replaceSelection(String replacement) {
		textArea.replaceSelection(replacement);
	}

	public void insertText(int caretPosition, String string) {
		textArea.insertText(caretPosition, string);
	}

	public void appendText(String string) {
		textArea.appendText(string);
	}

	public int getCaretPosition() {
		return textArea.getCaretPosition();
	}

	public void setWordWrap(boolean activate) {
		textArea.setWrapText(activate);
	}

	public void requestFocus() {
		textArea.requestFocus();
	}
}
