package eg.edu.alexu.csd.oop.cs51.objects.gifts;

import java.io.IOException;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.logger.Logger;
import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.states.MovingState;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;

public class EmptyStack extends Movable{

    private static final String PATH = "res/gift.png";
    
    public EmptyStack() {
        super(PATH, "");
        System.out.println("stack");
    }
    public EmptyStack(EmptyStack emptyStack) {
        super(emptyStack);
    }
    
    @Override
    public void update(String spot) {
        if(spot.equals("vanish")) {
            new VanishState().doAction(this);
        } else if (spot.equals("leftStack")) {
        	try {
				Logger.getInstance().info("bumb gift was collected");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
			}
            GameInfo.getInstance().vanishLeftStack();
            new VanishState().doAction(this);
        } else if (spot.equals("rightStack")) {
        	try {
				Logger.getInstance().info("bumb gift was collected");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
			}
            GameInfo.getInstance().vanishRightStack();
            new VanishState().doAction(this);
        } else {
            MovingState state = (MovingState) getState();
            state.updatePosition(this);
        }
        
    }

    @Override
    public Movable clone() {
        return new EmptyStack(this);
    }


}
