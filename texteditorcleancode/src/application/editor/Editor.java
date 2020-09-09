package application.editor;

import application.editor.events.EventFunctionsFile;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Editor {

	public Editor(EventFunctionsFile eventFunctionsFile, EditorMenuBar editorMenuBar, EditorToolBar editorToolBar, EditorTextArea editorTextArea,
			EditorStatusBar editorStatusBar, Stage primaryStage) {
		this.eventFunctionsFile = eventFunctionsFile;
		this.editorMenuBar = editorMenuBar;
		this.editorToolBar = editorToolBar;
		this.editorTextArea = editorTextArea;
		this.editorStatusBar = editorStatusBar;
		this.primaryStage = primaryStage;
		initScene();
		initStage();
	}

	// Events
	private EventFunctionsFile eventFunctionsFile;
	
	// Elemente der Scene
	private EditorMenuBar editorMenuBar;
	private EditorToolBar editorToolBar;
	private EditorTextArea editorTextArea;
	private EditorStatusBar editorStatusBar;

	// Aufbau der Scene
	private BorderPane mainBorderPane = new BorderPane();
	private VBox vBox_Center = new VBox();
	private HBox hBox_Status1 = new HBox();
	private HBox hBox_Status2 = new HBox();
	private HBox hBox_Status3 = new HBox();
	private HBox hBox_StatusBar = new HBox();

	// Scene
	private Scene scene = new Scene(mainBorderPane);
	// Stage
	private Stage primaryStage;

	private void initScene() {
		// MenuBar
		mainBorderPane.setTop(editorMenuBar.getMenuBar());

		// Ausrichten der StatusBar Elemente
		hBox_Status1.setPadding(new Insets(0, 5, 0, 5));
		hBox_Status1.setPrefWidth(5000);
		hBox_Status2.setPadding(new Insets(0, 5, 0, 5));
		hBox_Status2.setPrefWidth(5000);
		hBox_Status3.setPadding(new Insets(0, 5, 0, 5));
		hBox_Status3.setPrefWidth(5000);
		
		// StatusBar
		hBox_Status1.getChildren().add(editorStatusBar.getLabelLengthAndLines());
		hBox_Status2.getChildren().addAll(new Separator(Orientation.VERTICAL), editorStatusBar.getLabelCaretPos());
		hBox_Status3.getChildren().addAll(new Separator(Orientation.VERTICAL), editorStatusBar.getLabelDate());
		
		// StatusBar komplett
		hBox_StatusBar.getChildren().addAll(hBox_Status1, hBox_Status2, hBox_Status3);
		
		// ToolBar + TextArea + AnchorPane mit StatusBar
		vBox_Center.getChildren().addAll(editorToolBar.getToolBar(), editorTextArea.getTextArea(), hBox_StatusBar);
		
		mainBorderPane.setCenter(vBox_Center);
		mainBorderPane.setPrefHeight(500);
		mainBorderPane.setPrefWidth(500);
		scene.getStylesheets().add("MainTheme.css");
	}

	private void initStage() {
		// Titel des Fensters
		primaryStage.setTitle("Unknown");
		// Scene der Stage
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(560);
		primaryStage.setMinHeight(200);
		// CloseRequest abfangen
		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			eventFunctionsFile.closeProperly();
		});
		// Sichtbarkeit der primaryStage
		primaryStage.show();
	}

	public void showToolBar(boolean show) {
		if (show) {
			vBox_Center.getChildren().add(0, editorToolBar.getToolBar());
		} else {
			vBox_Center.getChildren().remove(0);
		}
	}

	public void showStatusBar(boolean show) {
		if (show) {
			vBox_Center.getChildren().add(vBox_Center.getChildren().size(), hBox_StatusBar);
		} else {
			vBox_Center.getChildren().remove(vBox_Center.getChildren().size() - 1);
		}
	}
}
