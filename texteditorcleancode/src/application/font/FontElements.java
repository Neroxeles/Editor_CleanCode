package application.font;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class FontElements {

	public FontElements() {
		initListViews();
	}
	
	// Labels
	private Label labelFontFamily = new Label("Schriftart");
	private Label labelFontSize = new Label("Schriftgröße");
	// ListViews
	private ListView<String> listViewFontFamily = new ListView<String>();
	private ListView<Integer> listViewFontSize = new ListView<Integer>();

	private void initListViews() {

		listViewFontFamily.getItems().addAll("Arial", "Agency FB", "Algerian", "Times New Roman", "Wide Latin",
				"SansSerif");
		listViewFontSize.getItems().addAll(10, 20, 30, 40, 50, 60, 70);
	}
	
	public Label getLabelFontFamily() {
		return labelFontFamily;
	}
	public Label getLabelFontSize() {
		return labelFontSize;
	}
	public ListView<String> getListViewFontFamily() {
		return listViewFontFamily;
	}
	public ListView<Integer> getListViewFontSize() {
		return listViewFontSize;
	}
}
