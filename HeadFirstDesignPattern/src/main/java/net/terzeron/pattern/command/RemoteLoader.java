package net.terzeron.pattern.command;


public class RemoteLoader {
	public static void main(String[] args) {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("Garage");
		Stereo stereo = new Stereo("Living Room");
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		 
		CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
		
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
		remoteControl.setCommand(3, stereoOnWithCD, stereoOff);
		remoteControl.setCommand(4, garageDoorUp, garageDoorDown);
		
		System.out.println(remoteControl);
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
		
		
		System.out.println("\n#############################################################\n");
		
		
		RemoteControlWithUndo remoteControl2 = new RemoteControlWithUndo();
		CeilingFan ceilingFan2 = new CeilingFan("Bed Room");
		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan2);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan2);
		CeilingFanOffCommand ceilingFanOff2 = new CeilingFanOffCommand(ceilingFan2);
		
		remoteControl2.setCommand(0, ceilingFanMedium, ceilingFanOff2);
		remoteControl2.setCommand(1, ceilingFanHigh, ceilingFanOff2);
		remoteControl2.onButtonWasPushed(0);
		remoteControl2.offButtonWasPushed(0);
		System.out.println(remoteControl2);
		remoteControl2.undoButtonWasPushed();
		remoteControl2.onButtonWasPushed(1);
		System.out.println(remoteControl2);
		remoteControl2.undoButtonWasPushed();
	}
}
