package com.management_system;

public class ListCommand implements Command{
	
	private Catalog catalog;

	public ListCommand(Catalog c){
		this.catalog = c;
	}

	public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

	@Override
	public void execute() {
        System.out.println(this.catalog);
    }
}
