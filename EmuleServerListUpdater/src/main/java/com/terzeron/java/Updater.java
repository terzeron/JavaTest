package com.terzeron.java;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class Updater {
	public Updater() {
	}

	public void launchBrowser(String urlStr) {
		com.terzeron.java.BrowserControl.displayURL(urlStr);
	}
	
	public void keyPressAndRelease(Robot robot, int keycode) {
		robot.keyPress(keycode);
		robot.keyRelease(keycode);
	}
	
	public void makeRobot() {
		Robot robot = null;
		
		try {
			robot = new Robot();
			robot.delay(10000);
			
			// Ctrl + F
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_F);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_F);

			int keycodes[] = { KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_D, KeyEvent.VK_SPACE, 
					KeyEvent.VK_T, KeyEvent.VK_O, KeyEvent.VK_SPACE, KeyEvent.VK_E, 
					KeyEvent.VK_M, KeyEvent.VK_U, KeyEvent.VK_L, KeyEvent.VK_E, 
					KeyEvent.VK_ENTER, KeyEvent.VK_ENTER, KeyEvent.VK_ESCAPE, KeyEvent.VK_ENTER };
			for (int i = 0; i < keycodes.length; i++) {
				keyPressAndRelease(robot, keycodes[i]);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) {
		Updater updater = new Updater();
		String urlStr = "http://ed2k.2x4u.de/index.html";

		updater.launchBrowser(urlStr);	
		updater.makeRobot();
	}
}
