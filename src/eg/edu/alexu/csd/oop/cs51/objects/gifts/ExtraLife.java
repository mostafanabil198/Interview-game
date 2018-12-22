package eg.edu.alexu.csd.oop.cs51.objects.gifts;


import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.states.MovingState;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;

public class ExtraLife extends Movable {

    private static final String PATH = "res/gift.png";
    
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
            int lives = GameInfo.getInstance().getNumOfLives();
            GameInfo.getInstance().setNumOfLives(lives + 1);
            new VanishState().doAction(this);
        } else if (spot.equals("rightStack")) {
            int lives = GameInfo.getInstance().getNumOfLives();
            GameInfo.getInstance().setNumOfLives(lives + 1);
            new VanishState().doAction(this);
        } else {
            MovingState state = (MovingState) getState();
            state.updatePosition(this);
        }
        
    }

    @Override
    public Movable clone() {
        return new ExtraLife(this);
    }

}
