package application.info;

import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class Info {

	public Info(InfoElements infoElements, Stage infoStage) {
		this.infoElements = infoElements;
		this.infoStage = infoStage;
		initScene();
		initStage();
	}

	// Elemente der Scene
	private InfoElements infoElements;

	// Aufbau der Scene
	private Accordion mainAccordion = new Accordion();
	private TitledPane titlePaneSave = new TitledPane();
	private TitledPane titlePaneEdit = new TitledPane();
	private TitledPane titlePaneShortcuts = new TitledPane();
	private TitledPane titlePaneFormat = new TitledPane();
	private TitledPane titlePaneSearchReplace = new TitledPane();
	private TitledPane titlePaneStatus = new TitledPane();
	private TitledPane titlePaneAbout = new TitledPane();

	// Scene
	private Scene scene = new Scene(mainAccordion);
	// Stage
	private Stage infoStage;

	private void initScene() {

		titlePaneSave.setText("Speichern");
		titlePaneSave.setContent(infoElements.getLabelSave());

		titlePaneEdit.setText("Bearbeiten");
		titlePaneEdit.setContent(infoElements.getLabelEdit());

		titlePaneShortcuts.setText("Shortcuts");
		titlePaneShortcuts.setContent(infoElements.getLabelShortcuts());

		titlePaneFormat.setText("Format");
		titlePaneFormat.setContent(infoElements.getLabelFormat());

		titlePaneSearchReplace.setText("Suchen und Ersetzen");
		titlePaneSearchReplace.setContent(infoElements.getLabelSearchReplace());

		titlePaneStatus.setText("Statusleiste");
		titlePaneStatus.setContent(infoElements.getLabelStatus());

		titlePaneAbout.setText("Über...");
		titlePaneAbout.setContent(infoElements.getLabelAbout());

		// Zuordnung der Reinfolge
		mainAccordion.getPanes().addAll(titlePaneSave, titlePaneEdit, titlePaneShortcuts, titlePaneFormat,
				titlePaneSearchReplace, titlePaneStatus, titlePaneAbout);
	}

	private void initStage() {

		// Titel des Fensters
		infoStage.setTitle("Informationen");
		// Scene der Stage
		infoStage.setScene(scene);
		// Mindestgröße
		infoStage.setMinHeight(300);
		infoStage.setMinWidth(430);
	}
}
