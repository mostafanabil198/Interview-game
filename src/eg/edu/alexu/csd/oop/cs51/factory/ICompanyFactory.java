package eg.edu.alexu.csd.oop.cs51.factory;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public interface ICompanyFactory {
	public Movable createNewMovable(String companyName, String skillName)throws InstantiationException, IllegalAccessException;
	

}
