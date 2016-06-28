package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

public class Grade {
	
	private double grade;
	private double percentage;
	private double result;
	private String module;
	private int choices;
	private int subChoices;
	private double scores;
	private List<Double> resultStore = new ArrayList<Double>();
	
	public double getGrades() {
		return grade;
	}
	public void setGrades(double grades) {
		this.grade = grades;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public int getChoices() {
		return choices;
	}
	public void setChoices(int choices) {
		this.choices = choices;
	}
	public double getScores() {
		return scores;
	}
	public void setScores(double scores) {
		this.scores = scores;
	}
	public int getSubChoices() {
		return subChoices;
	}
	public void setSubChoices(int subChoices) {
		this.subChoices = subChoices;
	}
	public List<Double> getResultStore() {
		return resultStore;
	}
	public void setResultStore(List<Double> resultStore) {
		this.resultStore = resultStore;
	}
}
