package application.font;

import application.controller.Values;
import application.font.events.EventFunctionsFont;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class FontElements {

	public FontElements(Values values, EventFunctionsFont eventFunctionsFont) {
		this.values = values;
		this.eventFunctionsFont = eventFunctionsFont;
		initListViews();
		initListViewFontFamilyListener();
		initListViewFontSizeListener();
	}

	// Values für Schriftart
	Values values;
	EventFunctionsFont eventFunctionsFont;

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

	private void initListViewFontFamilyListener() {
		// Listener
		listViewFontFamily.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				values.setFontFamily(newValue);
				eventFunctionsFont.setFont(values.getFontFamily(), values.getFontSize());
			}
		});
	}

	private void initListViewFontSizeListener() {
		// Listener
		listViewFontSize.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				values.setFontSize(newValue);
				eventFunctionsFont.setFont(values.getFontFamily(), values.getFontSize());
			}
		});
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
