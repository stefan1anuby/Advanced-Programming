public abstract class Road {
	protected String name;
	protected Integer length,speedLimit;
	protected RoadType type;
	protected Location a,b;

	
	/** 
	 * @param newName
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	
	/** 
	 * @param newA
	 */
	public void setA(Location newA){
		this.a = newA;
	}

	
	/** 
	 * @param newB
	 */
	public void setB(Location newB){
		this.b = newB;
	}

	
	/** 
	 * @param newSpeedLimit
	 */
	public void setSpeedLimit(Integer newSpeedLimit){
		this.speedLimit = newSpeedLimit;
	}

	
	/** 
	 * @return String
	 */
	public String getName(){
		return this.name;
	}

	
	/** 
	 * @return Integer
	 */
	public Integer getLength(){
		return this.length;
	}

	
	/** 
	 * @return Integer
	 */
	public Integer getSpeedLimit(){
		return this.speedLimit;
	}

	
	/** 
	 * @return Location
	 */
	public Location getA(){
		return this.a;
	}

	
	/** 
	 * @return Location
	 */
	public Location getB(){
		return this.b;
	}

	
	/** 
	 * @return RoadType
	 */
	public RoadType getType(){
		return this.type;
	}

	
	/** 
	 * @return String
	 */
	public String toString(){
		return "type : " + type + " name : " + name + " lenght : " +  length + " speedLimit : " + speedLimit + ", a.name : " + a.getName() + ", b.name : " + b.getName();
	}

	
	/** 
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Location)) {
			return false;
		}
		Road other = (Road) obj;
		return name.equals(other.name) && length.equals(other.getLength()) && speedLimit.equals(other.getSpeedLimit()) && type.equals(other.getType()) && a.equals(other.getA()) && b.equals(other.getB());
	}

}
