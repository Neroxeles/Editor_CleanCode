package application.font.events;

import application.editor.EditorTextArea;
import application.editor.EditorToolBar;
import javafx.scene.text.Font;

public class EventFunctionsFont {
	
	public EventFunctionsFont(EditorTextArea editorTextArea, EditorToolBar editorToolBar) {
		this.editorTextArea = editorTextArea;
		this.editorToolBar = editorToolBar;
	}
	
	private EditorTextArea editorTextArea;
	private EditorToolBar editorToolBar;
	
	public void setFont(String family, int size) {
		editorTextArea.setFont(Font.font(family, size));
		
		// Aktiviere bzw Deaktiviere ToolBarButton
		if(size == 10) {
			editorToolBar.buttonItemSmallerFontSetDisabled(true);
		} else if (size == 70) {
			editorToolBar.buttonItemLargerFontSetDisabled(true);
		}
		
		if (size != 10){
			editorToolBar.buttonItemSmallerFontSetDisabled(false);
		}
		if (size != 70){
			editorToolBar.buttonItemLargerFontSetDisabled(false);
		}
	}
}
