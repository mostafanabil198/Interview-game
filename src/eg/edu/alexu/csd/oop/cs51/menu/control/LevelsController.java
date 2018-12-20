package eg.edu.alexu.csd.oop.cs51.menu.control;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.factory.CompanyFactory;
import eg.edu.alexu.csd.oop.cs51.objects.skills.SkillLoader;
import eg.edu.alexu.csd.oop.cs51.strategy.Level1Strategy;
import eg.edu.alexu.csd.oop.cs51.strategy.Level2Strategy;
import eg.edu.alexu.csd.oop.cs51.strategy.Level3Strategy;
import eg.edu.alexu.csd.oop.cs51.strategy.Strategy;
import eg.edu.alexu.csd.oop.cs51.world.Interview;
import eg.edu.alexu.csd.oop.game.GameEngine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LevelsController {
	@FXML
	private Button easyBtn;
	@FXML
	private Button mediumBtn;
	@FXML
	private Button hardBtn;
	@FXML
	private Button impossibleBtn; //update later
	@FXML
	public void initialize() {
		easyBtn.setOnAction((event) -> {
			Strategy strategy=new Level1Strategy();
			startGame(strategy);
		});
		mediumBtn.setOnAction((event) -> {
			Strategy strategy=new Level2Strategy();
			startGame(strategy);
		});
		hardBtn.setOnAction((event) -> {
			Strategy strategy=new Level3Strategy();
			startGame(strategy);
		});
	}
	public void startGame(Strategy strategy) {
		mediumBtn.setOnAction((event) -> {
			GameInfo.getInstance();
			SkillLoader skillLoader = new SkillLoader("jars");
			skillLoader.load();
			CompanyFactory companyFactory = new CompanyFactory(skillLoader.getSkills());
			GameInfo.getInstance().setCompanyFactory(companyFactory);
			//Strategy strategy = new Level1Strategy();
			Interview world = new Interview(strategy, 800, 800);
			GameEngine game = new GameEngine();
			game.start("Interview Game", world);
		});
	}
}
