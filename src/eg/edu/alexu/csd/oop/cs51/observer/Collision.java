package eg.edu.alexu.csd.oop.cs51.observer;

import java.util.ArrayList;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class Collision {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private static final int GroundY = 10;
    private GameInfo gameInfo = GameInfo.getInstance();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        int leftX = gameInfo.getLeftHand();
        int rightX = gameInfo.getRightHand();
        int leftY = gameInfo.getLeftStackHeight();
        int rightY = gameInfo.getRightStackHeight();
        int handWidth = gameInfo.getPlayerHandWidth();
        for (Observer observer : observers) {
            Movable movable = ((Movable) observer);
            if (movable.getY() == GroundY) {
                movable.update("vanish");
            } else if (movable.getX() >= leftX
                    && movable.getX() <= Math.abs(leftX + handWidth)) {
                if (movable.getY() == leftY) {
                    movable.update("left");
                }
            } else if (movable.getX() <= rightX
                    && movable.getX() >= Math.abs(rightX - handWidth)) {
                if (movable.getY() == rightY) {
                    movable.update("right");
                }
            }

        } // iterator
    }
}
