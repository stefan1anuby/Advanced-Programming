package com.management_system;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveCommand implements Command{

	private Catalog catalog;
	private String path;

	public SaveCommand(Catalog c ,  String p){
		this.catalog = c;
		this.path = p;
	}

	public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

	public void setPath(String path) {
        this.path = path;
    }

	@Override
	public void execute() throws StreamWriteException, DatabindException, IOException {
		
        CatalogUtil.save(catalog, path);
    }
}
