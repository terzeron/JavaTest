package net.terzeron.design_pattern;

/**
 * Created by terzeron on 2016. 1. 4..
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
