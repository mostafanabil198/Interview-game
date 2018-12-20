package eg.edu.alexu.csd.oop.cs51.menu.control;

import java.io.IOException;

import eg.edu.alexu.csd.oop.cs51.menu.MainMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Control {
	
	@FXML
	private Button newgame;
	
	@FXML
	private Button usermanual;
	
	@FXML
	private CheckBox sound;
	
	private Stage stage;
	public Control(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	public void chooseLevels(ActionEvent event)
	{
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(MainMenu.class.getResource("view/Levels.fxml"));
		fxmlLoader.setController(new LevelsController());
		try {
			BorderPane borderPane = (BorderPane)fxmlLoader.load();
			Scene scene = new Scene(borderPane);
			stage.setScene(scene);
//			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
