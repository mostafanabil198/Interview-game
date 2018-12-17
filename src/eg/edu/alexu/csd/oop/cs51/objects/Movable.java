package eg.edu.alexu.csd.oop.cs51.objects;

import java.awt.Color;

import eg.edu.alexu.csd.oop.cs51.objects.states.State;

public abstract class Movable extends AbstractObject{
    private String name;
    private Color color;
    private State state;
    
    
    public Movable(String path, String name, Color color) {
        
    }
    
    public void setState(State state) {
        this.state = state;
    }
}
