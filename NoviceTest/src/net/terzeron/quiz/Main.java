package net.terzeron.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String[] tokenList = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            tokenList = input.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 다음 테스트 출력 코드를 uncomment하여 확인 가능함
        for (String token : tokenList) { System.out.println(token); }

        if (tokenList != null) {
            // write your code here

        }

    }
}
