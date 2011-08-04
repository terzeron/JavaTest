package net.terzeron.pattern.strategy;

public class MallardDuck extends Duck {
    public MallardDuck() {
    	quackBehavior = new Quack();
    	flyBehavior = new FlyWithWings();
    }

    public void display() {
    	System.out.println("저는 물오리입니다.");
    }
}