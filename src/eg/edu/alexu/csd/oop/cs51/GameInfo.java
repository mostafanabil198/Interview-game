package eg.edu.alexu.csd.oop.cs51;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.objects.player.interviewee;
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
	private interviewee player;
	private int playerHandWidth;
	private int playerWidth;
	private int playerHeight;
	private String ImagePath;
	private boolean visible;
	private int leftStackHeight;
	private int rightStackHeight;
	private int leftHand;
	private int rightHand;
	private int renderSpeed;
	
	
	
	
	private GameInfo() {
		playerWidth = 200;
		playerHeight = 300;
		ImagePath = "";
		visible = true;
		leftStack = new Stack<Skill>();
		rightStack = new Stack<Skill>();
		gameTasks = new HashMap<>();
		player = new interviewee(playerWidth,playerHeight,ImagePath,visible);
		playerHandWidth = player.getHandWidht();
		leftStackHeight = rightStackHeight = player.getHandHeightPosition();
		leftHand = player.getLeftHandPosition();
		rightHand = player.getRightHandPosition();
		
		
		
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
	
	public void addToRightStack(Skill skill) {
		if(rightColor == skill.getColor()) {
			rightColorCounter++;
		} else {
			rightColor = skill.getColor();
			rightColorCounter = 1;
		}
		rightStack.push(skill);
		int skillHight =(Skill) rightStack.peek().getHeight();
		rightStackHeight = skillHight * rightStack.size();
		
	}
	
	public void addToLeftStack(Skill skill) {
		if(leftColor == skill.getColor()) {
			leftColorCounter++;
		} else {
			leftColor = skill.getColor();
			leftColorCounter = 1;
		}
		leftStack.push(skill);
		int skillHight = leftStack.peek().getHeight();
		leftStackHeight = skillHight * leftStack.size();
		
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
	
	public void addTask(String taskName, Task task) {
		gameTasks.put(taskName, task);
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
	
	public interviewee getPlayer() {
		return player;
	}
	
	public int getPlayerHandWidth() {
		return playerHandWidth;
	}
	
	public int getLeftStackHeight() {
		return leftStackHeight;
	}



	public int getRightStackHeight() {
		return rightStackHeight;
	}



	public int getLeftHand() {
		return leftHand;
	}



	public int getRightHand() {
		return rightHand;
	}


}
