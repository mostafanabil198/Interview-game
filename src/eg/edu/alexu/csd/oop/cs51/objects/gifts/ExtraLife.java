package eg.edu.alexu.csd.oop.cs51.objects.gifts;

import java.awt.Color;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;

public class ExtraLife extends Movable {

    private static final String PATH = "res/cvSkill.jpg";
    
    public ExtraLife(Collision collision) {
        super(PATH, "ExtraLife", Color.BLACK, collision);
    }
    
    @Override
    public void update(String spot) {
        if(spot.equals("vanish")) {
            new VanishState().doAction(this);
        } else if (spot.equals("leftStack")) {
            //execute extra life
            new VanishState().doAction(this);
        } else if (spot.equals("rightStack")) {
            //execute extra life
            new VanishState().doAction(this);
        }
        
    }

}
