/**
 * 
 */
package net.terzeron.pattern.templatemethod3;

/**
 * @author terzeron
 *
 */
public class Duck implements Comparable<Duck> {
	String name;
	int weight;
	
	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String toString() {
		return name + ", " + weight + "kg";
	}
	
	public int compareTo(Duck otherDuck) {
		if (this.weight < otherDuck.weight) {
			return -1;
		} else if (this.weight > otherDuck.weight) {
			return 1;
		} else {
			return 0;
		}
	}
}
