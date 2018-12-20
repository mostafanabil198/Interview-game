package eg.edu.alexu.csd.oop.cs51.strategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;

public class Level1Strategy implements Strategy {
	private List<Class<? extends Movable>> supported;
	private List<String> allSkills;
	private static final int FIRE_RATE = 75;
	private static final boolean OPAQUE = false;
	private static final int REFRESH_SPEED = 10;
	private static final int CONTROL_SPEED = 30;

	@Override
	public Map<String, Object> doOperation() {
		allSkills = GameInfo.getInstance().getAllSkills();
		supported = GameInfo.getInstance().getCompanyFactory().getSupportedCompanies();
		Collections.shuffle(supported);
		for (int i = 0; i < 3; i++) {
			Collections.shuffle(allSkills);
			GameInfo.getInstance().addTask(
					new Task(allSkills.get(0), allSkills.get(1), allSkills.get(2), supported.get(i).getSimpleName()));
		}

		Map<String, Object> map = new HashMap<>();
		map.put("fireRate", FIRE_RATE);
		map.put("opaque", OPAQUE);
		map.put("refreshSpeed", REFRESH_SPEED);
		map.put("controlSpeed", CONTROL_SPEED);
		return map;
	}

}
