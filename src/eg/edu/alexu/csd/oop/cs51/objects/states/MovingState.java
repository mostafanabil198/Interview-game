package eg.edu.alexu.csd.oop.cs51.objects.states;

import java.util.Random;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class MovingState implements State {
	private int velocityX;
	private int velocityY;
    private GameInfo gameInfo=GameInfo.getInstance();
    private double renderTime=1/(gameInfo.getRenderSpeed());
    private static final double gravity=9.8;
	public MovingState() {
		Random random = new Random();
		velocityY = 0;
        velocityX=random.nextInt(10)+1;
	}

	public MovingState(MovingState movingState) {
		this.velocityX=movingState.velocityX;
		this.velocityY=movingState.velocityY;
	}

	@Override
	public void doAction(Movable movable) {
		movable.setState(this);
	}
	public void updatePosition(Movable movable) {
		int x=movable.getX();
		int y=movable.getY();
		x+=velocityX*renderTime;
		y+=(int) (velocityY*renderTime+0.5*gravity*renderTime*renderTime);
		velocityY+=gravity*renderTime;
		movable.setX(x);
		movable.setY(y);
	}
	public State clone() {
		return new MovingState(this);
	}

}
