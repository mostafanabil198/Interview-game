package eg.edu.alexu.csd.oop.cs51.objects.skills;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.objects.states.CollectState;
import eg.edu.alexu.csd.oop.cs51.objects.states.MovingState;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;

public class WeSkill extends Movable implements Skill {
	private static final String PATH = "res/WeSkill.png";

	public WeSkill(String name, Collision collision) {
		super(PATH, name, collision);
	}

	public WeSkill(WeSkill weSkill) {
		super(weSkill);
	}

	@Override
	public void update(String spot) {
		if (spot.equals("vanish")) {
			new VanishState().doAction(this);
		} else if (spot.equals("rightStack")) {
			new CollectState("right").doAction(this);
		} else if (spot.equals("leftStack")) {
			new CollectState("left").doAction(this);
		} else {
			if(MovingState.class.isAssignableFrom(getState().getClass())) {
        		MovingState state = (MovingState) getState();
	            state.updatePosition(this);
        	} else if (CollectState.class.isAssignableFrom(getState().getClass())) {
        		CollectState state = (CollectState) getState();
	            state.updatePosition(this);
        	}
		}

	}

	@Override
	public Movable clone() {
		return new WeSkill(this);
	}
}
