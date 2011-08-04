package net.terzeron.pattern.observer2;
import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
    	observable.addObserver(this);
    }

    public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
		    WeatherData weatherData = (WeatherData) observable;
		    lastPressure = currentPressure;
		    currentPressure = weatherData.getPressure();
		    display();
		}
    }

    public void display() {
		if (currentPressure > lastPressure) {
		    System.out.println("Forecast: Improving weather on the way!");
		} else if (currentPressure < lastPressure) {
		    System.out.println("Forecast: Watch out for cooler, rainy weather");
		} else {
		    System.out.println("Forecast: More of the same");
		}
    }

}