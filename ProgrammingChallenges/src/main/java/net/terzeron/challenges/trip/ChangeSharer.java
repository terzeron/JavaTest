package net.terzeron.challenges.trip;

public class ChangeSharer {
	public static double getAverage(double[] values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i] * 100;
		}
		return (double) sum / values.length;
	}
	
	public static double getChange(double[] costs, double average) {
		double change = 0.0;
		int diff = 0;
		for (int i = 0; i < costs.length; i++) { 
			diff = (int) (costs[i] * 100 - average);
			if (diff < 0) {
				change += (double) -diff;
			}
		}
		return change / 100.0;
	}
	
	public static void main(String[] args) {
		double average = 0.0;
		double costs[] = { 15.00, 15.01, 3.00, 3.01 };
		//double costs[] = { 10.00, 20.00, 30.00 };
		
		average = getAverage(costs);
		
		//Double change = new Double(getChange(costs, average));
		//System.out.println(String.format("$%.2f", new Double[] { change } ));
		System.out.println(String.format("$%.2f", getChange(costs, average)));
	}
}
