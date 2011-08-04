/**
 * 
 */
package net.terzeron.pattern.facade;

/**
 * @author terzeron
 *
 */
public class CdPlayer {
	String description;
	int currentTrack;
	Amplifier amp;
	String title;
	
	public CdPlayer(String description, Amplifier amp) {
		this.description = description;
		this.amp = amp;
	}
	
	public void on() {
		System.out.println(description + " on");
	}
	
	public void off() {
		System.out.println(description + " off");
	}
	
	public void eject() {
		title = null;
		System.out.println(description + " eject");
	}
	
	public void pause() {
		System.out.println(description + " paused \"" + title + "\"");
	}
	
	public void play(String title) {
		this.title = title;
		currentTrack = 0;
		System.out.println(description + " playing \"" + title + "\"");
	}
	
	public void play(int track) {
		if (title == null) {
			System.out.println(description + " can't play track " + currentTrack + ", no cd inserted");
		} else {
			currentTrack = track;
			System.out.println(description + " playing track " + currentTrack);
		}
	}
	
	public void stop() {
		System.out.println(description + " stopped");
	}
	
	public String toString() {
		return description;
	}
}
