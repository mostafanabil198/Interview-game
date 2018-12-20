package eg.edu.alexu.csd.oop.cs51.objects.skills;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.factory.CompanyFactory;
import eg.edu.alexu.csd.oop.cs51.factory.ICompanyFactory;
import eg.edu.alexu.csd.oop.cs51.flyweight.FlyweightFactory;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.states.MovingState;

public class Canon {
    private List<String> companies;
    private List<String> skills;
    private List<String> gifts;
    private Random random;
    private Movable movableObject;
    private String canonType;
    private ICompanyFactory factory;

    public Canon(String type, CompanyFactory factory) {
        this.companies = factory.getCompaniesNames();
        this.canonType = type;
        this.factory = factory;
        random = new Random();
    }

    public Movable createObject() {
        fillSkillArray();
        fillGiftArray();
        int rand = random.nextInt(100) + 1;
        if (rand <= 10) {
            int GiftIndex = random.nextInt(gifts.size());
            String gift = companies.get(GiftIndex);
            movableObject = FlyweightFactory.getGift(gift);
            if (movableObject == null) {
                // factory lel gifts
            	movableObject = new FaceBookSkill("cv", GameInfo.getInstance().getCollision());
            }
        } else {
            int CompanyIndex = random.nextInt(companies.size());
            String company = companies.get(CompanyIndex);
            int SkillIndex = random.nextInt(skills.size());
            String skill = companies.get(SkillIndex);
            movableObject = FlyweightFactory.getSkill(company, skill);
            if (movableObject == null) {
                try {
                    movableObject = factory.createNewMovable(company, skill);
                } catch (InstantiationException | IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        setmovableObject();
        return movableObject;
    }

    public void setmovableObject() {
        Point topLeft = new Point(0, 0);
        Point topRight = new Point(100, 0);
        int x = 0, y = 0;
        MovingState state = new MovingState();
        if (canonType.equals("left")) {
            x = (int) topLeft.getX();
            y = (int) topLeft.getY();
            state.setVelocityX(random.nextInt(5) + 1);
            state.setVelocityY(0);
        } else if (canonType.equals("right")) {
            x = (int) topRight.getX();
            y = (int) topRight.getY();
            state.setVelocityX((random.nextInt(5) + 1) * -1);
            state.setVelocityY(0);
        }
        movableObject.setX(x);
        movableObject.setY(y);
        movableObject.setVisible(true);
        state.doAction(movableObject);

    }

    public void fillSkillArray() {
        skills = GameInfo.getInstance().getAllSkills();
    }

    public void fillGiftArray() {
        // fill the gift array
    }
}
