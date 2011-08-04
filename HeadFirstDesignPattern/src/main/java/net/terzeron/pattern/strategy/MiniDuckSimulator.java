package net.terzeron.pattern.strategy;

public class MiniDuckSimulator{
    public static void main(String[] args) {
		System.out.println("=== mallard ===");
		Duck mallard = new MallardDuck();
		mallard.display();
		mallard.performQuack();
		mallard.performFly();
	
		System.out.println("=== model ===");
		Duck model = new ModelDuck();
		model.display();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
    }
}