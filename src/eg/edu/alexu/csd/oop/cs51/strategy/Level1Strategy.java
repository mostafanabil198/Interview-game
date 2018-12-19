package eg.edu.alexu.csd.oop.cs51.strategy;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;

public class Level1Strategy implements Strategy {

	private List<Class<? extends Skill>> supported;
	private List<String> allSkills;

	@Override
	public Map<String, Object> doOperation() {
		allSkills = GameInfo.getInstance().getAllSkills();
		for (int i = 0; i < 3; i++) {
			Collections.shuffle(supported);
			Collections.shuffle(allSkills);
			GameInfo.getInstance().addTask(
					new Task(allSkills.get(0), allSkills.get(1), allSkills.get(2), supported.get(0).getSimpleName()));
		}

		Map<String, Object> map = new HashMap<>();
		map.put("fireRate", 5);
		map.put("obaque", false);
		return map;
	}

}
