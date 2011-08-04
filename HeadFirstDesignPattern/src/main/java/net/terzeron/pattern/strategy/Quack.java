package net.terzeron.pattern.strategy;

public class Quack implements QuackBehavior {
    public void quack() {
    	System.out.println("Quack!");
    }
}