package com.example.demo.exception;

public class CustomerNotSavedException extends RuntimeException {

	private String message;

	public CustomerNotSavedException() {}

	public CustomerNotSavedException(String msg)
	{
		super(msg);
		this.message = msg;
	}
}
