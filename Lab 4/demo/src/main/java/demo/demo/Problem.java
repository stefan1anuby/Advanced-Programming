package demo.demo;


import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;

public class Problem {
	private Map<Student, Set<Project>> studentPreferences;
    private Map<Project, Student> projectAssignments;

	public Problem(Map<Student, Set<Project>> studentPreferences) {
        this.studentPreferences = studentPreferences;
        this.projectAssignments = new HashMap<Project, Student>();
    }

    public void solve(){
        for(Student student : studentPreferences.keySet()){
            Set <Project> projects = studentPreferences.get(student);
            for(Project project : projects){
                if(!projectAssignments.containsKey(project)){
                    projectAssignments.put(project,student);
                    break;
                }
            }
        }
    }

    public Map<Project,Student> getProjAssignments(){
        return projectAssignments;
    }
    
    public void printStudentsHavingLowerThanAveragePreferences(){
        double average = studentPreferences.values()
                                                    .stream()
                                                    .mapToInt(projects -> projects.size())
                                                    .average()
                                                    .orElse(-1);


        studentPreferences.entrySet().stream()
                .filter(e -> e.getValue().size() < average)
                .map(Map.Entry::getKey)
                .forEach(e -> System.out.println(e.name));

    }
}



