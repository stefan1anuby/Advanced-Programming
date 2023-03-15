import java.util.ArrayList;
import java.util.List;

public class Network {
	private List<Node> nodes = new ArrayList<>();

	public void addNode(Node node) {
		nodes.add(node);
	}

	public String toString(){
		StringBuilder output = new StringBuilder();
		for(Node node : nodes ){
			output.append(node.getName() + " ");
		}
		return output.toString();
	}
}
