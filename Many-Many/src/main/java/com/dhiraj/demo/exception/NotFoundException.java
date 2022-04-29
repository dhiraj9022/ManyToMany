package com.dhiraj.demo.exception;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String msg) {
		super("Not found id");
	}
}
