package eg.edu.alexu.csd.oop.cs51.objects.states;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.flyweight.FlyweightFactory;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;

public class VanishState implements State {

	public VanishState(VanishState vanishState) {
	}

	public VanishState() {
	}

	@Override
	public void doAction(Movable movable) {
		State prevState = movable.getState();
		movable.setState(this);
		movable.setVisible(false);
		if (CollectState.class.isAssignableFrom(prevState.getClass())) {
			GameInfo.getInstance().getControl().remove(movable);
			FlyweightFactory.addVanishedSkill(movable);
		} else if (MovingState.class.isAssignableFrom(prevState.getClass())) {
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
