package eg.edu.alexu.csd.oop.cs51.strategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;

public class Level2Strategy implements Strategy {
    private List<Class<? extends Movable>> supported;
	private List<String> skills;
	private static final int FIRE_RATE = 3;
	private static final boolean OPAQUE = false;
	private static final int REFRESH_SPEED = 7;
	private static final int CONTROL_SPEED = 10;

	@Override
	public Map<String, Object> doOperation() {
		Map<String, Object> map = new HashMap<>();
		skills = GameInfo.getInstance().getAllSkills();
		supported = GameInfo.getInstance().getCompanyFactory().getSupportedCompanies();
		Collections.shuffle(supported);
		for (int i = 0; i < 4; i++) {
			String companyName = supported.get(i).getSimpleName();
			Collections.shuffle(skills);
			GameInfo.getInstance().addTask(new Task(skills.get(0), skills.get(1), skills.get(2), companyName));
		}
		map.put("fireRate", FIRE_RATE);
		map.put("opaque", OPAQUE);
		map.put("refreshSpeed", REFRESH_SPEED);
		map.put("controlSpeed", CONTROL_SPEED);
		return map;
	}

}
