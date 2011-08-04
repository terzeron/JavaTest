package net.terzeron.pattern.decorator;
public class HouseBlend extends Beverage {
    public HouseBlend() {
	description = "하우스 블렌드 커피";
    }
    
    public double cost() {
	double cost = 0.89;

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