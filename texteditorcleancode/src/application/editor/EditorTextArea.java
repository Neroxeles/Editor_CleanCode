package application.editor;

import java.io.IOException;

import application.controller.Values;
import application.editor.events.EventFunctionsFile;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EditorTextArea {

	public EditorTextArea(Values values, Stage primaryStage, EventFunctionsFile eventFunctionsFile) {
		this.values = values;
		this.primaryStage = primaryStage;
		this.eventFunctionsFile = eventFunctionsFile;
		initTextArea();
	}

	private Values values;
	private Stage primaryStage;
	private EventFunctionsFile eventFunctionsFile;
	
	// TextArea
	private TextArea textArea = new TextArea();

	/********************************************************************************
	 * ******************************************************************************
	 * Initialisiere alle Elemente
	 * ******************************************************************************
	 ********************************************************************************/

	private void initTextArea() {
		textArea.setPrefHeight(5000);
		// Überprüfe, ob Datensätze aktualisiert wurden
		this.textArea.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!values.isUpdated()) {
					values.setUpdated(true);
					primaryStage.setTitle(values.getFilePath() + " *");
				}
			}
		});
		textArea.setFont(Font.font(values.getFontFamily(), values.getFontSize()));
		// Drag&Drop Over
		textArea.setOnDragOver(e -> {
			if (e.getGestureSource() != textArea && e.getDragboard().hasFiles()) {
				// allow for both copying and moving, whatever user chooses
				e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			}
			e.consume();
		});
		// Drag&Drop Dropped
		textArea.setOnDragDropped(e -> {
			Dragboard db = e.getDragboard();
			boolean success = false;

			if (db.getFiles().get(0).toString().endsWith(".txt")) {
				try {
					eventFunctionsFile.openFileViaDragnDrop(db.getFiles().get(0).toString(), primaryStage);
				} catch (IOException e1) {
				}
				success = true;
			}

			// let the source know whether the string was successfully transferred and used
			e.setDropCompleted(success);
			e.consume();
		});
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Getter & Setter
	 * ******************************************************************************
	 ********************************************************************************/

	public TextArea getTextArea() {
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
			anchor = textArea.getText().lastIndexOf(substring, textArea.getText().length() - 1);
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
