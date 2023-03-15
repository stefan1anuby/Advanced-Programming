public abstract class Location {
	protected String name;
	protected Integer x,y;
	protected LocationType type;
	
	
	/** 
	 * @param newName
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	
	/** 
	 * @param newX
	 */
	public void setX(Integer newX){
		this.x = newX;
	}

	
	/** 
	 * @param newY
	 */
	public void setY(Integer newY){
		this.y = newY;
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
	public Integer getX(){
		return this.x;
	}

	
	/** 
	 * @return Integer
	 */
	public Integer getY(){
		return this.y;
	}

	
	/** 
	 * @return LocationType
	 */
	public LocationType getType(){
		return this.type;
	}

	
	/** 
	 * @return String
	 */
	public String toString(){
		return "type : " + type + ", name : " + name + ", x : " +  x + ", y : " + y;
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
		Location other = (Location) obj;
		return name.equals(other.name) && x.equals(other.getX()) && y.equals(other.getX()) && type.equals(other.getType());
	}
}
