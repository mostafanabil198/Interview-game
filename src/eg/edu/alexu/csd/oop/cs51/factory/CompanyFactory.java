package eg.edu.alexu.csd.oop.cs51.factory;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.cs51.GameInfo;
import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.Skill;
import eg.edu.alexu.csd.oop.cs51.observer.Collision;

public class CompanyFactory implements ICompanyFactory {

	private List<Class<? extends Movable>> classes;

	public CompanyFactory(List<Class<? extends Movable>> list) {
		this.classes = list;

	}

	@Override
	public Movable createNewMovable(String companyName, String skillName)
			throws InstantiationException, IllegalAccessException {
		for (int i = 0; i < classes.size(); i++) {
			if (companyName.equals(classes.get(i).getSimpleName())) {
				try {
					Constructor con = classes.get(i).getConstructor(String.class, Collision.class);
					Movable movable = (Movable) con.newInstance(skillName, GameInfo.getInstance().getCollision());
					return movable;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public List<Class<? extends Movable>> getSupportedCompanies() {
		return classes;
	}

	public List<String> getCompaniesNames() {
		List names = new ArrayList<>();
		for (Class<? extends Movable> m : getSupportedCompanies()) {
			names.add(m.getSimpleName());
		}
		return names;
	}

}
