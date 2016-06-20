import java.util.Scanner;


public class TestClass {

	public static void main(String[] args) {

		String module = "";
		double grade, percentage;		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your module title: ");
		module = scan.nextLine();
		System.out.println("Enter your Grade: ");
		grade = scan.nextDouble();
		System.out.println("Enter your percentage of the module");
		percentage = scan.nextDouble();
		
		calcGrade(module, grade, percentage);
		
		scan.close();
	}
	
	public static double calcGrade(String module, double grade, double percentage){
		double result = grade * percentage / 100;
		System.out.println("Result for module " + module + " is " + result + "% / " + percentage + "%");
		return result;
	}
}