package application;

import application.controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;


public class Program extends Application {
	
	/*****************************************************
	 * Main
	 *****************************************************/
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Controller controller = new Controller(primaryStage);
		controller.initEditor();
		controller.initSaveRequestStage();
		controller.initFontStage();
		controller.initInfoStage();
		controller.initSearchReplaceStage();
		controller.initBidirectionality();
	}
}