package eg.edu.alexu.csd.oop.cs51.objects.states;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.flyweight.FlyweightFactory;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.observer.Observer;

public class VanishState implements State {

	public VanishState(VanishState vanishState) {
	}

	public VanishState() {
	}

	@Override
	public void doAction(Movable movable) {
		movable.setState(this);
		movable.setVisible(false);
		GameInfo.getInstance().getCollision().removeObserver((Observer) movable);
		if (Skill.class.isAssignableFrom(movable.getClass())) {
			GameInfo.getInstance().getMoving().remove(movable);
			FlyweightFactory.addVanishedSkill(movable);
		} else {
			FlyweightFactory.addVanishedGift(movable);
		}
	}

	public State clone() {
		return new VanishState(this);
	}
}
