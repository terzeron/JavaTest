package net.terzeron.pattern.adapter;

public class TurkeyAdapter implements Duck {
	private Turkey turkey;

	public TurkeyAdapter(final Turkey aTurkey) {
		this.turkey = aTurkey;
	}

	public final void quack() {
		turkey.gobble();
	}

	public final void fly() {
		final int numTries = 5;
		for (int i = 0; i < numTries; i++) {
			turkey.fly();
		}
	}
}
