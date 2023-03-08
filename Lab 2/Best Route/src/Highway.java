public class Highway extends Road {
	public Highway(String name, Location a, Location b , Integer length , Integer speedLimit){
		this.name =  name;
		this.type = RoadType.HIGHWAY;
		this.a = a;
		this.b = b;
		this.length = length;
		this.speedLimit = speedLimit;
	}
}
