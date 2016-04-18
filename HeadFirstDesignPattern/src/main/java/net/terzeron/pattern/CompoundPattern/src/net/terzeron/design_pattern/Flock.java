package net.terzeron.design_pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Flock implements Quackable {
	List<Quackable> quackers = new ArrayList<>();
	
	public void add(Quackable quacker) {
		quackers.add(quacker);
	}
	
	public void quack() {
		Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
        }
	}

}
