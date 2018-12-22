package eg.edu.alexu.csd.oop.cs51;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.cs51.factory.CompanyFactory;
import eg.edu.alexu.csd.oop.cs51.iterators.Collections;
import eg.edu.alexu.csd.oop.cs51.iterators.IteratorI;
import eg.edu.alexu.csd.oop.cs51.iterators.LinkedListContainer;
import eg.edu.alexu.csd.oop.cs51.iterators.StackContainer;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.TaskObjectsPositioner;
import eg.edu.alexu.csd.oop.cs51.objects.constant.TaskObject;
import eg.edu.alexu.csd.oop.cs51.objects.player.Interviewee;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;
import eg.edu.alexu.csd.oop.cs51.snapshots.SnapShot;
import eg.edu.alexu.csd.oop.cs51.tasks.Task;
import eg.edu.alexu.csd.oop.game.GameObject;

public class GameInfo {
	private static volatile GameInfo instance;

	private int score;
	private int leftStackHeight;
	private int rightStackHeight;
	private int leftHand;
	private int rightHand;
	private int renderSpeed;
	private int playerHandWidth;
	private int leftColorCounter;
	private int rightColorCounter;
	private int numOfLives;
	private int time;
	private boolean musicOn, soundOn;

	private Collections<Movable> leftStack, rightStack;

	private Collections<Task> gameTasks;
	private Collections<GameObject> moving;
	private Collections<GameObject> control;
	private Collections<GameObject> constant;

	private Collision collision;

	private SnapShot checkPoint;

	private Interviewee player;

	private List<String> allSkills;

	private CompanyFactory companyFactory;
	// giftsfactory too

	private GameInfo() {
		musicOn = true;
		soundOn = true;
		leftStack = new StackContainer<Movable>();
		rightStack = new StackContainer<Movable>();
		gameTasks = new LinkedListContainer<Task>();
		player = new Interviewee();
		playerHandWidth = player.getHandWidth();
		player.setX(100);
		player.setY(500);
		leftStackHeight = player.getHandHeightPosition();
		rightStackHeight = player.getHandHeightPosition();
		leftHand = player.getLeftHandPosition();
		rightHand = player.getRightHandPosition();
		fillSkills();
		moving = new LinkedListContainer<GameObject>();
		control = new LinkedListContainer<GameObject>();
		constant = new LinkedListContainer<GameObject>();
		control.add(player);
		collision = new Collision();
	}

	public static GameInfo getInstance() {
		if (instance == null) {
			synchronized (GameInfo.class) {
				if (instance == null) {
					instance = new GameInfo();
				}
			}
		}
		return instance;
	}

	public void addToRightStack(Movable skill) {
		rightStackHeight = player.getHandHeightPosition();
		if ((rightStack.size() > 0) && rightStack.peek().getClass().isAssignableFrom(skill.getClass())) {
			rightStack.add(skill);
			rightColorCounter++;
			if (rightColorCounter == 3) {
				// method to check number of same color
				checkTask(rightStack.pop(), rightStack.pop(), rightStack.pop());
				rightColorCounter = numOfSameColor(rightStack);
			}
		} else {
			// rightColor = skill.getColor();
			rightStack.add(skill);
			rightColorCounter = 1;
		}
		// rightStack.add(skill);
		if (rightStack.size() > 0) {
			int skillHight = rightStack.peek().getHeight();

			rightStackHeight -= skillHight * rightStack.size();
		} else {
			rightStackHeight = player.getHandHeightPosition();
		}
		skill.setX(rightHand - playerHandWidth);
		skill.setY(rightStackHeight);

	}

	public void addToLeftStack(Movable skill) {
		leftStackHeight = player.getHandHeightPosition();
		if ((leftStack.size() > 0) && leftStack.peek().getClass().isAssignableFrom(skill.getClass())) {
			leftStack.add(skill);
			leftColorCounter++;
			if (leftColorCounter == 3) {
				checkTask(leftStack.pop(), leftStack.pop(), leftStack.pop());
				leftColorCounter = numOfSameColor(leftStack);
			}
		} else {
			leftStack.add(skill);
			leftColorCounter = 1;
		}
		// leftStack.add(skill);
		if (leftStack.size() > 0) {
			int skillHight = leftStack.peek().getHeight();
			leftStackHeight -= skillHight * leftStack.size();
		} else {
			leftStackHeight = player.getHandHeightPosition();
		}
		skill.setX(leftHand);
		skill.setY(leftStackHeight);

	}

	/// mesh fahem 7aga
	private int numOfSameColor(Collections<Movable> stack) {
		int counter = 1;
		IteratorI i = stack.createIterator();
		if (!i.hasNext()) {
			return 0;
		} else {
			Movable m = (Movable) i.next();
			String name = m.getClass().getSimpleName();
			if (i.hasNext()) {
				while (i.hasNext()) {
					if (name.equals(i.next().getClass().getSimpleName())) {
						counter++;
					} else {
						break;
					}
				}
			}
			return counter;
		}
	}

	private void checkTask(Movable task1, Movable task2, Movable task3) {
		IteratorI i = gameTasks.createIterator();
		while (i.hasNext()) {
			Task t = (Task) i.next();
			if (t.checkAchived(task1, task2, task3)) {
				score++;
				gameTasks.remove(t);
				t.getTaskObject().markAsDone();
				break;

			}
		}
		new VanishState().doAction(task1);
		new VanishState().doAction(task2);
		new VanishState().doAction(task3);

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Collections<Movable> getLeftStack() {
		return leftStack;
	}

	public void setLeftStack(Collections<Movable> leftStack) {
		this.leftStack = leftStack;
	}

	public Collections<Movable> getRightStack() {
		return rightStack;
	}

	public void setRightStack(Collections<Movable> rightStack) {
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

	public Collections<Task> getGameTasks() {
		return gameTasks;
	}

	public void setGameTasks(Collections<Task> gameTasks) {
		this.gameTasks = gameTasks;
		TaskObjectsPositioner.position((List<Task>)gameTasks.getCollection());
		IteratorI i = gameTasks.createIterator();
		while(i.hasNext()) {
		    constant.add((GameObject)i.next());
		}
	}

	public void addTask(Task task) {
		gameTasks.add(task);
		TaskObjectsPositioner.position((List<Task>)gameTasks.getCollection());
		constant.add(task.getTaskObject());
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

	public SnapShot getCheckPoint() {
		return checkPoint;
	}

	public void setCheckPoint(SnapShot checkPoint) {
		this.checkPoint = checkPoint;
	}

	public Interviewee getPlayer() {
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

	public int getRenderSpeed() {
		return renderSpeed;
	}

	public void setRenderSpeed(int renderSpeed) {
		this.renderSpeed = renderSpeed;
	}

	public void setLeftHand(int leftHand) {
		this.leftHand = leftHand;
	}

	public void setRightHand(int rightHand) {
		this.rightHand = rightHand;
	}

	public Collision getCollision() {
		return collision;
	}

	public void setCollision(Collision collision) {
		this.collision = collision;
	}

	public List<String> getAllSkills() {
		return allSkills;
	}

	public Collections<GameObject> getMoving() {
		return moving;
	}

	public void setMoving(Collections<GameObject> moving) {
		this.moving = moving;
	}

	public Collections<GameObject> getControl() {
		return control;
	}

	public void setControl(Collections<GameObject> control) {
		this.control = control;
	}

	public Collections<GameObject> getConstant() {
		return constant;
	}

	public void setConstant(Collections<GameObject> constant) {
		this.constant = constant;
	}

	public CompanyFactory getCompanyFactory() {
		return companyFactory;
	}

	public void setCompanyFactory(CompanyFactory companyFactory) {
		this.companyFactory = companyFactory;
	}

	public void setLeftStackHeight(int leftStackHeight) {
		this.leftStackHeight = leftStackHeight;
	}

	public void setRightStackHeight(int rightStackHeight) {
		this.rightStackHeight = rightStackHeight;
	}

	public boolean isMusicOn() {
		return musicOn;
	}

	public void setMusicOn(boolean musicOn) {
		this.musicOn = musicOn;
	}

	public boolean isSoundOn() {
		return soundOn;
	}

	public void setSoundOn(boolean soundOn) {
		this.soundOn = soundOn;
	}

	private void fillSkills() {
		allSkills = new ArrayList<String>();
		allSkills.add("CV");
		allSkills.add("PS");
		allSkills.add("Java");
		allSkills.add("C++");
		allSkills.add("Flutter");
		allSkills.add("Linux");
	}

	public void updateHandPositions() {
		rightHand = player.getRightHandPosition();
		leftHand = player.getLeftHandPosition();

	}
}
