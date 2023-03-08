public abstract class Location {
	protected String name;
	protected Integer x,y;
	protected LocationType type;

	/*
	public Location(String locName, LocationType type , Integer locX, Integer locY){
		this.name =  locName;
		this.type = type;
		this.x = locX;
		this.y = locY;
	}
	*/
	
	public void setName(String newName) {
		this.name = newName;
	}

	public void setX(Integer newX){
		this.x = newX;
	}

	public void setY(Integer newY){
		this.y = newY;
	}

	public String getName(){
		return this.name;
	}

	public Integer getX(){
		return this.x;
	}

	public Integer getY(){
		return this.y;
	}

	public LocationType getType(){
		return this.type;
	}

	public String toString(){
		return "type : " + type + ", name : " + name + ", x : " +  x + ", y : " + y;
	}
}
