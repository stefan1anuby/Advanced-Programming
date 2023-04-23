package com.management_system;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.awt.Desktop;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CatalogUtil {
	
	public static void save(Catalog catalog, String path) throws IOException {
   
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.writeValue(new File(path),catalog);
	}
	public static Catalog load(String path) throws InvalidCatalogException {

		ObjectMapper objectMapper = new ObjectMapper();
		Catalog catalog = null;
		try {
			catalog = objectMapper.readValue(new File(path),Catalog.class);
		}
		catch (IOException e) {
			
			throw new InvalidCatalogException(e);
		}
		return catalog;
	}
	public static void view(Document doc) throws IOException, InvalidDocumentException {
		
		try {
			
			URI uri = new URI(doc.getLocation());
			Desktop dt = Desktop.getDesktop();
			dt.browse(uri);
		} catch (Exception e) {
			// TODO: handle exception
			throw new InvalidDocumentException();
		}		
	}

	public static void report(Catalog catalog){

	}

}
   
