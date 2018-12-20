package eg.edu.alexu.csd.oop.cs51.objects;

import eg.edu.alexu.csd.oop.cs51.objects.states.CollectState;
import eg.edu.alexu.csd.oop.cs51.objects.states.State;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;
import eg.edu.alexu.csd.oop.cs51.observer.Observer;

public abstract class Movable extends AbstractObject implements Observer{
    private static final int OBJECT_WIDTH = 80;
    private static final int OBJECT_HEIGHT = 65;
    private String name;
    private State state;

	public Movable(String path, String name, Collision collision) {
		super(OBJECT_WIDTH, OBJECT_HEIGHT, path, false, name);
		collision.addObserver(this);
		this.name = name;
	}

	public Movable(Movable movable) {
		super(movable);
		this.name = new String(movable.name);
		this.state = movable.state.clone();
	}

	public void setCollision(Collision collision) {
		collision.addObserver(this);
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public int getWidth() {
		return OBJECT_WIDTH;
	}

	public int getHeight() {
		return OBJECT_HEIGHT;
	}

	@Override
	public void setY(int y) {
		if (state == null || !state.getClass().isAssignableFrom(CollectState.class)) {
			super.setY(y);
		}
	}
	
}
