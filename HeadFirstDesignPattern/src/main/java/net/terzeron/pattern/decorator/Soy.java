package net.terzeron.pattern.decorator;
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
	this.beverage = beverage;
    }

    public Size getSize() {
	return beverage.getSize();
    }

    public String getDescription() {
	return beverage.getDescription() + ", 두유";
    }

    public double cost() {
	double cost = beverage.cost();
	
	if (getSize() == Size.TALL) {
	    System.out.print("TALL ");
	    cost += 0.10;
	} else if (getSize() == Size.GRANDE) {
	    System.out.print("GRANDE ");
	    cost += 0.15;
	} else if (getSize() == Size.VENTI) {
	    System.out.print("VENTI ");
	    cost += 0.20;
	} 
	
	return cost;
    }
}