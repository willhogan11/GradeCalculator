package ie.gmit.sw;

import java.util.List;
import java.util.Scanner;

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
	
	public int ScannerChoices() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter 1 to Enter data, 2 to Exit");
		int choices = scan.nextInt();
		return choices;
	}
	
	public String ScannerModule() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your module title: ");
		String module = scan.next();
		scan.nextLine();
		return module;
	}
	
	public double ScannerScores() {
		Scanner scan = new Scanner(System.in);
		double scores = scan.nextDouble();
		return scores;
	}

	public int gatherData() {
		
		Grade grade = new Grade();
		
		do{
			grade.setChoices(ScannerChoices()); 
			
			switch(grade.getChoices()){
				case 1: {
					
					
					do{
						System.out.println("Press 1 to enter grades\nPress 2 to exit");
						grade.setSubChoices(ScannerChoices());
						
						switch(grade.getSubChoices()){
							case 1 : {
								System.out.println("Enter your Grade: ");
								grade.setGrades(ScannerScores());// grade = ScannerScores(grade);
								System.out.println("Enter your percentage of the module");
								grade.setPercentage(ScannerScores()); // percentage = ScannerScores(percentage);
								// grade.setResultStore(calcGrade(grade.getModule(), grade.getGrades(), grade.getPercentage())); //resultStore.add(calcGrade(module, grade, percentage));
								calcGrade(grade.getModule(), grade.getGrades(), grade.getPercentage());
								break;
							}
							case 2 : {
								System.out.println("Returning to Overview...");
								break;
							}
							default:{
								System.out.println("Enter a valid grade...");
								break;
							}
						}
					}while(grade.getSubChoices() != 2);
				}
				case 2:{
					System.out.println("Exiting...");
					break;
				}
				default:{
					System.out.println("Enter a valid value");
					break;
				}
			}
		}while(grade.getChoices() < 2);
		
		displayResults(grade.getResultStore(), grade.getModule());
		
		return grade.getChoices();
	}
}