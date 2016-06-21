import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GradeCalculator {

	public static void main(String[] args) {
		gatherDataMenu();
	}
	
	public static void displayResults(List<Double> resultStore){
		double sum = 0;
		for (Double d : resultStore) {
			System.out.println("Score : " + d);
			sum = sum + d;
		}
		System.out.println("Total for module : " + sum + "%");
	}
	
	
	public static double calcGrade(String module, double grade, double percentage){
		double result = grade * percentage / 100;
		System.out.println("Result for module " + module + " is " + result + "% / " + percentage + "%");
		return result;
	}
	
	
	public static int gatherDataMenu(){
		int choice;
		String module;		
		double grade, percentage;		
		List<Double> resultStore = new ArrayList<Double>();
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.println("\nEnter 1 to Enter data, 2 to Exit");
			choice = scan.nextInt();
			
			switch(choice){
				case 1: {
					System.out.println("Enter your module title: ");
					module = scan.nextLine();
					scan.nextLine();
					System.out.println("Enter your Grade: ");
					grade = scan.nextDouble();
					System.out.println("Enter your percentage of the module");
					percentage = scan.nextDouble();
					resultStore.add(calcGrade(module, grade, percentage));
					break;
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
		scan.close();
		
		displayResults(resultStore);
		
		return choice;
	}
}
