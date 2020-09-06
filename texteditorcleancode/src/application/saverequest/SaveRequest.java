package application.saverequest;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SaveRequest {

	public SaveRequest(SaveRequestElements saveRequestElements, Stage saveRequestStage) {
		this.saveRequestElements = saveRequestElements;
		this.saveRequestStage = saveRequestStage;
		initScene();
		initStage();
	}

	// Elemente der Scene
	private SaveRequestElements saveRequestElements;

	// Aufbau der Scene
	private VBox mainVBox = new VBox();
	private HBox hBox = new HBox();

	// Scene
	private Scene scene = new Scene(mainVBox);
	// Stage
	private Stage saveRequestStage;

	private void initScene() {
		// Label + Buttons
		hBox.getChildren().addAll(saveRequestElements.getButtonSave(), saveRequestElements.getButtonDontSave(),
				saveRequestElements.getButtonCancel());
		mainVBox.getChildren().addAll(saveRequestElements.getLabel(), hBox);
	}

	private void initStage() {
		// Titel des Fensters
		saveRequestStage.setTitle("Soll gespeichert werden?");
		// Scene der Stage
		saveRequestStage.setScene(scene);
		saveRequestStage.setResizable(false);
		saveRequestStage.initModality(Modality.APPLICATION_MODAL);
		// Sichtbarkeit der Stage TODO remove later
		saveRequestStage.show();
	}
}
