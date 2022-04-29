package com.dhiraj.demo.exception;

public class AlraedyFoundCheckedException extends Exception {
	public AlraedyFoundCheckedException(String msg) {
		super("checked exception, msg : " + msg);
	}
}
