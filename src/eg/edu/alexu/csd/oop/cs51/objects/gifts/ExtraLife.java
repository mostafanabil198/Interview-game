package eg.edu.alexu.csd.oop.cs51.objects.gifts;


import java.io.IOException;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.logger.Logger;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.states.MovingState;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;

public class ExtraLife extends Movable {

    private static final String PATH = "res/HeartGift.png";
    
    public ExtraLife() {
        super(PATH, "");
        System.out.println("extra");
    }
    public ExtraLife(ExtraLife extraLife) {
        super(extraLife);
    }
    
    @Override
    public void update(String spot) {
        if(spot.equals("vanish")) {
            new VanishState().doAction(this);
        } else if (spot.equals("leftStack")) {
        	try {
				Logger.getInstance().info("collect extra life");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
			}
            int lives = GameInfo.getInstance().getNumOfLives();
            GameInfo.getInstance().setNumOfLives(lives + 1);
            new VanishState().doAction(this);
        } else if (spot.equals("rightStack")) {
        	try {
				Logger.getInstance().info("collect extra life");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
			}
            int lives = GameInfo.getInstance().getNumOfLives();
            GameInfo.getInstance().setNumOfLives(lives + 1);
            new VanishState().doAction(this);
        } else {
            MovingState state = (MovingState) getState();
            state.updatePosition(this);
        }
        GameInfo.getInstance().getLivesObject().repaint();
        
    }

    @Override
    public Movable clone() {
        return new ExtraLife(this);
    }

}
