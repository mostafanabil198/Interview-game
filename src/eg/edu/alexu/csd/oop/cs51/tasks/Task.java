package eg.edu.alexu.csd.oop.cs51.tasks;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;

public class Task {

	private List<String> skills;
	private String companyName;

	public Task(String skill1, String skill2, String skill3, String companyName) {
		skills = new ArrayList<String>();
		skills.add(skill1);
		skills.add(skill2);
		skills.add(skill3);
		this.companyName = companyName;
	}

	public boolean checkAchived(Movable one, Movable two, Movable three) {
		if (one.getClass().getSimpleName().equals(companyName)) {
			if (skills.contains(one.getName()) && skills.contains(two.getName()) && skills.contains(three.getName())) {
				return true;
			}
		}
		new VanishState().doAction(one);
		new VanishState().doAction(two);
		new VanishState().doAction(three);
		return false;
	}

}
