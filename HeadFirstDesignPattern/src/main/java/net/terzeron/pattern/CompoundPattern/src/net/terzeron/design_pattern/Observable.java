import java.util.ArrayList;
import java.util.List;


public class Observable implements QuackObservable {
	List<Observer> observers = new ArrayList<Observer>();
	QuackObservable duck;
	
	public Observable(QuackObservable duck) {
		this.duck = duck;
	}
	
	public void registerObserver(Observer observer) {
		// TODO
	}
	
	public void notifyObservers() {
		// TODO
	}

}
