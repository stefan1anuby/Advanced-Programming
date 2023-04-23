package com.management_system;

public class InvalidDocumentException extends Exception{
	public InvalidDocumentException(){
		super("Invalid Document file.");
	}
}
