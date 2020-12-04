
public class University {
	private String name;
	private Student[] students;
	private int nbStu;
	
	public University(String name, int size) {
		this.name = name;
		this.students = new Student[size];
	}
	
	public int search(Student s) {
		for(int i = 0; i < nbStu; i++) {
			if(students[i].getId() == s.getId()) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean addStudent(Student s) {
		if(nbStu >= students.length) {
			return false;
		}
		// I can also use search(); method here
		for(int i = 0; i < nbStu; i++) {
			if(students[i].equals(s)) {
				return false;
			}
		}
		if(s instanceof Graduate) {
			students[nbStu++] = new Graduate((Graduate) s);
		} else if (s instanceof UnderGrad){
			students[nbStu++] = new UnderGrad((UnderGrad) s);
		} else {
			// Now, we only have 2 subclasses of s (Student) but to make sure that addStudent(); returns true correctly, and false if we add another subclasses later... 
			return false;
		}
		return true;
	}
	
	public boolean removeStudent(Student s) {
		for(int i = 0; i < nbStu; i++) {
			if(students[i].equals(s)) {
				students[i] = null;
				students[i] = students[nbStu - 1];
				students[nbStu - 1] = null;
				nbStu--;
				return true;
			}
		}
		return false;
	}
	
	public Student getMaxGPA() {
		int indexOfMax = 0;
		for(int i = 0; i < nbStu; i++) {
			if(students[indexOfMax].calcGPA() < students[i].calcGPA()) {
				indexOfMax = i;
			}
		}
		return students[indexOfMax];
	}
	
	public int getNumberOfGrad() {
		int nbOfGraduate = 0;
		for(int i = 0; i < nbStu; i++) {
			if(students[i] instanceof Graduate) {
				nbOfGraduate++;
			}
		}
		return nbOfGraduate;
	}
	
	public void splitStudnet(Graduate[] grad, UnderGrad[] underGrad) {
		int nbGrad = 0;
		int nbUnderGrad = 0;
		for(int i = 0; i < nbStu; i++) {
			if(students[i] instanceof Graduate) {
				grad[nbGrad++] = new Graduate((Graduate) students[i]);
			} else if(students[i] instanceof UnderGrad) {
				underGrad[nbUnderGrad++] = new UnderGrad ((UnderGrad) students[i]);
			}
		}
	}
	
	public Student[] getStudents(int hours) {
		// Size of an array that just contains Graduates
		int size = 0;
		for(int i = 0; i < nbStu; i++) {
			if(students[i] instanceof Graduate) {
				size++;
			}
		}
		
		// Array that just contains Graduates
		Student[] temp = new Graduate[size];
		int index = 0;
		
		// fill (temp) array
		for(int i = 0; i < nbStu; i++) {
			if(students[i] instanceof Graduate) {
				temp[index++] = new Graduate((Graduate) students[i]);
			}
		}
		
		// Now, we are sure that (temp) contains all the (Graduate) in students[nbStu]
		// Next, will take exact size of what we need, no empty space in the array
		int finalSizeToAvoidEmptyArr = 0;
		for(int i = 0; i < size; i++) {
			if( ((Graduate) temp[i]).getReasearchHours() > hours) {
				finalSizeToAvoidEmptyArr++;
				}
		}

		// Final array
		Student[] grad = new Graduate[finalSizeToAvoidEmptyArr];
		int nbGrad = 0;
		
		// fill (grad) array
		for(int i = 0; i < size; i++) {
			if( ((Graduate)temp[i]).getReasearchHours() > hours) {
				grad[nbGrad++] = temp[i];
			}
		}
		
		return grad;
	}
}
