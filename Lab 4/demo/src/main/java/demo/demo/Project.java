package demo.demo;

public class Project implements Comparable<Project> {
	
	String name;

	Project(String Name){
		this.name = Name;
	}

	@Override
	public int compareTo(Project proj) {
		return this.name.compareTo(proj.name);
	}
}
