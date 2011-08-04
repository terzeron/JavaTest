/**
 * 
 */
package net.terzeron.pattern.templatemethod2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author terzeron
 *
 */
public class TeaWithHook extends CaffeineBeverageWithHook {
	public void brew() {
		System.out.println("steeping tea bag...");
	}
	
	public void addCondiments() {
		System.out.println("adding lemon...");
	}
	
	public boolean customerWantsCondiments() {
		String answer = getUserInput();
		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getUserInput() {
		String answer = null;
		System.out.println("Do you want lemon in tea? (y/N) ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		} catch (IOException e) {
			System.err.println("IO error");
		}
		if (answer == null) {
			return "no";
		}
		return answer;
	}
}
