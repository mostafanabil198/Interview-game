package eg.edu.alexu.csd.oop.cs51.flyweight;

import java.util.ArrayList;
import java.util.HashMap;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class FlyweightFactory {
    private static HashMap<String, ArrayList<Movable>> vanishedSkills = new HashMap<String, ArrayList<Movable>>();
    private static HashMap<String, ArrayList<Movable>> vanishedGifts = new HashMap<String, ArrayList<Movable>>();

    public static Movable getSkill(String company, String skillname) {

        Movable p = null;
        if (vanishedSkills.containsKey(company)) {
            System.out.println(vanishedSkills.get(company).size());
            if (!vanishedSkills.get(company).isEmpty()) {
                p = vanishedSkills.get(company).remove(0);
                System.out.println("returned from fly");
                p.setName("FW");
            }
        }

        return p;
    }

    public static Movable getGift(String gift) {
        Movable p = null;
        if (vanishedGifts.containsKey(gift)) {
            if (!vanishedSkills.get(gift).isEmpty()) {
                p = vanishedSkills.get(gift).remove(0);
            }
        }

        return p;
    }

    public static void addVanishedSkill(Movable o) {
        System.out.println("add to flyW");
        String company = o.getClass().getSimpleName();
        if (vanishedSkills.containsKey(company)) {
            vanishedSkills.get(company).add(o);
        } else {
            vanishedSkills.put(company, new ArrayList<Movable>());
            vanishedSkills.get(company).add(o);
        }
    }

    public static void addVanishedGift(Movable o) {
        String company = o.getClass().getSimpleName();
        if (vanishedGifts.containsKey(company)) {
            vanishedGifts.get(company).add(o);
        } else {
            vanishedGifts.put(company, new ArrayList<Movable>());
            vanishedGifts.get(company).add(o);
        }
    }
}
