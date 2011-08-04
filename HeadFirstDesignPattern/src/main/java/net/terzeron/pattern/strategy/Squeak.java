package net.terzeron.pattern.strategy;

public class Squeak implements QuackBehavior {
    public void quack() {
    	System.out.println("Squeak");
    }
}