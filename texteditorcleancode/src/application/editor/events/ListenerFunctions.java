package application.editor.events;

import application.controller.Values;
import application.editor.EditorMenuBar;
import application.editor.EditorStatusBar;
import application.editor.EditorToolBar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.IndexRange;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ListenerFunctions {

	public void setNeeds(Values values, EditorStatusBar editorStatusBar, EditorMenuBar editorMenuBar, EditorToolBar editorToolBar, Stage primaryStage) {
		this.values = values;
		this.editorStatusBar = editorStatusBar;
		this.primaryStage = primaryStage;
		this.editorMenuBar = editorMenuBar;
		this.editorToolBar = editorToolBar;
	}

	private Values values;
	private EditorStatusBar editorStatusBar;
	private EditorMenuBar editorMenuBar;
	private EditorToolBar editorToolBar;
	private Stage primaryStage;

	public void addListenerToTextArea(TextArea textArea) {
		// Informationen aktualisieren
		textArea.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!values.isUpdated()) {
					values.setUpdated(true);
					primaryStage.setTitle(values.getFilePath() + " *");
				}
				// Informationen für die StatusBar
				// Gesamt Zeilen und gesamt Zeichen des Dokuments
				editorStatusBar.setLabelLengthAndLines("Length: " + textArea.getText().length() + "\tLines: "
						+ (textArea.getText() + "a").split("\n").length);
			}
		});

		// Informationen aktualisieren
		textArea.caretPositionProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> {
			// relative zur Caret-Position
			editorStatusBar.setLabelCaretPos("Ln: " + getCaretPos(textArea.getText(), textArea.getCaretPosition())[0]
					+ "\t  Col: " + getCaretPos(textArea.getText(), textArea.getCaretPosition())[1]);
		});

		// Kontextsensivität
		// Ausschneiden, Kopieren, Löschen
		textArea.selectionProperty().addListener((ChangeListener<IndexRange>) (obserable, oldValue, newValue) -> {
			if (newValue.getLength() != 0) {
				editorToolBar.buttonItemCopySetDisabled(false);
				editorToolBar.buttonItemCutSetDisabled(false);
				editorMenuBar.menuItemCopySetDisabled(false);
				editorMenuBar.menuItemCutSetDisabled(false);
				editorMenuBar.menuItemDeleteSetDisabled(false);
			} else {
				editorToolBar.buttonItemCopySetDisabled(true);
				editorToolBar.buttonItemCutSetDisabled(true);
				editorMenuBar.menuItemCopySetDisabled(true);
				editorMenuBar.menuItemCutSetDisabled(true);
				editorMenuBar.menuItemDeleteSetDisabled(true);
			}
		});
	}

	/*****************************************************
	 * Routine zum Berechnen der Caret-Position
	 *****************************************************/
	private int[] getCaretPos(String text, int currentPos) {
		int[] caretPos = new int[2]; // Position X und Y
		int lines = (text + "a").split("\n").length; // Anzahl der Zeilen
		int[] segmentEnd = new int[lines]; // endposition des Segments

		// füge dem Text ein "\nEOF" bei
		text = text + "\nEOF";

		// Erstelle einen 2DString
		for (int i = 0; i < lines; i++) {
			if (i == 0) {
				segmentEnd[i] = text.indexOf("\n");
			} else {
				segmentEnd[i] = text.indexOf("\n", segmentEnd[i - 1] + 1);
			}
		}
		for (int i = 0; i < lines; i++) {

			// Prüfe in welcher Zeile der Curser steht
			if (segmentEnd[i] >= currentPos) {
				caretPos[0] = i + 1;
				// Prüfe in welcher Spalte der Cursor ist
				if (i == 0) {
					caretPos[1] = currentPos + 1;
				} else {
					caretPos[1] = (currentPos - segmentEnd[i - 1]);
				}
				break;
			}
		}
		return caretPos;
	}
}
