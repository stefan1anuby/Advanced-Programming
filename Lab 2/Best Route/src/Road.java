public abstract class Road {
	protected String name;
	protected Integer length,speedLimit;
	protected RoadType type;
	protected Location a,b;

	/*
	 
	public Road(String name, RoadType type, Location a, Location b){
		this.name =  name;
		this.type = type;
		this.a = a;
		this.b = b;
	}
	*/

	public void setName(String newName) {
		this.name = newName;
	}

	public void setA(Location newA){
		this.a = newA;
	}

	public void setB(Location newB){
		this.b = newB;
	}

	public void setSpeedLimit(Integer newSpeedLimit){
		this.speedLimit = newSpeedLimit;
	}

	public String getName(){
		return this.name;
	}

	public Integer getLength(){
		return this.length;
	}

	public Integer getSpeedLimit(){
		return this.speedLimit;
	}

	public Location getA(){
		return this.a;
	}

	public Location getB(){
		return this.b;
	}

	public RoadType getType(){
		return this.type;
	}

	public String toString(){
		return "type : " + type + " name : " + name + " lenght : " +  length + " speedLimit : " + speedLimit + ", a.name : " + a.getName() + ", b.name : " + b.getName();
	}

}
