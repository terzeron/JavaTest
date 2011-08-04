/**
 * 
 */
package net.terzeron.pattern.templatemethod;

/**
 * @author terzeron
 *
 */
public class Coffee extends CaffeineBeverage {
	public void brew() {
		System.out.println("brewing coffee grinds...");
	}
	
	public void addCondiments() {
		System.out.println("adding sugar and milk...");
	}
}
