
public class Graduate extends Student{
	private int researchHours;
	
	public Graduate(int id, String name, int size, int researchHours) {
		super(id, name, size);
		this.researchHours = researchHours;
	}
	
	public Graduate(Graduate g) {
		super(g);
		// Note that super does not contain researchHours
		this.researchHours = g.researchHours;
	}
	
	public int getReasearchHours() {
		return researchHours;
	}
	
	public double calcGPA() {
		// GPA
		return super.getAverage() == -1 ? -1 : super.getAverage() / 25 + researchHours * 0.05;
	}
	
	public String toString() {
		return super.toString() + ", Reaserch hours completed: " + researchHours;
	}
}
