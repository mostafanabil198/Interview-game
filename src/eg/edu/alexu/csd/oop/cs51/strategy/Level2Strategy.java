package eg.edu.alexu.csd.oop.cs51.strategy;

import java.util.List;
import java.util.Random;

import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import javafx.concurrent.Task;

public class Level2Strategy implements Strategy{
private List<Class<? extends Skill>> supported;
private Task task;
private Random random;
private List skills;
private static final int fireRate = 3;
private static final String backgroundImage="";

	@Override
	public Map<String,Object> doOperation() {
		for(int i=0;i<3;i++) {
			
			
		}
		return 0;
	}

}
