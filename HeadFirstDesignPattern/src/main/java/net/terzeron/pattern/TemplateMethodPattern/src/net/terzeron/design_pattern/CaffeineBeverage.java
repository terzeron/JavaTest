package net.terzeron.design_pattern;

/**
 * Created by terzeron on 2016. 1. 20..
 */
public abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("boiling water...");
    }

    void pourInCup() {
        System.out.println("pouring in cup...");
    }


    boolean customerWantsCondiments() {
        return true;
    }
}
