package eg.edu.alexu.csd.oop.cs51.menu.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Control {
	
	@FXML
	private Button newgame;
	
	@FXML
	private Button usermanual;
	
	@FXML
	private CheckBox sound;
	
	private BorderPane borderPane;
	public Control(BorderPane borderPane) {
		this.borderPane = borderPane;
	}
	
	@FXML
	public void chooseLevels(ActionEvent event)
	{
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("view/Levels.fxml"));
		fxmlLoader.setController(new LevelsController());
		borderPane = (BorderPane)fxmlLoader.load();
	}
	
	
	

}
