package application.saverequest;

import application.controller.Values;
import application.editor.EditorTextArea;
import application.saverequest.events.EventFunctionsSaveRequest;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SaveRequestElements {
	
	public SaveRequestElements(Values values, EditorTextArea editorTextArea, Stage primaryStage,
			Stage saveRequestStage) {
		this.values = values;
		this.editorTextArea = editorTextArea;
		this.primaryStage = primaryStage;
		this.saveRequestStage = saveRequestStage;
		initButtons();
	}

	Values values;
	EditorTextArea editorTextArea;
	Stage primaryStage;
	Stage saveRequestStage;
	EventFunctionsSaveRequest eventFunctionsSaveRequest = new EventFunctionsSaveRequest(values, editorTextArea, primaryStage, saveRequestStage);
	
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
