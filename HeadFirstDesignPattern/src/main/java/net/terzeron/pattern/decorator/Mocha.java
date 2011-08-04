package net.terzeron.pattern.decorator;
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
	this.beverage = beverage;
    }

    public Size getSize() {
        return beverage.getSize();
    }

    public String getDescription() {
	return beverage.getDescription() + ", 모카";
    }

    public double cost() {
        double cost = beverage.cost();

        if (getSize() == Size.TALL) {
            System.out.print("TALL ");
            cost += 0.20;
        } else if (getSize() == Size.GRANDE) {
            System.out.print("GRANDE ");
            cost += 0.25;
        } else if (getSize() == Size.VENTI) {
            System.out.print("VENTI ");
            cost += 0.30;
        }

        return cost;
    }
}