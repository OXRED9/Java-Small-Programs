
public class UnderGrad extends Student {
	
	public UnderGrad(int id, String name, int size) {
		super(id, name, size);
	}
	
	public UnderGrad(UnderGrad Ug) {
		super(Ug);
	}
	
	public double calcGPA() {
		// GPA
		return super.getAverage() == -1 ? -1 : super.getAverage() / 20;
	}
}
