package edu.handong.csee.java.utils;

public class CustomizedException extends Exception {
	public CustomizedException() {
		super("There is an error. You should put a file path");
	}
	
	public CustomizedException(String message) {
		super(message);
	}
	
}
