package eg.edu.alexu.csd.oop.cs51.objects.skills;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.objects.states.CollectState;
import eg.edu.alexu.csd.oop.cs51.objects.states.MovingState;
import eg.edu.alexu.csd.oop.cs51.objects.states.VanishState;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;

public class WhatsAppSkill extends Movable implements Skill {
	private static final String PATH = "res/whatsapp.png";

    public WhatsAppSkill(String name, Collision collision) {
        super(PATH, name, collision);
    }

    public WhatsAppSkill(WhatsAppSkill whatsappSkill) {
        super(whatsappSkill);
    
    }
	@Override
	public void update(String spot) {
		 if(spot.equals("vanish")) {
	           new VanishState().doAction(this);
	        } else if (spot.equals("rightStack")) {
	           new CollectState("right").doAction(this);
	        } else if (spot.equals("leftStack")) {
	           new CollectState("left").doAction(this);
	        } else {
	            MovingState state = (MovingState) getState();
	            state.updatePosition(this);
	         }
		
	}

	@Override
	public Movable clone() {
		return new WhatsAppSkill(this);
	}

}
