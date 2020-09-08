package application.searchreplace;

import application.searchreplace.events.EventFunctionsSearchReplace;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;

public class SearchReplaceElements {

	public SearchReplaceElements(EventFunctionsSearchReplace eventFunctionsSearchReplace) {
		this.eventFunctionsSearchReplace = eventFunctionsSearchReplace;
		initTextFieldSearchFor();
		initTextFieldReplaceWith();
		initToolBarItems();
		initToolBar();
	}
	
	EventFunctionsSearchReplace eventFunctionsSearchReplace;

	// Labels
	Label labelSearchFor = new Label("\tSuche nach\t");
	Label labelReplaceWith = new Label("\tErsetze mit\t");
	Label labelInfo = new Label();

	// textFields
	TextField textFieldSearchFor = new TextField();
	TextField textFieldReplaceWith = new TextField();

	// CheckBox
	CheckBox checkBox = new CheckBox("Groß- / Kleinschreibung nicht beachten");

	// ToolBar
	ToolBar toolBar = new ToolBar();
	// ToolBarButtons
	Button buttonSearch = new Button("Suche");
	Button buttonPrev = new Button("Vorher");
	Button buttonNext = new Button("Nachher");
	Button buttonReplace = new Button("Ersetze");
	Button buttonReplaceAll = new Button("Alles ersetzen");

	private void initTextFieldSearchFor() {
		textFieldSearchFor.setPrefWidth(230);
	}

	private void initTextFieldReplaceWith() {
		textFieldReplaceWith.setPrefWidth(230);
	}
	
	private void initToolBarItems() {
		buttonSearch.setOnAction(e -> eventFunctionsSearchReplace.search(textFieldSearchFor.getText(), labelInfo));
		buttonPrev.setOnAction(e -> eventFunctionsSearchReplace.previousElement(textFieldSearchFor.getText(), labelInfo));
		buttonNext.setOnAction(e -> eventFunctionsSearchReplace.nextElement(textFieldSearchFor.getText(), labelInfo));
		buttonReplace.setOnAction(e -> eventFunctionsSearchReplace.replace(textFieldSearchFor.getText(), textFieldReplaceWith.getText(), labelInfo));
		buttonReplaceAll.setOnAction(e -> eventFunctionsSearchReplace.replaceAll(textFieldSearchFor.getText(), textFieldReplaceWith.getText(), labelInfo));
	}

	private void initToolBar() {

		toolBar.getItems().addAll(buttonSearch, buttonPrev, buttonNext, buttonReplace, buttonReplaceAll);
		toolBar.setPadding(new Insets(5, 0, 5, 40));
	}

	public Label getLabelSearchFor() {
		return labelSearchFor;
	}

	public Label getLabelReplaceWith() {
		return labelReplaceWith;
	}

	public Label getLabelInfo() {
		return labelInfo;
	}

	public TextField getTextFieldSearchFor() {
		return textFieldSearchFor;
	}

	public TextField getTextFieldReplaceWith() {
		return textFieldReplaceWith;
	}

	public CheckBox getCheckBox() {
		return checkBox;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}
}
