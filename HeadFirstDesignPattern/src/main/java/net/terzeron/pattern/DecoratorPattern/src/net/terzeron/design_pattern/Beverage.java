package net.terzeron.design_pattern;

/**
 * Created by terzeron on 2016. 1. 4..
 */
public abstract class Beverage {
    String description = "no title";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
