package eg.edu.alexu.csd.oop.cs51.objects.gifts;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.states.MovingState;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;

public class EmptyStack extends Movable{

    private static final String PATH = "res/bomb.png";
    
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
            GameInfo.getInstance().vanishLeftStack();
            new VanishState().doAction(this);
        } else if (spot.equals("rightStack")) {
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
