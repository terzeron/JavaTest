package net.terzeron.design_pattern;

import sun.awt.CausedFocusEvent;

public class Main {

    public static void main(String[] args) {

        CaffeineBeverage cb1 = new Coffee();
        cb1.prepareRecipe();

        CaffeineBeverage cb2 = new Tea();
        cb2.prepareRecipe();
    }
}
