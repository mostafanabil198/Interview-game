package eg.edu.alexu.csd.oop.cs51.menu;

import java.io.IOException;

import eg.edu.alexu.csd.oop.cs51.menu.control.Control;
import eg.edu.alexu.csd.oop.cs51.menu.control.LevelsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainMenu extends Application {

	@Override
	public void start(Stage primaryStage) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("view/MainMenu.fxml"));
		BorderPane borderPane = null;
		primaryStage.setOnCloseRequest((WindowEvent event1) -> {
			System.exit(0);
		});
		Control c = new Control(primaryStage);
		fxmlLoader.setController(c);
		try {
			borderPane = fxmlLoader.load();
			Scene s = new Scene(borderPane);
			primaryStage.setScene(s);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
