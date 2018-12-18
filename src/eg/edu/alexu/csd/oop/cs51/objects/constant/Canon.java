package eg.edu.alexu.csd.oop.cs51.objects.constant;

import java.util.ArrayList;
import java.util.Random;

import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.states.MovingState;
import eg.edu.alexu.csd.oop.cs51.objects.states.State;
import javafx.util.Pair;

public class Canon extends AbstractObject {
	private ArrayList<String> objects;
    private Random random=new Random();
    private Movable movableObject;
    private String canonType;
	public Canon(int width, int height, String imagePath, boolean visible,ArrayList<String> objects,String type) {
		super(width, height, imagePath, visible, "");
		this.objects=objects;
		this.canonType=type;
	}
	public void createObject() {
		int index=random.nextInt(objects.size());
		String object=objects.get(index);
		
	}
	//ab3t el string l tarek
	//law tarek rg3 null ab3t l object l nashar
	public void setmovableObject() {
		Pair topLeft=new Pair(0,0);
		Pair topRight=new Pair(100,0);
		int x=0,y=0;
		MovingState state=new MovingState();
		state.doAction(movableObject);
		if(canonType.equals("left")) {
			x=(int) topLeft.getKey();
			y=(int) topLeft.getValue();
			state.setVelocityX(random.nextInt(5)+1);
			state.setVelocityY(0);
		}
		if(canonType.equals("right")) {
			x=(int) topRight.getKey();
			y=(int) topRight.getValue();
			state.setVelocityX((random.nextInt(5)+1)*-1);
			state.setVelocityY(0);
		}
		movableObject.setX(x);
		movableObject.setY(y);
		state.doAction(movableObject);
	
	}
}
