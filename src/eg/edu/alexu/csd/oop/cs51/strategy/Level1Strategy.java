package eg.edu.alexu.csd.oop.cs51.strategy;

import java.util.List;
import java.util.Map;
import java.util.Random;

import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;

public class Level1Strategy implements Strategy {

	private List<Class<? extends Skill>> supported;
	private Task task;
	private Random rand;
	private List skills;

	@Override
	public Map<String, Object> doOperation() {
		

		return null;
	}

}
