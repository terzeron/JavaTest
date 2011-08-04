/**
 * 
 */
package net.terzeron.pattern.facade;

/**
 * @author terzeron
 *
 */
public class Tuner {
	String description;
	Amplifier amp;
	double frequency;
	
	public Tuner(String description, Amplifier amp) {
		this.description = description;
		this.amp = amp;
	}
	
	public void setOn() {
		System.out.println(description + " on");
	}
	
	public void setOff() {
		System.out.println(description + " off");
	}
	
	public void setAm() {
		System.out.println(description + " setting AM mode");
	}
	
	public void setFm() {
		System.out.println(description + " setting FM mode");
	}
	
	public void setFrequency(double frequency) {
		System.out.println(description + " setting frequency to " + frequency);
		this.frequency = frequency;
	}
	
	public String toString() {
		return description;
	}
}
