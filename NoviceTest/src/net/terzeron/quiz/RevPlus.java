package net.terzeron.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RevPlus {
    public static void main(String[] args) {
        int a = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            a = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write your code here


        for (int i = 0; i < 10; i++) {
            int b = reverse(a);
            System.out.println("a=" + a + ", b=" + b);
            a = a + b;
            if (isPalindrome(a)) {
                System.out.println(a);
                System.exit(0);
            }
        }
    }

    private static int reverse(int a) {
        int result = 0;
        while (a > 0) {
            result = result * 10 + (a % 10);
            a /= 10;
        }
        return result;
    }

    private static boolean isPalindrome(int a) {
        int b = reverse(a);
        return (a == b);
    }
}
