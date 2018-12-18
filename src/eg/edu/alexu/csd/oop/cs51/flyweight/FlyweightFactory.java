package eg.edu.alexu.csd.oop.cs51.flyweight;

import java.util.ArrayList;
import java.util.HashMap;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class FlyweightFactory {
	 private static HashMap<String, ArrayList<Movable>> vanishedSkills ;
	 private static HashMap<String, ArrayList<Movable>> vanishedGifts ;
	 public FlyweightFactory() {
		 
		 vanishedSkills = new HashMap<String, ArrayList<Movable>>();
	 }
	 public static Movable getSkill(String company,String skillname) 
	    { 
	        Movable p = null; 
	        if (vanishedSkills.containsKey(company)) {
	        	if(!vanishedSkills.get(company).isEmpty()) {
	        	      p = vanishedSkills.get(company).remove(0);
	        	      p.setName(skillname);
	        	}
	        }
	        
	        return p; 
	    } 
	 public static Movable getGift(String gift) 
	    { 
	        Movable p = null; 
	        if (vanishedGifts.containsKey(gift)) {
	        	if(!vanishedSkills.get(gift).isEmpty()) {
	        	      p = vanishedSkills.get(gift).remove(0);
	        	}
	        }
	        
	        return p; 
	    } 
}
