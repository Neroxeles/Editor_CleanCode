package application.saverequest;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
		saveRequestElements.getLabel().setPadding(new Insets(10));
		saveRequestElements.getLabel().setAlignment(Pos.CENTER);;
		saveRequestElements.getLabel().setFont(Font.font(15.0));
		hBox.getChildren().addAll(saveRequestElements.getButtonSave(), saveRequestElements.getButtonDontSave(),
				saveRequestElements.getButtonCancel());
		hBox.setPadding(new Insets(5));
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(15);
		hBox.setBackground(new Background(new BackgroundFill(Color.web("e9e9e9"), CornerRadii.EMPTY, Insets.EMPTY)));;;
		mainVBox.getChildren().addAll(saveRequestElements.getLabel(), hBox);
	}

	private void initStage() {
		// Titel des Fensters
		saveRequestStage.setTitle("Soll gespeichert werden?");
		// Scene der Stage
		saveRequestStage.setScene(scene);
		saveRequestStage.setResizable(false);
		saveRequestStage.setAlwaysOnTop(true);
		saveRequestStage.initModality(Modality.APPLICATION_MODAL);
	}
}
