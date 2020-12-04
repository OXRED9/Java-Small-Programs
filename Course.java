
public class Course {
	private String name;
	private double grade;
	
	public Course(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public Course(Course course) {
		this.name = course.name;
		this.grade = course.grade;
	}
	
	public String getName() {
		return name;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public String toString() {
		return "name: " + grade;
	}
}
