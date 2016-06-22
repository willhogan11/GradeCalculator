package ie.gmit.sw;

public interface Gradable {

	public abstract double calculateGrade(String module, double grade, double percentage);
	public abstract void options();
	public abstract void result();
	public abstract void percentage();
	public abstract void grade();
	public abstract void listResult();
	
}