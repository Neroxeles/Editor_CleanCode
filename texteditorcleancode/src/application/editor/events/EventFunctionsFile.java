package application.editor.events;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import application.Program;
import application.controller.Values;
import application.editor.EditorTextArea;
import javafx.application.Platform;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class EventFunctionsFile {

	public void setNeeds(Values values, EditorTextArea editorTextArea, Stage saveRequestStage, Stage primaryStage,
			Stage fontStage, Stage infoStage, Stage searchReplaceStage) {
		this.values = values;
		this.editorTextArea = editorTextArea;
		this.saveRequestStage = saveRequestStage;
		this.primaryStage = primaryStage;
		this.fontStage = fontStage;
		this.infoStage = infoStage;
		this.searchReplaceStage = searchReplaceStage;
	}

	private Values values;
	private EditorTextArea editorTextArea;
	private Stage saveRequestStage;
	private Stage primaryStage;
	private Stage fontStage;
	private Stage infoStage;
	private Stage searchReplaceStage;

	/*****************************************************
	 * Methode - newFile
	 *****************************************************/
	public void newFile() {
		if (values.isUpdated()) {
			saveRequestStage.showAndWait();
		}

		if (!values.isCanceled()) { // TODO
			editorTextArea.setText("");
			values.setUpdated(false);
			values.setFilePath("Unknown");
			primaryStage.setTitle(values.getFilePath());
		}
		values.setCanceled(false);

		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methode - launchAnotherApplication
	 *****************************************************/
	public void launchAnotherApplication() {
		Platform.runLater(new Runnable() {
			public void run() {
				try {
					new Program().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*****************************************************
	 * Methode - openFile
	 *****************************************************/
	public void openFile() {
		if (values.isUpdated()) {
			saveRequestStage.showAndWait();
		}

		if (!values.isCanceled()) {
			try {
				functionOpen();
			} catch (IOException e) {

			}
		}
		values.setCanceled(false);

		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methode - DragOver
	 *****************************************************/
	public void dragOver(DragEvent e) {
		if (e.getGestureSource() != editorTextArea.getTextArea() && e.getDragboard().hasFiles()) {
			// allow for both copying and moving, whatever user chooses
			e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		}
		e.consume();
	}

	/*****************************************************
	 * Methode - DragDropped
	 *****************************************************/
	public void dragDropped(DragEvent e) {
		Dragboard db = e.getDragboard();
		boolean success = false;

		if (db.getFiles().get(0).toString().endsWith(".txt")) {
			try {
				openFileViaDragnDrop(db.getFiles().get(0).toString(), primaryStage);
			} catch (IOException e1) {
			}
			success = true;
		}

		// let the source know whether the string was successfully transferred and used
		e.setDropCompleted(success);
		e.consume();
	}

	/*****************************************************
	 * Methode - openFileViaDragnDrop
	 *****************************************************/
	public void openFileViaDragnDrop(String filePath, Stage primaryStage) throws IOException {

		// File
		File file = new File(filePath);

		if (values.isUpdated()) {
			saveRequestStage.showAndWait();
		}

		if (!values.isCanceled()) {
			// Auslesen der Datei und ins Textfeld schreiben
			if (file != null) {
				InputStream in = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				StringBuilder out = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					out.append(line + "\n");
				}
				editorTextArea.setText(out.toString());
				reader.close();
				values.setFilePath(file.getPath());
				values.setUpdated(false);
				primaryStage.setTitle(values.getFilePath());
			}
		}
		values.setCanceled(false);

		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Funktion für openFile
	 *****************************************************/
	private void functionOpen() throws IOException {

		// FileChooser
		FileChooser fileChooser = new FileChooser();
		// File
		File file;

		fileChooser.setTitle("Öffne Datei");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));

		// Prüfe auf vorhandenen Dateipfad
		if (values.getFilePath() != "Unknown") {
			file = new File(values.getFilePath());
			fileChooser.setInitialDirectory(file.getParentFile());
		}

		file = fileChooser.showOpenDialog(primaryStage);

		// Auslesen der Datei und ins Textfeld schreiben
		if (file != null) {
			InputStream in = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line + "\n");
			}
			editorTextArea.setText(out.toString());
			reader.close();

			values.setFilePath(file.getPath());
			primaryStage.setTitle(values.getFilePath());
			values.setUpdated(false);
		}
	}

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
	}

	/*****************************************************
	 * Methode - saveFileUnder
	 *****************************************************/
	public void saveFileUnder() {
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
		file = fileChooser.showSaveDialog(primaryStage);

		functionSave(file);
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Funktion für openFile
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

	/*****************************************************
	 * Methode - close
	 *****************************************************/
	public void closeProperly() {
		if (values.isUpdated()) {
			saveRequestStage.showAndWait();
		}
		if (!values.isCanceled()) {
			primaryStage.close();
			fontStage.close();
			infoStage.close();
			searchReplaceStage.close();
		} else {
			values.setCanceled(false);
		}
	}
}
