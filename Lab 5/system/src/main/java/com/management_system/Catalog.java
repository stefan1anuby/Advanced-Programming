package com.management_system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
	private String name;
	private List<Document> docs = new ArrayList<>();

	public Catalog(){
		super();
	}

	public Catalog(String name){
		this.name = name;
	}
   
	public void add(Document doc) {
		docs.add(doc);
	}

	public Document findById(String id) {
		return docs.stream()
		.filter(d -> d.getId().equals(id)).findFirst().orElse(null);
	}

	public String getName(){
		return name;
	}

	public List<Document> getDocs(){
		return docs;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Document doc : docs) {
            sb.append(doc.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
	   
}
   
