package net.terzeron.design_pattern;

/**
 * Created by terzeron on 2016. 1. 4..
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        return 0.30 + beverage.cost();
    }
}
