package ie.gmit.sw;

import java.util.ArrayList;
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
	
	public int enterChoices() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter 1 to Enter data, 2 to Exit");
		int choices = scan.nextInt();
		return choices;
	}
	
	public String enterModule() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your module title: ");
		String module = scan.next();
		scan.nextLine();
		return module;
	}
	
	public List<Double> results(String module, double grade, double percentage){
		List<Double> resultStore = new ArrayList<Double>();
		resultStore.add(calcGrade(module, grade, percentage));
		return resultStore;
	}
	
	public double enterScores() {
		Scanner scan = new Scanner(System.in);
		double scores = scan.nextDouble();
		return scores;
	}

	public int gatherData() {
		List<Double> resultStore = new ArrayList<Double>();
		Grade grade = new Grade();
		
		do{
			grade.setChoices(enterChoices()); 
			
			switch(grade.getChoices()){
				case 1: {
					grade.setModule(enterModule());
					do{
						System.out.println("Press 1 to enter grades\nPress 2 to exit");
						grade.setSubChoices(enterChoices());
						
						switch(grade.getSubChoices()){
							case 1 : {
								System.out.println("Enter your Grade: ");
								grade.setGrades(enterScores());
								System.out.println("Enter your percentage of the module");
								grade.setPercentage(enterScores());
								resultStore.add(calcGrade(grade.getModule(), grade.getGrades(), grade.getPercentage()));
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
		
		// displayResults(results(grade.getModule(), grade.getGrades(), grade.getPercentage()), grade.getModule());
		displayResults(resultStore, grade.getModule());
		
		return grade.getChoices();
	}
}