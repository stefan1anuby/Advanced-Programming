package demo.demo;

public class Student implements Comparable<Student> {
	
	String name;

	Student(String Name){
		this.name = Name;
	}

	@Override
	public int compareTo(Student stud) {
		return this.name.compareTo(stud.name);
	}
}
