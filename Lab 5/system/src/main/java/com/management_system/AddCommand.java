package com.management_system;

public class AddCommand implements Command{
    private Catalog catalog;
    private Document document;

    public AddCommand(Catalog c, Document d) {
        this.catalog = c;
        this.document = d;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

	public void setDocument(Document document){
		this.document = document;
	}

    @Override
    public void execute() {
        catalog.add(document);
    }
}
