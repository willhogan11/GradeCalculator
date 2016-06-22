package ie.gmit.sw;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GradeCalculator {

	public static void main(String[] args) {
		gatherDataMenu();
	}
	
	public static void displayResults(List<Double> resultStore, String module){
		double sum = 0;
		for (Double d : resultStore) {
			System.out.println("Score for section: " + d + "%");
			sum = sum + d;
		}
		System.out.println("\nTotal percentage for Module " + module + " = " + Math.round(sum) + "%");
	}
	
	
	public static double calcGrade(String module, double grade, double percentage){
		double result = grade * percentage / 100;
		System.out.println("Result for module " + module + " is " + result + "% / " + percentage + "%");
		return result;
	}
	
	public static int ScannerChoices(int choices){
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter 1 to Enter data, 2 to Exit");
		choices = scan.nextInt();
		return choices;
		// scan.close();
	}
	
	public static String ScannerModule(String module){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your module title: ");
		module = scan.next();
		scan.nextLine();
		return module;
		// scan.close();
	}
	
	public static double ScannerScores(double scores){
		Scanner scan = new Scanner(System.in);
		scores = scan.nextDouble();
		return scores;
		// scan.close();
	}
	
	public static int gatherDataMenu() {
		int choice = 0, subChoice = 0;
		String module = null;		
		double grade = 0, percentage = 0;		
		List<Double> resultStore = new ArrayList<Double>();
		
		do{
			choice = ScannerChoices(choice);
			
			switch(choice){
				case 1: {
					module = ScannerModule(module);
					
					do{
						System.out.println("Press 1 to enter grades\nPress 2 to exit");
						subChoice = ScannerChoices(subChoice);
						
						switch(subChoice){
							case 1 : {
								System.out.println("Enter your Grade: ");
								grade = ScannerScores(grade);
								System.out.println("Enter your percentage of the module");
								percentage = ScannerScores(percentage);
								resultStore.add(calcGrade(module, grade, percentage));
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
					}while(subChoice != 2);
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
		}while(choice < 2);
		
		displayResults(resultStore, module);
		
		return choice;
	}
}
