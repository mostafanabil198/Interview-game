package eg.edu.alexu.csd.oop.cs51.factory;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;

public class CompanyFactory implements ICompanyFactory {
	
	private ArrayList<Class<Movable>> classes;
	
	 public CompanyFactory(ArrayList<Class<Movable>> classes) {
		 this.classes = classes;
		 
	 }
	
	@Override
	public Movable createNewMovable(String companyName, String skillName) throws InstantiationException, IllegalAccessException {
		for(int i = 0;i< classes.size();i++) {
			if(companyName.equals(classes.get(i).getSimpleName())) {
			    try {
                    Constructor con = classes.get(i).getConstructor(String.class, Collision.class);
                    Movable movable = con.newInstance(skillName, GameInfo.getInstance().getCollision());
                    return movable;
                } catch (Exception e) {
                    e.printStackTrace();
                }
			}
		}
		return null;
	}

}
