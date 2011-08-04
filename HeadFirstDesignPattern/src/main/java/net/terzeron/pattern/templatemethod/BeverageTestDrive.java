/**
 * 
 */
package net.terzeron.pattern.templatemethod;

/**
 * @author terzeron
 *
 */
public class BeverageTestDrive {
	public static void main(String[] args) {
		Tea teaHook = new Tea();
		Coffee coffeeHook = new Coffee();
		
		System.out.println("preparing tea...");
		teaHook.prepareRecipe();
		
		System.out.println("preparing coffee...");
		coffeeHook.prepareRecipe();
	}
}
