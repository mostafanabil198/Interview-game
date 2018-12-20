package eg.edu.alexu.csd.oop.cs51;

import eg.edu.alexu.csd.oop.cs51.factory.CompanyFactory;
import eg.edu.alexu.csd.oop.cs51.objects.skills.SkillLoader;
import eg.edu.alexu.csd.oop.cs51.strategy.Level1Strategy;
import eg.edu.alexu.csd.oop.cs51.strategy.Strategy;
import eg.edu.alexu.csd.oop.cs51.world.Interview;
import eg.edu.alexu.csd.oop.game.GameEngine;


public class Main {
	public static void main(String[] args) {
		GameInfo.getInstance();
		SkillLoader skillLoader = new SkillLoader("jars");
		skillLoader.load();
		CompanyFactory companyFactory = new CompanyFactory(skillLoader.getSkills());
		GameInfo.getInstance().setCompanyFactory(companyFactory);
		// MAIN MENU
		// HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
		Strategy strategy = new Level1Strategy();
		Interview world = new Interview(strategy, 10, 10);
		GameEngine game = new GameEngine();
		game.start("Interview Game", world);
	}

}
