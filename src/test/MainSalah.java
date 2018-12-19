package test;

import java.awt.Color;
import java.lang.reflect.Constructor;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.skills.FaceBookSkill;
import eg.edu.alexu.csd.oop.cs51.objects.skills.SkillLoader;

public class MainSalah {

    public static void main(String[] args) {
        SkillLoader sl = new SkillLoader("jars");
        sl.load();
        System.out.println(sl.getSkills().size());
        
    }

}
