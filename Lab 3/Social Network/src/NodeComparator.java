import java.util.Comparator;

public class NodeComparator  implements Comparator<Node> {

	@Override
	public int compare(Node n1, Node n2) {
		int x = n1.getConnectionNumber();
		int y = n2.getConnectionNumber();

		if(x == y)
			return 0;
		else if(x > y)
			return 1;
		return -1;
		
	}

}
