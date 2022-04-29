package com.dhiraj.demo.exception;

public class AlreadyExistsException extends RuntimeException {
	public AlreadyExistsException(String msg) {
		super(msg);
	}
}

// exception 

//1. checked -> compile time  

// 2. unchecked -> runtime , RuntimeException()
