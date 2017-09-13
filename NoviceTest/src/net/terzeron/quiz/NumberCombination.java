package net.terzeron.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class NumberCombination {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = br.readLine();

                String[] numberList = input.split(" ");
                Arrays.sort(numberList, myComparator);
                for (String number : numberList) {
                    System.out.println(number);
                }
/*                Integer max = Integer.parseInt(String.join("", numberList));
                Collections.reverse(Arrays.asList(numberList));
                for (String number : numberList) {
                    System.out.println(number);
                }
                Integer min = Integer.parseInt(String.join("", numberList));

                System.out.println(max);
                System.out.println(min);*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Comparator<String> myComparator = new Comparator<String>() {
        public int compare(String s1, String s2) {
            String str1 = new String(s1);
            String str2 = new String(s2);
            if (str1.charAt(0) > str2.charAt(0)) {
                System.out.println(str1 + " > " + str2);
                return -1;
            } else if (str1.charAt(0) < str2.charAt(0)) {
                System.out.println(str1 + " < " + str2);
                return 1;
            } else {
                // 같은 위치에 같은 숫자를 가질 때
                int i = 0;
                while (str1.length() > 0 || str2.length() > 0) {

                    if (str1.length() > 1) {
                        System.out.println(str1 + " ==> " + str1.substring(1));
                        str1 = str1.substring(1);
                    }
                    if (str2.length() > 1) {
                        System.out.println(str2 + " ==> " + str2.substring(1));
                        str2 = str2.substring(1);
                    }
                    i++;

                    if (str1.charAt(0) > str2.charAt(0)) {
                        System.out.println(str1 + " > " + str2);
                        return -1;
                    } else if (str1.charAt(0) < str2.charAt(0)) {
                        System.out.println(str1 + " < " + str2);
                        return 1;

                    }
                }
            }

            return 0;
        }
    };
}
