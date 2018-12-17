package eg.edu.alexu.csd.oop.cs51.objects.skills;

import java.awt.Color;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.objects.states.CollectState;
import eg.edu.alexu.csd.oop.cs51.objects.states.MovingState;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;

public class CV extends Movable implements Skill {
    private static final String PATH = "res/cvSkill.jpg";
    
    public CV(Collision collision) {
        super(PATH, "CV", Color.BLACK, collision);
    }
    
    public CV(CV cv) {
        super(cv);
    }
    
    @Override
    public void update(String spot) {
        if(spot.equals("vanish")) {
           new VanishState().doAction(this);
        } else if (spot.equals("rightStack")) {
           new CollectState("right").doAction(this);
        } else if (spot.equals("leftStack")) {
           new CollectState("left").doAction(this);
        } else {
            MovingState state = (MovingState) getState();
            state.updatePosition(this);
         }
        
    }

    @Override
    public Movable clone() {
        return new CV(this);
    }

}
