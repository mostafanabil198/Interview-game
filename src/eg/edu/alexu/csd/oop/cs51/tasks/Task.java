package eg.edu.alexu.csd.oop.cs51.tasks;

import java.awt.Color;

public class Task {
	
	private String skill1;
	private String skill2;
	private String skill3;
	private Color  skillsColor;
	private String companyName;
	
	public Task (String skill1, String skill2,String skill3,String companyName,Color skillsColor) {
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.companyName = companyName;
		this.skillsColor = skillsColor;	
	}

	public String getSkill1() {
		return skill1;
	}

	public String getSkill2() {
		return skill2;
	}

	public String getSkill3() {
		return skill3;
	}

	public Color getSkillsColor() {
		return skillsColor;
	}

	public String getCompanyName() {
		return companyName;
	}

}
