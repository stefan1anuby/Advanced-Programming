import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable<Person> {

	private String name;

	Map<Node, String> relationships = new HashMap<>();

	public void addRelationship(Node node, String value) {
 		relationships.put(node, value);
	} 

	public Person(String name){
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Person other) {
		return this.name.compareTo(other.name);
	}

	@Override
	public int getConnectionNumber() {
		return relationships.size();
	}

	@Override
	public void print() {
		System.out.println(this.name);
		relationships.forEach(
            (key, value)
                -> System.out.println(key.getName() + " : " + value));
	}
}
