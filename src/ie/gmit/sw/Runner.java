package ie.gmit.sw;

public class Runner {

	public static void main(String[] args) {
		Gradable newGrade = new GradeImpl();
		newGrade.gatherData();
	}
}