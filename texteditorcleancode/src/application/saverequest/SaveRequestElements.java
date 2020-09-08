package application.saverequest;

import application.saverequest.events.EventFunctionsSaveRequest;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SaveRequestElements {
	
	public SaveRequestElements(EventFunctionsSaveRequest eventFunctionsSaveRequest) {
		this.eventFunctionsSaveRequest = eventFunctionsSaveRequest;
		initButtons();
	}

	EventFunctionsSaveRequest eventFunctionsSaveRequest;
	
	// Label
	private Label label = new Label("Es liegen aktualisierte Datensätze vor.\nWollen Sie diese Speichern?");
	// Buttons
	private Button buttonSave = new Button("Speichern");;
	private Button buttonDontSave = new Button("Nicht speichern");;
	private Button buttonCancel = new Button("Abbrechen");;
	
	private void initButtons() {
		buttonSave.setOnAction(e -> eventFunctionsSaveRequest.saveFile());
		buttonDontSave.setOnAction(e -> eventFunctionsSaveRequest.dontSave());
		buttonCancel.setOnAction(e -> eventFunctionsSaveRequest.cancel());
	}
	
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
