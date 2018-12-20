package eg.edu.alexu.csd.oop.cs51.objects.states;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class CollectState implements State {
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
            GameInfo.getInstance().getControl().addFirst(movable);
            GameInfo.getInstance().getMoving().remove(movable);
            GameInfo.getInstance().addToRightStack(movable);
        } else if (position.equals("left")) {
            GameInfo.getInstance().getControl().addFirst(movable);
            GameInfo.getInstance().getMoving().remove(movable);
            GameInfo.getInstance().addToLeftStack(movable);
        }

    }

    public State clone() {
        return new CollectState(this);
    }
}
