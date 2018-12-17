package eg.edu.alexu.csd.oop.cs51.objects.states;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public interface State {
    
    public void doAction(Movable movable);
    public void clone();
}
