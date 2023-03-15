import java.util.HashSet;

public abstract class Algorithm {

	protected HashSet <Location> Nodes;
	protected HashSet <Road> Edges;

	public Algorithm(Problem problem){
		Edges = new HashSet<Road>(problem.getRoadSet());
		Nodes = new HashSet<Location>(problem.getLocationSet());
	}

	public abstract Solution solve();
}
