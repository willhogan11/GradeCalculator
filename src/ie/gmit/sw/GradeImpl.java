package ie.gmit.sw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GradeImpl implements Gradable{

	public double calcGrade(String module, double grade, double percentage) {
		double result = grade * percentage / 100;
		System.out.println("\nResult so far for module " + module.toUpperCase() + " is " + result + "% / " + percentage + "%");
		return result;
	}

	public void displayResults(List<Double> resultStore, String module) {
		double sum = 0;
		for (Double d : resultStore) {
			System.out.println("Score for section: " + d + "%");
			sum = sum + d;
		}
		System.out.println("\nTotal percentage for Module " + module + " = " + Math.round(sum) + "%");
		resultStore.clear();
	}
	
	public void displayResults(HashMap<String, Double> hashMapResults) {
		for (String module : hashMapResults.keySet()) {
			System.out.println(module + " " + hashMapResults.get(module));
		}
	}
	
	/*@SuppressWarnings("resource")
	public int enterChoices() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter 1 to Enter data, 2 to Exit");
		int choices = scan.nextInt();
		return choices;
	}
	
	@SuppressWarnings("resource")
	public int enterSubChoices() {
		Scanner scan = new Scanner(System.in);
		int choices = scan.nextInt();
		return choices;
	}
	
	@SuppressWarnings("resource")
	public String enterModule() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter your module title: ");
		String module = scan.next();
		scan.nextLine();
		return module;
	}
	
	@SuppressWarnings("resource")
	public double enterScores() {
		Scanner scan = new Scanner(System.in);
		double scores = scan.nextDouble();
		return scores;
	}
	
	public List<Double> results(String module, double grade, double percentage){
		List<Double> resultStore = new ArrayList<Double>();
		resultStore.add(calcGrade(module, grade, percentage));
		return resultStore;
	}*/

	
	
	public Object input(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("\nEnter 1 to Enter data, 2 to Exit");
		String inputType = in.nextLine();
		
		try {
			if(inputType.matches("\\d+")){
				int i = Integer.valueOf(inputType);
				System.out.println("Integer Entered " + inputType);
				return i;
			}
			else if(inputType.matches("^[a-zA-Z0-9]*$")){
				System.out.println("String entered " + inputType);
				String s = inputType.toString();
				return s;
			}
			else if(inputType.matches("[0-9.]*")){
				double d = Double.valueOf(inputType);
				System.out.println("Double value " + inputType);
				return d;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		in.close();
		return inputType;
	}
	
	
	public int gatherData() {
		List<Double> resultStore = new ArrayList<Double>();
		HashMap<String, Double> hashMapResults = new HashMap<String, Double>();
		Grade grade = new Grade();
		
		do{
			// grade.setChoices(enterChoices()); 
			grade.setChoices((int) input());
			
			switch(grade.getChoices()){
				case 1: {
					
					grade.setModule((String) input());
					
					do{
						System.out.println("\nPress 1 to enter grades\nPress 2 to exit");
						grade.setSubChoices((int) input());
						
						switch(grade.getSubChoices()){
							case 1 : {
								System.out.println("Enter your Partial Grade: ");
								grade.setGrades((double) input());
								System.out.println("Enter your percentage of the module");
								grade.setPercentage((double) input());
								resultStore.add(calcGrade(grade.getModule(), grade.getGrades(), grade.getPercentage()));
								
								double sum = 0;
								for (Double d : resultStore) {
									sum = sum + d;
								}
								hashMapResults.put(grade.getModule(), sum);
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
					resultStore.clear();
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
		
		displayResults(resultStore, grade.getModule());
		// displayResults(hashMapResults);
		
		for (String moduleName : hashMapResults.keySet()) {
			System.out.println(moduleName + " " + hashMapResults.get(moduleName));
		}
		return grade.getChoices();
	}
}