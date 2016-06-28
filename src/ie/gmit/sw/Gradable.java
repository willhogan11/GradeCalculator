package ie.gmit.sw;

import java.util.List;

public interface Gradable {
	
	public abstract double calcGrade(String module, double grade, double percentage);
	public abstract void displayResults(List<Double> resultStore, String module);
	public abstract int gatherData();
	
}