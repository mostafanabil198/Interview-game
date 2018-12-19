package eg.edu.alexu.csd.oop.cs51.objects.player;

import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;

public class Interviewee extends AbstractObject{
	private int handWidth;
	public Interviewee(int width, int height, String imagePath, boolean visible) {
	    super(width, height, imagePath, visible, "");
		// TODO Auto-generated constructor stub
		////////////////////////////////////////////////////will be optimized later
		handWidth=80;
	}
	
	public int getHandWidth() {
		return handWidth;
	}
	public int getLeftHandPosition() {
		return getX();
	}
	public int getRightHandPosition() {
		return getX()+getWidth();
	}
	////////////////////////////////////////////////////will be optimized later
	public int getHandHeightPosition() {
		return getY()+158;
	}
	
	
	
	

}
