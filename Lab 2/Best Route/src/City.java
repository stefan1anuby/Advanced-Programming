public class City extends Location{
	public City(String locName , Integer locX, Integer locY){
		this.name =  locName;
		this.type = LocationType.CITY;
		this.x = locX;
		this.y = locY;
	}
}
