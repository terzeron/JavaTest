package net.terzeron.design_pattern;

import java.rmi.*;

public class GumballMonitor {
	private GumballMachineRemote machine;

	public GumballMonitor(GumballMachineRemote machine) {
		this.machine = machine;
	}

	public void report() {
        try {
            System.out.println("Gumball machine : " + machine.getLocation());
            String gumball = " gumball";
            if (machine.getCount() > 1) {
                gumball += "s";
            }
            System.out.println("Current inventory : " + machine.getCount() + gumball);
            System.out.println("current state : " + machine.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
	}
}
