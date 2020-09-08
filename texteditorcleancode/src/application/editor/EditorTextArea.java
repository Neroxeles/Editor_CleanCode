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

	public boolean selectSubstringFrom(String substring) {
		int anchor = textArea.getText().indexOf(substring, textArea.getCaretPosition());
		if (anchor != -1) {
			textArea.selectRange(anchor, anchor + substring.length());
			// Substring ist im Text enthalten
			return true;
		} else {
			anchor = textArea.getText().indexOf(substring, 0);
			if (anchor != -1) {
				textArea.selectRange(anchor, anchor + substring.length());
				// Substring ist im Text enthalten
				return true;
			} else {
				// Substring ist nicht im Text enthalten
				return false;
			}
		}
	}
	
	public boolean selectLastSubstringFrom(String substring) {
		int anchor = textArea.getText().lastIndexOf(substring, textArea.getCaretPosition() - substring.length() - 1);
		if (anchor != -1) {
			textArea.selectRange(anchor, anchor + substring.length());
			// Substring ist im Text enthalten
			return true;
		} else {
			anchor = textArea.getText().lastIndexOf(substring, textArea.getText().length()-1);
			if (anchor != -1) {
				textArea.selectRange(anchor, anchor + substring.length());
				// Substring ist im Text enthalten
				return true;
			} else {
				// Substring ist nicht im Text enthalten
				return false;
			}
		}
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
