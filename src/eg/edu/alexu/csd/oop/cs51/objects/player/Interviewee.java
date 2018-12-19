package eg.edu.alexu.csd.oop.cs51.objects.player;

import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;

public class Interviewee extends AbstractObject{
    private static final String PATH = "res/interviewee.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
	private static final int HINDWIDTH = 25;
	public Interviewee() {
	    super(WIDTH, HEIGHT, PATH, true, "");
	}
	
	public int getHandWidth() {
		return HINDWIDTH;
	}
	public int getLeftHandPosition() {
		return getX();
	}
	public int getRightHandPosition() {
		return getX()+getWidth();
	}
	////////////////////////////////////////////////////will be optimized later
	public int getHandHeightPosition() {
		return getHeight();
	}
	
	
	
	

}
