package com.management_system;

public class CatalogCommandInvoker {
	
	private Command command;

	public CatalogCommandInvoker(){
		this.command =  null;
	}

	public CatalogCommandInvoker(Command command){
		this.command = command;
	}

	public CatalogCommandInvoker setCommand(Command command) {
        this.command = command;
        return this;
    }

	public CatalogCommandInvoker executeCommand() {
        try {
			if(command != null){
				
				command.execute();
			}
			else{

				throw new CommandException("Command is null");
			}
        }
        catch (CommandException e) {
            System.out.println("Generic Command Exception! :" + e.toString());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return this;
    }

}
   
