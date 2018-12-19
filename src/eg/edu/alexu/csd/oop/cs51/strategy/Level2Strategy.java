package eg.edu.alexu.csd.oop.cs51.strategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;

public class Level2Strategy implements Strategy {
	private List<Class<? extends Skill>> supported;
	private List<String> skills;
	private static final int fireRate = 3;
	private static final boolean obaque = false;

	@Override
	public Map<String, Object> doOperation() {
		Map<String, Object> map = new HashMap<>();
		skills = GameInfo.getInstance().getAllSkills();
		for (int i = 0; i < 4; i++) {
			Collections.shuffle(supported);
			String companyName = supported.get(0).getSimpleName();
			Collections.shuffle(skills);
			GameInfo.getInstance().addTask(new Task(skills.get(0), skills.get(1), skills.get(2), companyName));
		}
		map.put("fireRaate", fireRate);
		map.put("obaque", obaque);
		return map;
	}

}
