public class Country extends Road {
	public Country(String name, Location a, Location b , Integer length , Integer speedLimit){
		this.name =  name;
		this.type = RoadType.COUNTRY;
		this.a = a;
		this.b = b;
		this.length = length;
		this.speedLimit = speedLimit;
	}
}
