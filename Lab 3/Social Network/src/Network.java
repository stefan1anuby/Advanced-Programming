import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Network {
	private List<Node> nodes = new ArrayList<>();

	public void addNode(Node node) {
		nodes.add(node);
	}

	public void print(){
		Collections.sort(nodes, new NodeComparator());

		for(Node node : nodes ){
			node.print();
		}
	}

}
