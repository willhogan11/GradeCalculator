package ie.gmit.sw;

import java.util.Scanner;

public class ScanImpl implements Scannable{

	public int ScannerChoices(int choices) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter 1 to Enter data, 2 to Exit");
		choices = scan.nextInt();
		return choices;
	}

	public String ScannerModule(String module) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your module title: ");
		module = scan.next();
		scan.nextLine();
		return module;
	}

	public double ScannerScores(double scores) {
		Scanner scan = new Scanner(System.in);
		scores = scan.nextDouble();
		return scores;
	}
}
