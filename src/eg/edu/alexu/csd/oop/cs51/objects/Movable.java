package eg.edu.alexu.csd.oop.cs51.objects;

import java.awt.Color;

import eg.edu.alexu.csd.oop.cs51.objects.states.State;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;
import eg.edu.alexu.csd.oop.cs51.observer.Observer;

public abstract class Movable extends AbstractObject implements Observer{
    private static final int OBJECT_WIDTH = 50;
    private static final int OBJECT_HEIGHT = 50;
    private String name;
    private Color color;
    private State state;
    
    
    public Movable(String path, String name, Color color, Collision collision) {
        super(OBJECT_WIDTH, OBJECT_HEIGHT, path, false);
        collision.addObserver(this);
        this.name = name;
        this.color = color;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
//    @Override
//    public void update(String spot) {
//        if(spot.equals("vanishGround")) {
//           // state = ground state
//            setVisible(false);
//        } else if (spot.equals("rightStack")) {
//            
//        } else if (spot.equals(anObject))
//        
//    }
}
