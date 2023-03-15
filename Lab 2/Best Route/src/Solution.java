import java.util.ArrayList;
import java.util.List;

public class Solution {
	List <Road> Edges;

	Solution(List <Road> Path){
		Edges = new ArrayList<Road>(Path);
	}

	@Override
    public String toString()
    {
		StringBuilder output = new StringBuilder();
		Integer cost = 0;
		for(Road road : Edges){
			output.append(road.getA().getName() + " -> " + road.getB().getName() + "\n");
			cost += road.getLength();
		}
		output.append("The cost is : " + Integer.toString(cost));
        return output.toString();
    }
}
