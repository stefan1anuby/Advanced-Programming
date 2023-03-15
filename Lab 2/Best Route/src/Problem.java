import java.util.HashSet;

public class Problem {

	private HashSet <Location> locationSet = new HashSet <Location>();
	private HashSet <Road> roadSet = new HashSet <Road>();

	public void addLocation(Location location){
		if(locationSet.contains(location)){
			System.out.println("The location is already in the problem");
		}
		else {
			locationSet.add(location);
		}
	}

	public void addRoad(Road road){
		if(roadSet.contains(road)){
			System.out.println("The road is already in the problem");
		}
		else {
			roadSet.add(road);
		}
	}

	public HashSet<Location> getLocationSet(){
		return locationSet;
	}

	public HashSet<Road> getRoadSet(){
		return roadSet;
	}

	public boolean checkIfProblemIsValid(){
		for(Road road : roadSet){

			Location a = road.getA();
			Location b = road.getB();

			if(locationSet.contains(a) == false || locationSet.contains(b) == false){

				System.out.println("The problem is NOT VALID");
				return false;
			}
		}
		System.out.println("The problem is VALID <3");
		return true;
	}
}
