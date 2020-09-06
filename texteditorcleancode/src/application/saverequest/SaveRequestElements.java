package application.saverequest;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SaveRequestElements {

	// Label
	private Label label = new Label("Es liegen aktualisierte Datensätze vor.\nWollen sie diese Speichern?");
	// Buttons
	private Button buttonSave = new Button("Speichern");;
	private Button buttonDontSave = new Button("Nicht speichern");;
	private Button buttonCancel = new Button("Abbrechen");;
	
	
	
	
	public Label getLabel() {
		return label;
	}
	public Button getButtonSave() {
		return buttonSave;
	}
	public Button getButtonDontSave() {
		return buttonDontSave;
	}
	public Button getButtonCancel() {
		return buttonCancel;
	}
}
