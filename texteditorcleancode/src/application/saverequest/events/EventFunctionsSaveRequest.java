package application.saverequest.events;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import application.controller.Values;
import application.editor.EditorTextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class EventFunctionsSaveRequest {

	public EventFunctionsSaveRequest(Values values, EditorTextArea editorTextArea, Stage primaryStage, Stage saveRequestStage) {
		this.values = values;
		this.editorTextArea = editorTextArea;
		this.primaryStage = primaryStage;
		this.saveRequestStage = saveRequestStage;
	}
	
	Values values;
	EditorTextArea editorTextArea;
	Stage primaryStage;
	Stage saveRequestStage;
	
	/*****************************************************
	 * Methode - saveFile
	 *****************************************************/
	public void saveFile() {
		if (values.getFilePath() != "Unknown") {
			File file = new File(values.getFilePath());
			functionSave(file);
			editorTextArea.requestFocus();
		} else {
			// Wenn kein Dateipfad derzeit existiert
			saveFileUnder();
		}
		saveRequestStage.close();
	}

	/*****************************************************
	 * Methode - saveFileUnder
	 *****************************************************/
	private void saveFileUnder() {
		// FileChooser
		FileChooser fileChooser = new FileChooser();
		// File
		File file;

		fileChooser.setTitle("Speichere Datei");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));

		// Prüfe auf vorhandenen Dateipfad
		if (values.getFilePath() != "Unknown") {
			file = new File(values.getFilePath());
			fileChooser.setInitialDirectory(file.getParentFile());
		}
		fileChooser.setInitialFileName("file");
		file = fileChooser.showSaveDialog(saveRequestStage);

		functionSave(file);
		editorTextArea.requestFocus();
	}
	
	/*****************************************************
	 * Funktion für saveFile
	 *****************************************************/
	private void functionSave(File file) {

		// Auslesen des Textfeldes und in Datei schreiben
		if (file != null) {
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(editorTextArea.getText());
				fileWriter.close();
			} catch (IOException e) {

			}
			values.setFilePath(file.getPath());
			primaryStage.setTitle(values.getFilePath());
			values.setUpdated(false);
		}
		editorTextArea.requestFocus();
	}

	public void dontSave() {
		saveRequestStage.close();
	}

	public void cancel() {
		values.setCanceled(true);;
		saveRequestStage.close();
	}

}
