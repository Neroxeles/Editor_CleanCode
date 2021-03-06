package application.editor.events;

import application.controller.Values;
import application.editor.Editor;
import application.editor.EditorTextArea;
import application.editor.EditorToolBar;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EventFunctionsOther {

	public void setNeeds(Values values, Editor editor, EditorTextArea editorTextArea, EditorToolBar editorToolBar,
			Stage fontStage, Stage infoStage) {
		this.values = values;
		this.editor = editor;
		this.editorTextArea = editorTextArea;
		this.editorToolBar = editorToolBar;
		this.fontStage = fontStage;
		this.infoStage = infoStage;
	}

	Values values;
	Editor editor;
	EditorTextArea editorTextArea;
	EditorToolBar editorToolBar;
	Stage fontStage;
	Stage infoStage;

	/*****************************************************
	 * Methode - WordWrap
	 *****************************************************/
	public void wordWrap(boolean activate) {
		editorTextArea.setWordWrap(activate);
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methode - Font
	 *****************************************************/
	public void font() {
		if (fontStage.isShowing() == false) {
			fontStage.show();
		}
		fontStage.toFront();
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methode - DisplayToolBar
	 *****************************************************/
	public void displayToolBar(boolean show) {
		editor.showToolBar(show);
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methode - DisplayStatusBar
	 *****************************************************/
	public void displayStatusBar(boolean show) {
		editor.showStatusBar(show);
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methode - Info
	 *****************************************************/
	public void info() {
		if (infoStage.isShowing() == false) {
			infoStage.show();
		}
		infoStage.toFront();
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methode - Schriftgröße verkleinern
	 *****************************************************/
	public void fontSizeShrink() {

		if (values.getFontSize() > 10) {
			values.setFontSize(values.getFontSize() - 10);
			editorTextArea.setFont(Font.font(values.getFontFamily(), values.getFontSize()));
			editorToolBar.buttonItemLargerFontSetDisabled(false);
		}
		if (values.getFontSize() == 10) {
			editorToolBar.buttonItemSmallerFontSetDisabled(true);
		}

		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methode - Schriftgröße vergrößern
	 *****************************************************/
	public void fontSizeGrow() {

		if (values.getFontSize() < 70) {
			values.setFontSize(values.getFontSize() + 10);
			editorTextArea.setFont(Font.font(values.getFontFamily(), values.getFontSize()));
			editorToolBar.buttonItemSmallerFontSetDisabled(false);
		}
		if (values.getFontSize() == 70) {
			editorToolBar.buttonItemLargerFontSetDisabled(true);
		}

		editorTextArea.requestFocus();
	}
}
