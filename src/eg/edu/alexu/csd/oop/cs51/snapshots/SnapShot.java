package eg.edu.alexu.csd.oop.cs51.snapshots;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.iterators.Collections;
import eg.edu.alexu.csd.oop.cs51.iterators.IteratorI;
import eg.edu.alexu.csd.oop.cs51.iterators.LinkedListContainer;
import eg.edu.alexu.csd.oop.cs51.iterators.StackContainer;
import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.observer.Observer;
import eg.edu.alexu.csd.oop.game.GameObject;

public class SnapShot {
	private int score;
	private Collections<Movable> leftStack, rightStack;
	private int leftColorCounter;
	private int rightColorCounter;
	private int playerPositionX;
	private int playerPositionY;
	private int leftStackHeight;
	private int rightStackHeight;
	private int leftHand;
	private int rightHand;

	private Collections<GameObject> moving;
	private Collections<GameObject> control;

	public SnapShot() {
		leftStack = new StackContainer<>();
		rightStack = new StackContainer<>();
		moving = new LinkedListContainer<>();
		control = new LinkedListContainer<>();
		score = GameInfo.getInstance().getScore();
		fillStacksForSave();
		leftColorCounter = GameInfo.getInstance().getLeftColorCounter();
		rightColorCounter = GameInfo.getInstance().getRightColorCounter();
		playerPositionX = GameInfo.getInstance().getPlayer().getX();
		playerPositionY = GameInfo.getInstance().getPlayer().getY();

		leftStackHeight = GameInfo.getInstance().getLeftStackHeight();
		rightStackHeight = GameInfo.getInstance().getRightStackHeight();
		leftHand = GameInfo.getInstance().getLeftHand();
		rightHand = GameInfo.getInstance().getRightHand();

	}

	private void fillStacksForSave() {
		leftStack.clear();
		rightStack.clear();
		moving.clear();
		control.clear();
		IteratorI iterator = GameInfo.getInstance().getLeftStack().createIterator();
		Movable oldM, newM;
		while (iterator.hasNext()) {
			oldM = (Movable) ((Movable) iterator.next());
			newM = (Movable) oldM.clone();
			leftStack.add(newM);
			moving.add((GameObject) newM);
		}
		iterator = GameInfo.getInstance().getRightStack().createIterator();
		while (iterator.hasNext()) {
			oldM = (Movable) ((Movable) iterator.next());
			newM = (Movable) oldM.clone();
			rightStack.add(newM);
			moving.add((GameObject) newM);
		}

		iterator = GameInfo.getInstance().getMoving().createIterator();
		while (iterator.hasNext()) {
			GameObject o = (GameObject) iterator.next();
			if (Movable.class.isAssignableFrom(o.getClass())) {
				oldM = (Movable) o;
				if (GameInfo.getInstance().getRightStack().getCollection().contains(oldM)
						|| GameInfo.getInstance().getLeftStack().getCollection().contains(oldM)) {
					continue;
				}
				newM = (Movable) oldM.clone();
				moving.add((GameObject) newM);
			} else {
				moving.add(o);
			}

		}

		iterator = GameInfo.getInstance().getControl().createIterator();
		while (iterator.hasNext()) {
			control.add((GameObject) ((AbstractObject) iterator.next()).clone());
		}

		/*
		 * for(int i = 0; i < GameInfo.getInstance().getLeftStack().size(); i++) {
		 * leftStack.push(GameInfo.getInstance().getLeftStack().get(i).clone()); }
		 * for(int i = 0; i < GameInfo.getInstance().getRightStack().size(); i++) {
		 * rightStack.push(GameInfo.getInstance().getRightStack().get(i).clone()); }
		 */
	}

	private void fillStacksForLoad() {
		GameInfo.getInstance().getLeftStack().clear();
		GameInfo.getInstance().getRightStack().clear();
		GameInfo.getInstance().getMoving().clear();
		//GameInfo.getInstance().getControl().clear();
		// 3aizen n clear collision w add feh tani l gded b3d l clone
		GameInfo.getInstance().getCollision().clear();
		AbstractObject oldM, newM;

		IteratorI iterator = leftStack.createIterator();
		while (iterator.hasNext()) {
			oldM = ((Movable) iterator.next());
			newM = (Movable) oldM.clone();
			GameInfo.getInstance().getLeftStack().add((Movable) newM);
			GameInfo.getInstance().getMoving().addFirst((GameObject) newM);
			GameInfo.getInstance().getCollision().addObserver((Observer) newM);
		}
		iterator = rightStack.createIterator();
		while (iterator.hasNext()) {
			oldM = ((Movable) iterator.next());
			newM = (Movable) oldM.clone();
			GameInfo.getInstance().getRightStack().add((Movable) newM);
			GameInfo.getInstance().getMoving().addFirst((GameObject) newM);
			GameInfo.getInstance().getCollision().addObserver((Observer) newM);

		}

		iterator = moving.createIterator();
		while (iterator.hasNext()) {
			oldM = ((AbstractObject) iterator.next());
			newM = (AbstractObject) oldM.clone();

			if (rightStack.getCollection().contains(oldM) || leftStack.getCollection().contains(oldM)) {
				continue;
			}
			if (Movable.class.isAssignableFrom(newM.getClass())) {
				GameInfo.getInstance().getMoving().addFirst((GameObject) newM);
				GameInfo.getInstance().getCollision().addObserver((Observer) newM);
			} else {
				GameInfo.getInstance().getMoving().add((GameObject) newM);
			}

		}
//		iterator = control.createIterator();
//		while (iterator.hasNext()) {
//			GameInfo.getInstance().getControl().add((GameObject) ((AbstractObject) iterator.next()).clone());
//		}
	}

	public void startFromCheckpoint() {
		GameInfo.getInstance().setScore(score);
		fillStacksForLoad();
		GameInfo.getInstance().setLeftColorCounter(leftColorCounter);
		GameInfo.getInstance().setRightColorCounter(rightColorCounter);
		GameInfo.getInstance().getPlayer().setX(playerPositionX);
		GameInfo.getInstance().getPlayer().setY(playerPositionY);

		GameInfo.getInstance().setLeftHand(leftHand);
		GameInfo.getInstance().setRightHand(rightHand);
		GameInfo.getInstance().setLeftStackHeight(leftStackHeight);
		GameInfo.getInstance().setRightStackHeight(rightStackHeight);

		for (Movable m : GameInfo.getInstance().getLeftStack().getCollection()) {
			System.out.println("Left" + m.getClass() + "  " + m.getState().getClass());
		}
		for (Movable m : GameInfo.getInstance().getRightStack().getCollection()) {
			System.out.println("Right " + m.getClass() + "  " + m.getState().getClass());
		}

	}

}
