package eg.edu.alexu.csd.oop.cs51.objects.states;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class VanishState implements State {

	public VanishState(VanishState vanishState) {
	}
	public VanishState() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void doAction(Movable movable) {
		movable.setState(this);
		movable.setVisible(false);
	}
public State clone() {
	return new VanishState(this);
}
}
