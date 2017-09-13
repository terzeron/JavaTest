package net.terzeron.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Coordinate {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            String[] numStrList = input.split(" ");
            for (String numStr : numStrList) {
                numberList.add(Integer.parseInt(numStr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 다음과 같은 방식으로 numberList와 number 변수를 사용할 수 있음
        for (Integer number : numberList) {
            System.out.println("number=" + number);
        }
        System.out.println(numberList.get(0) + numberList.get(2));

        // write your code here


        Collections.sort(numberList);
        for (Integer number : numberList) {
            System.out.println(number);
        }
        ArrayList<Integer> intervalList = new ArrayList<Integer>();
        for (int i = 1; i < numberList.size(); i++) {
            intervalList.add(numberList.get(i) - numberList.get(i - 1));
            System.out.println(numberList.get(i) - numberList.get(i - 1));
        }
        int minIndex = 0;
        Integer min = intervalList.get(0);
        for (int i = 0; i < intervalList.size(); i++) {
            if (min > intervalList.get(i)) {
                min = intervalList.get(i);
                minIndex = i;
            }
        }
        System.out.println("minIndex=" + minIndex);
        System.out.println(intervalList.get(minIndex));
        System.out.println("(" + numberList.get(minIndex) + "," + numberList.get(minIndex + 1) + ")");
    }
}
