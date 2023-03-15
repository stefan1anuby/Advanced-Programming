import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends Algorithm{

	Queue<Location> queue = new LinkedList<>();

	public BFS(Problem problem) {
		super(problem);
	}

	@Override
	public Solution solve() {
		
		List<Road> Path = new ArrayList<Road>();
		return new Solution(Path);
	}
	
}
