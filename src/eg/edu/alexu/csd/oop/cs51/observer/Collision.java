package eg.edu.alexu.csd.oop.cs51.observer;

import java.util.ArrayList;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;

public class Collision {
private ArrayList<Observer> observers = new ArrayList<Observer>();
private static final int GroundY=10;
public void addObserver(Observer observer) {
	observers.add(observer);
}
public void notifyObservers() {
	for(Observer observer:observers) {
		Movable movable = ((Movable) observer);
		if(movable.getY()<=GroundY) {
			observer.update("vanishGround");
		}
		
	}
}
}
