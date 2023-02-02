package com.nv.foodapp.exception;



public class InvalidInputDataException extends Exception {

	String fieldName;
	String msg;
	
	@Override
	public String toString() {
		return fieldName+" "+msg;
	}

	public InvalidInputDataException(String fieldName, String msg) {
		super();
		this.fieldName = fieldName;
		this.msg = msg;
	}
	
}
