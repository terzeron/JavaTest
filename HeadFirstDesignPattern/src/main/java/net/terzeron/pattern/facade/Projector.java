/**
 * 
 */
package net.terzeron.pattern.facade;

/**
 * @author terzeron
 *
 */
public class Projector {
	String description;
	DvdPlayer dvd;
	
	public Projector(String description, DvdPlayer dvd) {
		this.description = description;
		this.dvd = dvd;
	}
	
	public void on() {
		System.out.println(description + " on");
	}
	
	public void off() {
		System.out.println(description + " off");
	}
	
	public void tvMode() {
		System.out.println(description + " in tv mode (4x3 aspect ratio)");
	}
	
	public void wideScreenMode() {
		System.out.println(description + " in widescreen mode (16x9 aspect ratio)");
	}
	
	public String toString() {
		return description;
	}
}
