package application.editor.events;

import java.util.Calendar;

import application.editor.EditorTextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

public class EventFunctionsEdit {

	public void setNeeds(EditorTextArea editorTextArea, Stage searchReplaceStage) {
		this.editorTextArea = editorTextArea;
		this.searchReplaceStage = searchReplaceStage;
	}
	
	private EditorTextArea editorTextArea;
	Stage searchReplaceStage;

	private Clipboard clipboard = Clipboard.getSystemClipboard();
	private ClipboardContent clipboardContent = new ClipboardContent();

	/*****************************************************
	 * Methoden - Ausschneiden
	 *****************************************************/
	public void cutOutSelectedText() {
		// markierten Text speichern
		clipboardContent.putString(editorTextArea.getSelectedText());
		clipboard.setContent(clipboardContent);

		editorTextArea.replaceSelection("");
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methode - Kopieren
	 *****************************************************/
	public void copySelectedText() {
		clipboardContent.putString(editorTextArea.getSelectedText());
		clipboard.setContent(clipboardContent);
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methode - Einfügen
	 *****************************************************/
	public void paste() {
		if (clipboard.hasString()) {
			editorTextArea.insertText(editorTextArea.getCaretPosition(), clipboard.getString());
		}
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methoden - Löschen
	 *****************************************************/
	public void deleteSelectedText() {

		editorTextArea.replaceSelection("");
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methoden - SearchRequest
	 *****************************************************/
	public void searchReplace() {
		// Wenn Stage erstellt ist, aber im Modus hide() verweilt,
		// dann setze die Stage in den Modus Show
		if (searchReplaceStage.isShowing() == false) {
			searchReplaceStage.show();
		}
		// Falls das Fenster Minimiert ist, zeige das Fenster
		searchReplaceStage.setIconified(false);
		editorTextArea.requestFocus();
	}

	/*****************************************************
	 * Methoden - Alles Markieren
	 *****************************************************/
	public void selectAll() {
		editorTextArea.selectAll();
	}

	/*****************************************************
	 * Methode - Zeitstempel
	 *****************************************************/
	public void timestamp() {
		Calendar calender = Calendar.getInstance();

		// hh:mm:ss
		editorTextArea.appendText("\n" + calender.get(Calendar.HOUR_OF_DAY) + ":" + (calender.get(Calendar.MINUTE))
				+ ":" + calender.get(Calendar.SECOND)
				// dd.mm.yyyy
				+ "\n" + calender.get(Calendar.DAY_OF_MONTH) + "." + (calender.get(Calendar.MONTH) + 1) + "."
				+ calender.get(Calendar.YEAR));
	}
}
