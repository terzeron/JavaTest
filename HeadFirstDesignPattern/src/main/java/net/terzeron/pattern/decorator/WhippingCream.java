package net.terzeron.pattern.decorator;
public class WhippingCream extends CondimentDecorator {
    Beverage beverage;

    public WhippingCream(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", 휘핑크림";
    }

    public double cost() {
        return 0.35 + beverage.cost();
    }
}
