package eg.edu.alexu.csd.oop.cs51.world;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.constant.Background;
import eg.edu.alexu.csd.oop.cs51.objects.constant.CanonObject;
import eg.edu.alexu.csd.oop.cs51.objects.skills.Canon;
import eg.edu.alexu.csd.oop.cs51.strategy.Strategy;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

public class Interview implements World {
	private int fireRate;
	private boolean opaque;
	private Canon canonRight;
	private Canon canonLeft;
	private int width, height, speed, controlSpeed;
	private String status;
	private Background background;
	private CanonObject canonObject;
	private int refreshCounter;

	public Interview(Strategy strategy, int width, int height) {
		this.width = width;
		this.height = height;
		refreshCounter = 0;
		Map<String, Object> levelData = strategy.doOperation();
		this.opaque = (boolean) levelData.get("opaque");
		this.fireRate = (int) levelData.get("fireRate");
		this.speed = (int) levelData.get("refreshSpeed");
		this.controlSpeed = (int) levelData.get("controlSpeed");
		canonLeft = new Canon("left", GameInfo.getInstance().getCompanyFactory());
		canonRight = new Canon("right", GameInfo.getInstance().getCompanyFactory());
		background = new Background(width, height);
		canonObject = new CanonObject();
		GameInfo.getInstance().getConstant().addFirst(background);
		GameInfo.getInstance().getMoving().add(canonObject);
		GameInfo.getInstance().setRenderSpeed(speed);

	}

	@Override
	public List<GameObject> getConstantObjects() {
		return (List<GameObject>) GameInfo.getInstance().getConstant().getCollection();
	}

	@Override
	public List<GameObject> getMovableObjects() {
		return (List<GameObject>) GameInfo.getInstance().getMoving().getCollection();
	}

	@Override
	public List<GameObject> getControlableObjects() {
		return (List<GameObject>) GameInfo.getInstance().getControl().getCollection();
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean refresh() {
		if(GameInfo.getInstance().getLeftStack().size() == 10 || GameInfo.getInstance().getRightStack().size() == 10) {
			//5aasrrrrrrrrrrr
			//return false;
			Scanner scan = new Scanner(System.in);
			int i = scan.nextInt();
			if(i == 1) {
				GameInfo.getInstance().getCheckPoint().startFromCheckpoint();
			} else {
				return false;
			}
		}
		GameInfo.getInstance().updateHandPositions();
		if (refreshCounter > fireRate) {
			refreshCounter = 0;
			canonLeft.createObject();
			canonRight.createObject();
		}
		refreshCounter++;
		GameInfo.getInstance().getCollision().notifyObservers();
		if (GameInfo.getInstance().getGameTasks().size() == 0) {
			//kasaaaab
			return false;
		}
		return true;
		
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getControlSpeed() {
		return controlSpeed;
	}

}
