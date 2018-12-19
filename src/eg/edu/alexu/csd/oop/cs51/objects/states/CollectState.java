package eg.edu.alexu.csd.oop.cs51.objects.states;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class CollectState implements State {
    private GameInfo gameInfo = GameInfo.getInstance();
    private String position;

    public CollectState(String position) {
        this.position = position;
    }

    public CollectState(CollectState collectState) {
        this.position = new String(collectState.position);
    }

    @Override
    public void doAction(Movable movable) {
        movable.setState(this);

        if (position.equals("right")) {
            gameInfo.addToRightStack(movable);
        } else if (position.equals("left")) {
            gameInfo.addToLeftStack(movable);
        }

    }

    public State clone() {
        return new CollectState(this);
    }
}
