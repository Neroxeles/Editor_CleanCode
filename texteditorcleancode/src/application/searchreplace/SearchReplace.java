package application.searchreplace;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchReplace {

	public SearchReplace(SearchReplaceElements searchReplaceElements, Stage searchReplaceStage) {
		this.searchReplaceElements = searchReplaceElements;
		this.searchReplaceStage = searchReplaceStage;
		initScene();
		initStage();
	}

	// Elemente der Scene
	SearchReplaceElements searchReplaceElements;

	// Aufbau der Scene
	VBox mainVBox = new VBox(8);
	HBox hBox_SearchFor = new HBox();
	HBox hBox_ReplaceWith = new HBox();
	HBox hBox_CheckBox = new HBox();
	HBox hBox_InfoLabel = new HBox();
	
	// Scene
	Scene scene = new Scene(mainVBox, 400, 165);
	// Stage
	Stage searchReplaceStage;

	private void initScene() {
		
		hBox_SearchFor.getChildren().addAll(searchReplaceElements.getLabelSearchFor(), searchReplaceElements.getTextFieldSearchFor());
		hBox_ReplaceWith.getChildren().addAll(searchReplaceElements.getLabelReplaceWith(), searchReplaceElements.getTextFieldReplaceWith());
		hBox_CheckBox.getChildren().addAll(searchReplaceElements.getCheckBox());
		hBox_InfoLabel.getChildren().addAll(searchReplaceElements.getLabelInfo());
		
		hBox_SearchFor.setAlignment(Pos.CENTER_LEFT);
		hBox_ReplaceWith.setAlignment(Pos.CENTER_LEFT);
		hBox_InfoLabel.setAlignment(Pos.CENTER_LEFT);
		
		mainVBox.setPadding(new Insets(15, 0, 0, 0));
		hBox_CheckBox.setPadding(new Insets(0, 0, 0, 15));
		hBox_InfoLabel.setPadding(new Insets(0, 0, 0, 5));
		
		mainVBox.getChildren().addAll(hBox_SearchFor, hBox_ReplaceWith, hBox_CheckBox, hBox_InfoLabel, searchReplaceElements.getToolBar());
	}

	private void initStage() {
		// Titel des Fensters
		searchReplaceStage.setTitle("Suchen und Ersetzen");
		// Scene der Stage
		searchReplaceStage.setScene(scene);
		searchReplaceStage.setResizable(false);
		// Sichtbarkeit der Stage TODO remove later
		searchReplaceStage.show();
	}
}
