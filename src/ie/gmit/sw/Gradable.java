package ie.gmit.sw;

import java.util.List;

public interface Gradable {
	
	public abstract double calcGrade(String module, double grade, double percentage);
	public abstract void displayResults(List<Double> resultStore, String module);
	public abstract int gatherData();
	public abstract String enterModule();
	public abstract double enterScores();
	public abstract int enterChoices();
}