package com.management_system;

import java.io.IOException;

public interface Command {
	void execute() throws CommandException,IOException;
}
