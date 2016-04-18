package net.terzeron.design_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by terzeron on 2016. 1. 20..
 */
public class Coffee extends CaffeineBeverage {
    public void brew() {
        System.out.println("brewing a coffee...");
    }

    public void addCondiments() {
        System.out.println("adding a sugar to the coffee...");
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

        System.out.println("Do you want to add sugar and milk? (y/n) ");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            answer = in.readLine();
        } catch (IOException e) {
            System.out.println("IO error");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}
