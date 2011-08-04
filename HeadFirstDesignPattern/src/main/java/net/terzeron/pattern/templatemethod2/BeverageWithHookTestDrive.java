/**
 * 
 */
package net.terzeron.pattern.templatemethod2;

/**
 * @author terzeron
 *
 */
public class BeverageWithHookTestDrive {
	public static void main(String[] args) {
		TeaWithHook teaHook = new TeaWithHook();
		CoffeeWithHook coffeeHook = new CoffeeWithHook();
		
		System.out.println("preparing tea...");
		teaHook.prepareRecipe();
		
		System.out.println("preparing coffee...");
		coffeeHook.prepareRecipe();
	}
}
