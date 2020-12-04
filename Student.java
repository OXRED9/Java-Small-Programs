
public abstract class Student {
	private int id;
	private String name;
	protected Course[] courses;
	protected int nbCourse;
	
	public Student(int id, String name, int size) {
		this.id = id;
		this.name = name;
		this.courses = new Course[size];
	}
	
	public Student(Student s) {
		this.id = s.id;
		this.name = s.name;
		this.courses = new Course[s.courses.length];
		for(int i = 0; i < s.nbCourse; i++) {
			this.courses[i] = new Course(s.courses[i]);
		}
		this.nbCourse = s.nbCourse;
	}
	
	public boolean addCourse(Course c) {
		if(nbCourse >= courses.length) {
			return false;
		}
		courses[nbCourse++] = new Course(c);
		return true;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAverage() {
		double averageAmount = 0;
		int sumOfNumbers = 0;
		for(int i = 0; i < nbCourse; i++) {
			averageAmount += courses[i].getGrade();
			sumOfNumbers++;
		}
		// Note that it is not allowed to divide by 0
		if(sumOfNumbers == 0) {
			return -1;
		}
		return averageAmount / sumOfNumbers;
	}
	
	public abstract double calcGPA();
	
	public String toString() {
		return "ID: " + id + ", Name: " + name;
	}
}
