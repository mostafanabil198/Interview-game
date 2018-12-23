package eg.edu.alexu.csd.oop.cs51.observer;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.iterators.IteratorI;
import eg.edu.alexu.csd.oop.cs51.iterators.LinkedListContainer;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.gifts.EmptyStack;
import eg.edu.alexu.csd.oop.cs51.objects.gifts.ExtraLife;
import eg.edu.alexu.csd.oop.cs51.objects.states.CollectState;
import eg.edu.alexu.csd.oop.cs51.objects.states.State;

public class Collision {
	private static final int GroundY = 650;
	private LinkedListContainer<Observer> list;
	private IteratorI iterator;

	public Collision() {
		list = new LinkedListContainer<Observer>();
	}

	public void addObserver(Observer observer) {
		list.add(observer);
	}

	public void removeObserver(Observer observer) {
		list.remove(observer);
	}

	public void notifyObservers() {
		int leftX = GameInfo.getInstance().getLeftHand();
		int rightX = GameInfo.getInstance().getRightHand();
		int leftY = GameInfo.getInstance().getLeftStackHeight();
		int rightY = GameInfo.getInstance().getRightStackHeight();
		int handWidth = GameInfo.getInstance().getPlayerHandWidth();
		iterator = list.createIterator();
		while (iterator.hasNext()) {
			Observer observer = (Observer) iterator.next();
			Movable movable = ((Movable) observer);
			if(ExtraLife.class.isAssignableFrom(movable.getClass()) || EmptyStack.class.isAssignableFrom(movable.getClass())) {
			    State s = movable.getState();
			}
			if (movable.getState().getClass().equals(CollectState.class)) {
				// list.remove(observer);
				movable.update("noCollision");
				continue;
			}
			if (movable.getY() >= GroundY) {
				movable.update("vanish");
				// System.out.println("d5l l ground");
			} else if (movable.getX() >= leftX && movable.getX() <= Math.abs(leftX + handWidth)
					&& movable.getY() <= leftY && (movable.getY() + movable.getHeight()) >= leftY) {
				GameInfo.getInstance().getPlaySoundEffects().playEffect("collected");
				movable.setY(leftY - movable.getHeight() + 25);
				movable.update("leftStack");
			} else if (movable.getX() <= rightX && movable.getX() >= Math.abs(rightX - handWidth)
					&& movable.getY() <= rightY && (movable.getY() + movable.getHeight()) >= rightY) {
				GameInfo.getInstance().getPlaySoundEffects().playEffect("collected");
				movable.setY(rightY - movable.getHeight() + 25);
				movable.update("rightStack");
			} else {
				movable.update("noCollision");
			}

		}
	}

	public void clear() {
		list.clear();
	}
}
