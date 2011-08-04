/**
 * 
 */
package net.terzeron.pattern.facade;

/**
 * @author terzeron
 *
 */
public class HomeTheaterTestDrive {
	public static void main(String[] args) {
		// instantiate components here
		Amplifier amp = new Amplifier("TLine Amplifer");
		Tuner tuner = new Tuner("TLine AM/FM Tuner", amp);
		DvdPlayer dvd = new DvdPlayer("TLine DVD Player", amp);
		CdPlayer cd = new CdPlayer("TLine CD Player", amp);
		Projector projector = new Projector("TLine Projector", dvd);
		Screen screen = new Screen("Theater Screen");
		TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
		PopcornPopper popper = new PopcornPopper("Popcorn Popper");
		
		HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);
		homeTheater.watchMovie("Raiders of the Lost Ark");
		homeTheater.endMovie();
	}
}
