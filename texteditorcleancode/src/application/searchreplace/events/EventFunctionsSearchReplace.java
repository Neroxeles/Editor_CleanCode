package application.searchreplace.events;

import application.editor.EditorTextArea;
import javafx.scene.control.Label;

public class EventFunctionsSearchReplace {

	public EventFunctionsSearchReplace(EditorTextArea editorTextArea) {
		this.editorTextArea = editorTextArea;
	}

	EditorTextArea editorTextArea;

	public void search(String substring, Label infoMessage) {
		if (editorTextArea.selectSubstringFrom(substring)) {
			infoMessage.setText("gesuchtes Wort gefunden");
		} else {
			infoMessage.setText("Kein Treffer");
		}
	}

	public void previousElement(String substring, Label infoMessage) {
		if (editorTextArea.selectLastSubstringFrom(substring)) {
			infoMessage.setText("Vorheriges Wort");
		} else {
			infoMessage.setText("Kein Treffer");
		}
	}

	public void nextElement(String substring, Label infoMessage) {
		if (editorTextArea.selectSubstringFrom(substring)) {
			infoMessage.setText("Nächstes Wort");
		} else {
			infoMessage.setText("Kein Treffer");
		}
	}

	public void replace(String substring, String replacement, Label infoMessage) {
		if (editorTextArea.getSelectedText().equals(substring)) {
			editorTextArea.replaceSelection(replacement);
			infoMessage.setText("Wort wurde ersetzt");
		} else {
			search(substring, infoMessage);
		}
	}

	public void replaceAll(String substring, String replacement, Label infoMessage) {
		int i = 0;
		while (editorTextArea.selectSubstringFrom(substring)) {
			editorTextArea.replaceSelection(replacement);
			i++;
		}
		if (i > 0) {
			infoMessage.setText("Es wurde(n) " + i + " Wort(e) ersetzt");
		} else {
			infoMessage.setText("Kein Treffer");
		}
		
	}

}
