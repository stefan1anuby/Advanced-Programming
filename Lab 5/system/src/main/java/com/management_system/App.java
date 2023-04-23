package com.management_system;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InvalidCatalogException
    {
        Catalog catalog = new Catalog("MyDocuments");
        Document book = new Document("book1", "title_1" , "D:/Web/EMOF-WEB-Project/login.html" );
        Document article = new Document("article1", "title_2" , "https://profs.info.uaic.ro/~acf/java/labs/lab_05.html" );

        CatalogCommandInvoker invoker = new CatalogCommandInvoker();

        AddCommand addBookCommand = new AddCommand(catalog, book);
        invoker.setCommand(addBookCommand).executeCommand();

        AddCommand addArticleCommand = new AddCommand(catalog, article);
        invoker.setCommand(addArticleCommand).executeCommand();

        SaveCommand saveCommand = new SaveCommand(catalog, "D:/catalog.json");
        invoker.setCommand(saveCommand).executeCommand();
        
        ListCommand listCommand = new ListCommand(catalog);
        invoker.setCommand(listCommand).executeCommand();
        
        ViewCommand viewCommand = new ViewCommand(catalog.findById("book1"));
        invoker.setCommand(viewCommand).executeCommand();

        Catalog catalog2 = CatalogUtil.load("D:/catalog.json");
        
        listCommand.setCatalog(catalog2);
        invoker.setCommand(listCommand).executeCommand();
    
    }
}
