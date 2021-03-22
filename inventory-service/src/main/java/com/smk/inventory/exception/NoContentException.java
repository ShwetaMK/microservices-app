package com.smk.inventory.exception;

public class NoContentException extends RuntimeException {

	
	public NoContentException() {

		super("No Records found");
	}
	 
}
