package com.terzeron.powermockito;

public class CollaboratorWithStaticMethods {
    public static String firstMethod(String name) {
        return "hello " + name + " !";
    }

    public static String secondMethod() {
        return "hello no one!";
    }

    public static String thirdMethod() {
        return "hello no one again!";
    }
}
