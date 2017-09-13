package net.terzeron.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CharacterSequence {
    public static void main(String[] args) {
        String[] words = null;
        ArrayList<String> consonantList = new ArrayList<String>();
        ArrayList<String> vowelList = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");
        } catch (IOException e) {

        }
        System.out.println(words[0]);
        for (String word : words) {
            if (check3ConsonantSeq(word)) {
                consonantList.add(word);
            }
            if (check2VowelSeq(word)) {
                vowelList.add(word);
            }
        }

        System.out.println(vowelList.size());
        System.out.println(consonantList.size());
    }

    static boolean check3ConsonantSeq(String word) {
        boolean result = false;
        int seqCount = 0;
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    seqCount = 0;
                    break;
                default:
                    seqCount++;
                    if (seqCount == 3) {
                        return true;
                    }
                    break;
            }
        }
        return result;
    }

    static boolean check2VowelSeq(String word) {
        boolean result = false;
        int seqCount = 0;
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    seqCount++;
                    if (seqCount == 2) {
                        return true;
                    }
                    break;
                default:
                    seqCount = 0;
                    break;
            }
        }
        return result;
    }
}
