package eg.edu.alexu.csd.oop.cs51.objects.states;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class CollectState implements State {
    private GameInfo gameInfo;
    private String position;

    public CollectState(String position) {
        gameInfo = GameInfo.getInstance();
        this.position = position;
    }

    public CollectState(CollectState collectState) {
        gameInfo = GameInfo.getInstance();
        this.position = new String(collectState.position);
    }

    @Override
    public void doAction(Movable movable) {
        movable.setState(this);

        if (position.equals("right")) {
            gameInfo.getControl().add(movable);
            gameInfo.getMoving().remove(movable);
            gameInfo.addToRightStack(movable);
        } else if (position.equals("left")) {
            gameInfo.getControl().add(movable);
            gameInfo.getMoving().remove(movable);
            gameInfo.addToLeftStack(movable);
        }

    }

    public State clone() {
        return new CollectState(this);
    }
}
