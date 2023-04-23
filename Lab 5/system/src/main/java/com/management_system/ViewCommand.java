package com.management_system;

import java.io.IOException;

public class ViewCommand implements Command{

	private Document doc;

	public ViewCommand(Document doc){
		this.doc = doc;
	}

	public void setDocument(Document doc) {
        this.doc = doc;
    }

	@Override
	public void execute() throws IOException, InvalidDocumentException {
		
        CatalogUtil.view(doc);
    }
}
