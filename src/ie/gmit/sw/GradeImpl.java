package ie.gmit.sw;

import java.util.List;

public class GradeImpl implements Gradable{

	public double calcGrade(String module, double grade, double percentage) {
		double result = grade * percentage / 100;
		System.out.println("Result for module " + module + " is " + result + "% / " + percentage + "%");
		return result;
	}

	public void displayResults(List<Double> resultStore, String module) {
		double sum = 0;
		for (Double d : resultStore) {
			System.out.println("Score for section: " + d + "%");
			sum = sum + d;
		}
		System.out.println("\nTotal percentage for Module " + module + " = " + Math.round(sum) + "%");
	}
}