package eg.edu.alexu.csd.oop.cs51.menu.control;

import java.io.IOException;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.menu.MainMenu;
import eg.edu.alexu.csd.oop.cs51.music.Playmusic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Control {

	private Stage stage;
	private Playmusic music;

	public Control(Stage stage) {
		this.stage = stage;
		music = new Playmusic();
		music.start();
	}

	@FXML
	public Button soundBtn;

	@FXML
	public Button musicBtn;

	@FXML
	public void newGame(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(MainMenu.class.getResource("view/Levels.fxml"));
		fxmlLoader.setController(new LevelsController());
		try {
			BorderPane borderPane = (BorderPane) fxmlLoader.load();
			Scene scene = new Scene(borderPane);
			stage.setScene(scene);
			// stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void howToPlay() {

	}

	@FXML
	public void exit() {
		System.exit(0);
	}

	@FXML
	public void sound() {
		GameInfo.getInstance().setSoundOn(!GameInfo.getInstance().isSoundOn());
		if (GameInfo.getInstance().isSoundOn()) {
			soundBtn.getStyleClass().clear();
			soundBtn.getStyleClass().add("soundOn");
		} else {
			soundBtn.getStyleClass().clear();
			soundBtn.getStyleClass().add("soundOff");
		}
	}

	@FXML
	public void music() {
		GameInfo.getInstance().setMusicOn(!GameInfo.getInstance().isMusicOn());
		if (GameInfo.getInstance().isMusicOn()) {
			musicBtn.getStyleClass().clear();
			musicBtn.getStyleClass().add("musicOn");
			music.start();
		} else {
			musicBtn.getStyleClass().clear();
			musicBtn.getStyleClass().add("musicOff");
			music.stop();
		}
	}

}
