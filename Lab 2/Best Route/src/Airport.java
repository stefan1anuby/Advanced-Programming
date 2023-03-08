public class Airport extends Location{
	public Airport(String locName , Integer locX, Integer locY){
		this.name =  locName;
		this.type = LocationType.AIRPORT;
		this.x = locX;
		this.y = locY;
	}
}
