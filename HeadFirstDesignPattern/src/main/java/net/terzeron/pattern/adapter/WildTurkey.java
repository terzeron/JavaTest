package net.terzeron.pattern.adapter;

public class WildTurkey implements Turkey {
	public final void gobble() {
		System.out.println("Gobble gobble");
	}
	public final void fly() {
		System.out.println("I'm flying a short distance");
	}
}
