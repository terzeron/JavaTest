package net.terzeron.pattern.decorator;
public class StarbuzzCoffee {
    public static void main(String args[]) {
	Beverage beverage = new Espresso();
	System.out.println(beverage.getDescription() + ": $" + 
			   beverage.cost());
	
	Beverage beverage2 = new HouseBlend();
	beverage2.setSize(Size.VENTI);
	beverage2 = new Mocha(beverage2);
	beverage2 = new WhippingCream(beverage2);
	System.out.println(beverage2.getDescription() + ": $" +
			   beverage2.cost());

	Beverage beverage3 = new Espresso();
	beverage3.setSize(Size.TALL);
	beverage3 = new Soy(beverage3);
	beverage3 = new WhippingCream(beverage3);
	System.out.println(beverage3.getDescription() + ": $" +
			   beverage3.cost());

    }
}