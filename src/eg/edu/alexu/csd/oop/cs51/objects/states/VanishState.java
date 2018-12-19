package eg.edu.alexu.csd.oop.cs51.objects.states;

import eg.edu.alexu.csd.oop.cs51.flyweight.FlyweightFactory;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;

public class VanishState implements State {
	private FlyweightFactory flyweight=new FlyweightFactory();

	public VanishState(VanishState vanishState) {
	}
	public VanishState() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void doAction(Movable movable) {
		movable.setState(this);
		movable.setVisible(false);
		if(Skill.class.isAssignableFrom(movable.getClass())) {
			flyweight.addVanishedSkill(movable);
		}
		else {
			flyweight.addVanishedGift(movable);
		}
		
	}
public State clone() {
	return new VanishState(this);
}
}
