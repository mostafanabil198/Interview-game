package eg.edu.alexu.csd.oop.cs51.factory;

import java.util.ArrayList;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class CompanyFactory implements ICompanyFactory {
	
	private ArrayList<Class<Movable>> classes;
	
	 public CompanyFactory(ArrayList<Class<Movable>> classes) {
		 this.classes = classes;
		 
	 }
	

	@Override
	
	public Movable createNewMovable(String companyName) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		for(int i = 0;i< classes.size();i++) {
			if(companyName.equals(classes.get(i).getSimpleName())) {
				return classes.get(i).newInstance();
			}
			
		}
		return null;
	}

}
