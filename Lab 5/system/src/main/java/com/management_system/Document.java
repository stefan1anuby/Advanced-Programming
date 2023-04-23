package com.management_system;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
	private String id;
	private String title;
	private String location;
   
	private Map<String, Object> tags = new HashMap<>();

	public Document(){
		super();
	}

	public Document(String id , String title , String location){
		this.id = id;
		this.title = title;
		this.location = location;
	}

	public void addTag(String key, Object obj) {
		tags.put(key, obj);
	}

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getLocation(){
		return location;
	}

	@Override
	public String toString(){
	
		return "id : " + id + ", title : " + title + ", location : " + location + ", tags : " + tags.toString();
	}
}
