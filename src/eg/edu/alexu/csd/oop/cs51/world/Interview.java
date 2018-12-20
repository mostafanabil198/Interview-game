package eg.edu.alexu.csd.oop.cs51.world;

import java.util.List;
import java.util.Map;

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
	private int width, height;
	private Background background;
	private CanonObject canonObject;
	
	public Interview(Strategy strategy, int width, int height) {
		this.width = width;
		this.height = height;
		Map<String,Object> levelData = strategy.doOperation();
		this.opaque = (boolean) levelData.get("opaque");
		this.fireRate = (int) levelData.get("fireRate");
		canonLeft = new Canon("left", GameInfo.getInstance().getCompanyFactory());
		canonRight = new Canon("right", GameInfo.getInstance().getCompanyFactory());
		background = new Background(width,height);
		canonObject = new CanonObject();
		GameInfo.getInstance().getConstant().add(background);
		// n8ir da lw mrsmsh l objects t7teh n5leh fl constant
		GameInfo.getInstance().getMoving().add(canonObject);
		
		
		
	 }

	@Override
	public List<GameObject> getConstantObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GameObject> getMovableObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean refresh() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

}
