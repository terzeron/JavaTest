package net.terzeron.pattern.command;

public class RemoteControlTest {
	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light("Kitchen");
		GarageDoor garageDoor = new GarageDoor("");
		LightOnCommand lightOn = new LightOnCommand(light);
		GarageDoorUpCommand garageDoorOpenCommand = new GarageDoorUpCommand(garageDoor);
		
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		remote.setCommand(garageDoorOpenCommand);
		remote.buttonWasPressed();
	}
}
