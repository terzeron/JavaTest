package net.terzeron.design_pattern;

public class DuckDecoratorSimulator {

	public static void main(String[] args) {
		DuckDecoratorSimulator simulator = new DuckDecoratorSimulator();
		simulator.simulate();
	}

	private void simulate() {
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable redheadDuck = new QuackCounter(new RedheadDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable rubberDuck = new QuackCounter(new RubberDuck()); 
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		System.out.println("\nDuck Simulator: With Decorator");
		
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseDuck);
		
		System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
	}
	
	private void simulate(Quackable quackable) {
		quackable.quack();
	}

}
