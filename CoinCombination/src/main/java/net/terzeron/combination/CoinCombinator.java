package net.terzeron.combination;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by terzeron on 2017. 9. 1..
 */
public class CoinCombinator {

    Map<Integer, Integer> numbersOfCombinations;

    public CoinCombinator() {
        numbersOfCombinations = new HashMap<Integer, Integer>();
    }

    int getCombinations(int value, int depth) {
        if (value < 10) {
            return 0;
        }
        if (value == 10) {
            return 1;
        }

        if (numbersOfCombinations.containsKey(value)) {
            for (int d = 0; d < depth; d++) {
                System.out.print(" ");
            }
            System.out.println("- value:" + value + " --> count:" + numbersOfCombinations.get(value));
            return numbersOfCombinations.get(value);
        }

        for (int d = 0; d < depth; d++) {
            System.out.print(" ");
        }
        System.out.println("getCombinations(" + value + ")");

        int count;
        int sum = 0;
        for (int i = 1; i <= value / 10; i++) {
            count = getCombinations(value - i * 10, depth + 1);
            numbersOfCombinations.put(value - i * 10, count);
            for (int d = 0; d < depth; d++) {
                System.out.print(" ");
            }
            System.out.println("- value:" + (value - i * 10) + " --> count:" + count);
            sum += count;

            for (int d = 0; d < depth; d++) {
                System.out.print(" ");
            }
            System.out.println("- coin:10x" + i + ", getCombinations(" + (value - i * 10) + "):" + count + " => value:" + value + ", sum=" + sum);
        }

        return sum;
    }

    public static void main(String[] args) {
        CoinCombinator coinCombinator = new CoinCombinator();
        int ret = coinCombinator.getCombinations(40, 0);
        System.out.println(ret);
    }
}
