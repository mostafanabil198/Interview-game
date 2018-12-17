package eg.edu.alexu.csd.oop.cs51;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.snapshots.SnapShot;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;

public class GameInfo {
	private static volatile GameInfo instance;
	private int score;
	private Stack<Skill> leftStack, rightStack;
	private int numOfLives;
	private int time;
	private Map<String, Task> gameTasks;
	private int leftColorCounter;
	private int rightColorCounter;	
	private Color leftColor;
	private Color rightColor;
	private SnapShot checkPoint;
	
	
	
	private GameInfo() {
		leftStack = new Stack<Skill>();
		rightStack = new Stack<Skill>();
		gameTasks = new HashMap<>();
		
	}
	
	public static GameInfo getInstance() {
		if(instance == null) {
			synchronized (GameInfo.class) {
				if(instance == null) {
					instance = new GameInfo();

				}
			}
		}
		return instance;
	}
	
	
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Stack<Skill> getLeftStack() {
		return leftStack;
	}

	public void setLeftStack(Stack<Skill> leftStack) {
		this.leftStack = leftStack;
	}

	public Stack<Skill> getRightStack() {
		return rightStack;
	}

	public void setRightStack(Stack<Skill> rightStack) {
		this.rightStack = rightStack;
	}

	public int getNumOfLives() {
		return numOfLives;
	}

	public void setNumOfLives(int numOfLives) {
		this.numOfLives = numOfLives;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Map<String, Task> getGameTasks() {
		return gameTasks;
	}

	public void setGameTasks(Map<String, Task> gameTasks) {
		this.gameTasks = gameTasks;
	}

	public int getLeftColorCounter() {
		return leftColorCounter;
	}

	public void setLeftColorCounter(int leftColorCounter) {
		this.leftColorCounter = leftColorCounter;
	}

	public int getRightColorCounter() {
		return rightColorCounter;
	}

	public void setRightColorCounter(int rightColorCounter) {
		this.rightColorCounter = rightColorCounter;
	}

	public Color getLeftColor() {
		return leftColor;
	}

	public void setLeftColor(Color leftColor) {
		this.leftColor = leftColor;
	}

	public Color getRightColor() {
		return rightColor;
	}

	public void setRightColor(Color rightColor) {
		this.rightColor = rightColor;
	}

	public SnapShot getCheckPoint() {
		return checkPoint;
	}

	public void setCheckPoint(SnapShot checkPoint) {
		this.checkPoint = checkPoint;
	}


}
