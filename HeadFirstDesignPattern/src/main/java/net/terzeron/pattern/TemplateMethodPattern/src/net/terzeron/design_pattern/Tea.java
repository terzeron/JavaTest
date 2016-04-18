package net.terzeron.design_pattern;

/**
 * Created by terzeron on 2016. 1. 20..
 */
public class Tea extends CaffeineBeverage {
    public void brew() {
        System.out.println("brewing a tea...");
    }

    public void addCondiments() {
        System.out.println("adding a lemon to the tea...");
    }
}
