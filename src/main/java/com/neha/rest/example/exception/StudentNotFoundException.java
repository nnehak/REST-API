package com.neha.rest.example.exception;

public class StudentNotFoundException extends RuntimeException{
	
	public StudentNotFoundException(){
		super("Student does not exist");
	}

}
