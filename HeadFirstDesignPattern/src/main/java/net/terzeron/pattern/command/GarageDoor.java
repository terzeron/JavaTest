package net.terzeron.pattern.command;

public class GarageDoor {
	private String location = "";
	
	public GarageDoor(String location) {
		this.location = location;		
	}
	
	public void up() {
		System.out.println(location + ": The garage door is open.");
	}
	
	public void down() {
		System.out.println(location + ": The garage door is closed.");
	}
	
	public void stop() {
		System.out.println(location + ": The garage door is stopped.");
	}
	
	public void lightOn() {
		System.out.println(location + ": The light of garage door is turned on.");
	}
	
	public void lightOff() {
		System.out.println(location + ": The light of garage door is turned off.");
	}
	
}
