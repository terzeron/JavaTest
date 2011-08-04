package net.terzeron.pattern.decorator;
public class Espresso extends Beverage {
    public Espresso() {
    	description = "Espresso Coffee";
    }

    public void setSize(Size size) {
	super.size = size;
    }

    public Size getSize() {
	return super.getSize();
    }

    public double cost() {
	double cost = 1.99;

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