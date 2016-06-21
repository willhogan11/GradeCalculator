import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class TestClass {

	public static void main(String[] args) {

		String module = "";
		double grade, percentage;		
		Scanner scan = new Scanner(System.in);
		List<Double> resultStore = new ArrayList<Double>();
		
		do{
			if(module.equals("exit")){
				System.out.println("Exiting...");
				System.exit(0);
			}else{
				System.out.println("Enter your module title: ");
				module = scan.next();
				System.out.println("Enter your Grade: ");
				grade = scan.nextDouble();
				System.out.println("Enter your percentage of the module");
				percentage = scan.nextDouble();
				resultStore.add(calcGrade(module, grade, percentage));
			}
		}while(!module.equals("exit"));
		
		scan.close();
		
		for (Double d : resultStore) {
			System.out.println(d);
		}
	}
	
	public static double calcGrade(String module, double grade, double percentage){
		double result = grade * percentage / 100;
		System.out.println("Result for module " + module + " is " + result + "% / " + percentage + "%");
		return result;
	}
	
/*	public static void storeResult(double result){
		List<Double> resultStore = new ArrayList<Double>();
		resultStore.add(result);
		for (Double d : resultStore) {
			System.out.println(d);
		}
	}*/
}
