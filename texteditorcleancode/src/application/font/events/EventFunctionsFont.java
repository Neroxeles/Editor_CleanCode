package application.font.events;

import application.editor.EditorTextArea;
import javafx.scene.text.Font;

public class EventFunctionsFont {
	
	public EventFunctionsFont(EditorTextArea editorTextArea) {
		this.editorTextArea = editorTextArea;
	}
	
	EditorTextArea editorTextArea;
	
	public void setFont(String family, int size) {
		editorTextArea.setFont(Font.font(family, size));
	}
}
