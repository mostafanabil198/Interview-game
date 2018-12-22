package eg.edu.alexu.csd.oop.cs51.world;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.logger.Logger;
import eg.edu.alexu.csd.oop.cs51.music.Playmusic;
import eg.edu.alexu.csd.oop.cs51.objects.constant.Background;
import eg.edu.alexu.csd.oop.cs51.objects.constant.CanonObject;
import eg.edu.alexu.csd.oop.cs51.objects.constant.Shadow;
import eg.edu.alexu.csd.oop.cs51.objects.skills.Canon;
import eg.edu.alexu.csd.oop.cs51.strategy.Strategy;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;

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
	private GameEngine gameEngine;
	private GameController gameController;
	private Playmusic playMusic;

	public Interview(Strategy strategy, int width, int height, GameEngine gameEngine) {
		this.width = width;
		this.height = height;
		this.gameEngine = gameEngine;
		playMusic = new Playmusic();
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
		if (opaque) {
			GameInfo.getInstance().setOpaque(true);
			GameInfo.getInstance().getMoving().add(new Shadow());
		}
		GameInfo.getInstance().getConstant().add(GameInfo.getInstance().getLivesObject());
		GameInfo.getInstance().setRenderSpeed(speed);
		gameController = gameEngine.start("Interview Game", this);

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
		if (GameInfo.getInstance().getLeftStack().size() == 10 || GameInfo.getInstance().getRightStack().size() == 10) {
			try {
				Logger.getInstance().info("stack is full");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
			}
			// 5aasrrrrrrrrrrr
			GameInfo.getInstance().setNumOfLives(GameInfo.getInstance().getNumOfLives() - 1);
			GameInfo.getInstance().getLivesObject().repaint();
			if (GameInfo.getInstance().getNumOfLives() > 0) {
				gameController.pause();
				Object[] options = { "Yes", "No" };
				JOptionPane optionPane = new JOptionPane();
				if (optionPane.showOptionDialog(null, "Do you wanna start from the check point", "Quesstion",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
					GameInfo.getInstance().getCheckPoint().startFromCheckpoint();
					gameController.resume();
					try {
						Logger.getInstance().info("back to check point");
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
					}
				} else {
					return false;
				}

			} else {
				gameController.pause();
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
			gameController.pause();
			JOptionPane.showMessageDialog(null, "WINNER WINNER ACCEPTED DINNER");
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
