package eg.edu.alexu.csd.oop.cs51.observer;

import java.util.ArrayList;

public class Collision {
private ArrayList<Observer> observers = new ArrayList<Observer>();
public void addObserver(Observer observer) {
	observers.add(observer);
}
public void notifyObservers() {
	for(Observer observer:observers) {
		observer.update();
	}
}
}
