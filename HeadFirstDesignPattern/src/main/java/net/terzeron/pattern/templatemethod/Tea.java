/**
 * 
 */
package net.terzeron.pattern.templatemethod;

/**
 * @author terzeron
 *
 */
public class Tea extends CaffeineBeverage {
	public void brew() {
		System.out.println("steeping tea bag...");
	}
	
	public void addCondiments() {
		System.out.println("adding lemon...");
	}
}
