package eg.edu.alexu.csd.oop.cs51.snapshots;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.iterators.Collections;
import eg.edu.alexu.csd.oop.cs51.iterators.IteratorI;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.player.Interviewee;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;

public class SnapShot {
	private int score;
	private Collections<Movable> leftStack, rightStack;
	private int time;
	private int leftColorCounter;
	private int rightColorCounter;
	private int playerPositionX;
	private int playerPositionY;
	private int leftStackHeight;
	private int rightStackHeight;
	private int leftHand;
	private int rightHand;
	private int numOfLives;
	
	
	private Collections<GameObject> moving; 
	private Collections<GameObject> control; 

	public SnapShot() {
		score = GameInfo.getInstance().getScore();
		fillStacksForSave();
		time = GameInfo.getInstance().getTime();
		leftColorCounter = GameInfo.getInstance().getLeftColorCounter();
		rightColorCounter = GameInfo.getInstance().getRightColorCounter();
		playerPositionX = GameInfo.getInstance().getPlayer().getX();
		playerPositionY = GameInfo.getInstance().getPlayer().getY();

		leftStackHeight = GameInfo.getInstance().getLeftStackHeight();
		rightStackHeight = GameInfo.getInstance().getRightStackHeight();
		leftHand = GameInfo.getInstance().getLeftHand();
		rightHand = GameInfo.getInstance().getRightHand();
		numOfLives = GameInfo.getInstance().getNumOfLives();
		
		

	}

	private void fillStacksForSave() {
		leftStack.clear();
		rightStack.clear();
		IteratorI iterator = GameInfo.getInstance().getLeftStack().createIterator();
		while (iterator.hasNext()) {
			leftStack.add((Movable) ((Movable) iterator.next()).clone());
		}
		iterator = GameInfo.getInstance().getRightStack().createIterator();
		while (iterator.hasNext()) {
			rightStack.add((Movable) ((Movable) iterator.next()).clone());
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
		IteratorI iterator = leftStack.createIterator();
		while (iterator.hasNext()) {
			GameInfo.getInstance().getLeftStack().add((Movable) ((Movable)iterator.next()).clone());
		}
		iterator = rightStack.createIterator();
		while (iterator.hasNext()) {
			GameInfo.getInstance().getRightStack().add((Movable) ((Movable)iterator.next()).clone());
		}
	}

	public void startFromCheckpoint() {
		GameInfo.getInstance().setScore(score);
		fillStacksForLoad();
		GameInfo.getInstance().setLeftColorCounter(leftColorCounter);
		GameInfo.getInstance().setRightColorCounter(rightColorCounter);
		GameInfo.getInstance().getPlayer().setX(playerPositionX);
		GameInfo.getInstance().getPlayer().setY(playerPositionY);
	}

}
