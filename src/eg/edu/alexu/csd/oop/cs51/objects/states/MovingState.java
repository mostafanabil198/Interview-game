package eg.edu.alexu.csd.oop.cs51.objects.states;

import java.util.Random;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class MovingState implements State {
	private int velocityX;
	private int velocityY;
	private double renderTime;
	private static final int gravity = 2;

	public MovingState() {
		renderTime = (GameInfo.getInstance().getRenderSpeed()) / 10;
	}

	public MovingState(MovingState movingState) {
		renderTime = (GameInfo.getInstance().getRenderSpeed()) / 10;
		this.velocityX = movingState.velocityX;
		this.velocityY = movingState.velocityY;
	}

	@Override
	public void doAction(Movable movable) {
		movable.setState(this);
		GameInfo.getInstance().getMoving().addFirst(movable);
		movable.setCollision(GameInfo.getInstance().getCollision());
	}

	public void updatePosition(Movable movable) {
		int x = movable.getX();
		int y = movable.getY();
		x += velocityX * renderTime;
		if(velocityX < 0) {
			y += (int) ((x-1366)*(x-1366)) / 300000;
		} else {
			y += (int) (x) * (x) / 100000;
		}
		//velocityY += gravity * renderTime;
		movable.setX(x);
		movable.setY(y);
	}

	public State clone() {
		return new MovingState(this);
	}

	public void setVelocityX(int velocity) {
		this.velocityX = velocity;
	}

	public void setVelocityY(int velocity) {
		this.velocityY = velocity;
	}

}
