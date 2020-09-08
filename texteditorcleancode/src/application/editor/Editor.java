package application.editor;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Editor {

	public Editor(EditorMenuBar editorMenuBar, EditorToolBar editorToolBar, EditorTextArea editorTextArea,
			EditorStatusBar editorStatusBar, Stage primaryStage) {
		this.editorMenuBar = editorMenuBar;
		this.editorToolBar = editorToolBar;
		this.editorTextArea = editorTextArea;
		this.editorStatusBar = editorStatusBar;
		this.primaryStage = primaryStage;
		initScene();
		initStage();
	}

	// Elemente der Scene
	private EditorMenuBar editorMenuBar;
	private EditorToolBar editorToolBar;
	private EditorTextArea editorTextArea;
	private EditorStatusBar editorStatusBar;

	// Aufbau der Scene
	private BorderPane mainBorderPane = new BorderPane();
	private VBox vBox_Center = new VBox();
	private AnchorPane anchor_StatusBar = new AnchorPane();

	// Scene
	private Scene scene = new Scene(mainBorderPane);
	// Stage
	private Stage primaryStage;

	private void initScene() {
		// MenuBar
		mainBorderPane.setTop(editorMenuBar.getMenuBar());

		// ToolBar + TextArea + StatusBar
		anchor_StatusBar.getChildren().add(editorStatusBar.getStatusBar());
		vBox_Center.getChildren().addAll(editorToolBar.getToolBar(), editorTextArea.getTextArea(), anchor_StatusBar);
		mainBorderPane.setCenter(vBox_Center);
		mainBorderPane.setPrefHeight(500);
		scene.getStylesheets().add("MainTheme.css");
	}

	private void initStage() {
		// Titel des Fensters
		primaryStage.setTitle("Unknown");
		// Scene der Stage
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(560);
		primaryStage.setMinHeight(200);
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
			vBox_Center.getChildren().add(vBox_Center.getChildren().size(), editorToolBar.getToolBar());
		} else {
			vBox_Center.getChildren().remove(vBox_Center.getChildren().size()-1);
		}
	}
}
