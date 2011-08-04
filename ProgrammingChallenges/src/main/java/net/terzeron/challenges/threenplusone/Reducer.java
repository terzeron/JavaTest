package net.terzeron.challenges.threenplusone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reducer {
	public void reduce(ReduceResult reduceResult) {
		reduceResult.incrementCount();
		int n = reduceResult.getN();
		
		if (n == 1) {
			return;
		} else if ((n % 2) == 0) {
			reduceResult.setN(n / 2);
		} else {
			reduceResult.setN(3 * n + 1);
		}
		
		reduce(reduceResult);
		return;
	}

	public static int getMaxCycleLength(int i, int j) {
		int max = 0;
		
		for (int k = i; k <= j; k++) {
			Reducer reducer = new Reducer();
			ReduceResult reduceResult = new ReduceResult(k);
			reducer.reduce(reduceResult);
			int result = reduceResult.getCount();
			if (result > max) {
				max = result;
			}
		}
		
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = in.readLine()) != null) {
			String[] tokens = line.split(" ");
			int i = Integer.parseInt(tokens[0]);
			int j = Integer.parseInt(tokens[1]);
			int max = getMaxCycleLength(i, j);
			System.out.println(i + " " + j + " " + max);
		}
	}
}
