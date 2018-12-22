package eg.edu.alexu.csd.oop.cs51.tasks;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.constant.TaskObject;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;

public class Task {

	private List<String> skills;
	private String companyName;
	private TaskObject object;

	public Task(String skill1, String skill2, String skill3, String companyName) {
		skills = new ArrayList<String>();
		skills.add(skill1);
		skills.add(skill2);
		skills.add(skill3);
		this.companyName = companyName;
		object = new TaskObject(this);
	}

	public boolean checkAchived(Movable one, Movable two, Movable three) {
		if (one.getClass().getSimpleName().equals(companyName)) {
			if (skills.contains(one.getName()) && skills.contains(two.getName()) && skills.contains(three.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public String getCompanyName() {
	    return companyName;
	}
	
	public List<String> getSkills(){
	    return skills;
	}
	
	public TaskObject getTaskObject() {
	    return object;
	}
	
	public void markAsDone() {
	    object.markAsDone();
	}

}
