package eg.edu.alexu.csd.oop.cs51.objects.player;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;

public class Interviewee extends AbstractObject {

	private static final String PATH = "res/interviewee.png";
	private static final int WIDTH = 283;
	private static final int HEIGHT = 244;
	private static final int HANDWIDTH = 80;

	public Interviewee() {
		super(WIDTH, HEIGHT, PATH, true, "");
	}

	public Interviewee(Interviewee interviewee) {
		super(interviewee);
	}

	public int getHandWidth() {
		return HANDWIDTH;
	}

	public int getLeftHandPosition() {
		return getX();
	}

	public int getRightHandPosition() {
		return getX() + getWidth();
	}

	//////////////////////////////////////////////////// will be optimized later
	public int getHandHeightPosition() {
		return getY() + 158;
	}
	
	@Override
	public AbstractObject clone() {
		return new Interviewee(this);
	}
	
	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		super.setY(500);
	}
}
