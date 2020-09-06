package application.font;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Font {

	public Font(FontElements fontElements, Stage fontStage) {
		this.fontElements = fontElements;
		this.fontStage = fontStage;
		initScene();
		initStage();
	}

	// Elemente der Scene
	FontElements fontElements;
	
	// Aufbau der Scene
	HBox mainHBox = new HBox();
	VBox vBox_FontFamily = new VBox();
	VBox vBox_FontSize = new VBox();
	
	// Scene
	Scene scene = new Scene(mainHBox);
	// Stage
	Stage fontStage;
	
	private void initScene() {
		vBox_FontFamily.getChildren().addAll(fontElements.getLabelFontFamily(), fontElements.getListViewFontFamily());
		vBox_FontSize.getChildren().addAll(fontElements.getLabelFontSize(), fontElements.getListViewFontSize());
		mainHBox.getChildren().addAll(vBox_FontFamily, vBox_FontSize);
	}
	
	private void initStage() {
		// Titel des Fensters
		fontStage.setTitle("Ändern der Schriftart/-größe");
		// Scene der Stage
		fontStage.setScene(scene);
		fontStage.setResizable(false);
		// Sichtbarkeit der Stage TODO remove later
		fontStage.show();
	}
}
