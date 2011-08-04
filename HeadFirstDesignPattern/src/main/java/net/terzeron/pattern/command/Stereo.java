package net.terzeron.pattern.command;

public class Stereo {
	private String location = "";
	
	public Stereo(String location) {
		this.location = location;
	}
	
	public void on() {
		System.out.println(location + ": The stereo is on.");
	}
	
	public void off() {
		System.out.println(location + ": The stereo is off.");
	}
	
	public void setCD() {
		
	}
	
	public void setVolume(int volume) {
		
	}
}
