package demo.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Faker faker = new Faker();

        Student[] students = IntStream.rangeClosed(0, 3)
                                .mapToObj(i -> new Student(i + " S " + faker.funnyName().name()) )
                                .toArray(Student[]::new);

        Arrays.sort(students);

        Project[] projects = IntStream.rangeClosed(0, 3)
                                .mapToObj(i -> new Project(i + " P " + faker.name().fullName()) )
                                .toArray(Project[]::new);


        Map<Student, Set<Project>> studentPreferences = new HashMap<Student, Set<Project>>();

        studentPreferences.put(students[0], Set.of(projects));
        studentPreferences.put(students[1], Set.of(projects[0],projects[1]));
        studentPreferences.put(students[2], Set.of(projects[3],projects[2]));
        studentPreferences.put(students[3], Set.of(projects[3]));

        Problem problem = new Problem(studentPreferences);
        problem.printStudentsHavingLowerThanAveragePreferences();
        problem.solve();
        problem.getProjAssignments().forEach((k,v) -> System.out.println("Key = " + k.name + ", Value = " + v.name));
                                    
    }
}
