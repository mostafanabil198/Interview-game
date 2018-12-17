package eg.edu.alexu.csd.oop.cs51.snapshots;

import java.awt.Color;
import java.util.Map;
import java.util.Stack;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.iterators.Collections;
import eg.edu.alexu.csd.oop.cs51.iterators.IteratorI;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
//import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.objects.player.Interviewee;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;
import eg.edu.alexu.csd.oop.game.GameEngine;

public class SnapShot {
	private int score;
	private Collections<Movable> leftStack, rightStack;
	private int time;
	private int leftColorCounter;
	private int rightColorCounter;
	private Color leftColor;
	private Color rightColor;
	private int playerPositionX;
	private int playerPositionY;

	public SnapShot() {
		score = GameInfo.getInstance().getScore();
		fillStacksForSave();
		time = GameInfo.getInstance().getTime();
		leftColorCounter = GameInfo.getInstance().getLeftColorCounter();
		rightColorCounter = GameInfo.getInstance().getRightColorCounter();
		fillColors();
		playerPositionX = GameInfo.getInstance().getPlayer().getX();
		playerPositionY = GameInfo.getInstance().getPlayer().getY();
	}

	private void fillColors() {
		leftColor = new Color(GameInfo.getInstance().getLeftColor().getRGB());
		rightColor = new Color(GameInfo.getInstance().getRightColor().getRGB());
	}

	private void fillStacksForSave() {
		leftStack.clear();
		rightStack.clear();
		IteratorI iterator = GameInfo.getInstance().getLeftStack().createIterator();
		while (iterator.hasNext()) {
			leftStack.add(((Movable) iterator.next()).clone());
		}
		iterator = GameInfo.getInstance().getRightStack().createIterator();
		while (iterator.hasNext()) {
			rightStack.add(((Movable) iterator.next()).clone());
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
			GameInfo.getInstance().getLeftStack().add(((Movable)iterator.next()).clone());
		}
		iterator = rightStack.createIterator();
		while (iterator.hasNext()) {
			GameInfo.getInstance().getRightStack().add(((Movable)iterator.next()).clone());
		}
	}
	

	public void startFromCheckpoint() {
		GameInfo.getInstance().setScore(score);
		fillStacksForLoad();
		GameInfo.getInstance().setLeftColorCounter(leftColorCounter);
		GameInfo.getInstance().setRightColorCounter(rightColorCounter);
		GameInfo.getInstance().setLeftColor(new Color(leftColor.getRGB()));
		GameInfo.getInstance().setRightColor(new Color(rightColor.getRGB()));
		GameInfo.getInstance().getPlayer().setX(playerPositionX);
		GameInfo.getInstance().getPlayer().setY(playerPositionY);
	}

}
