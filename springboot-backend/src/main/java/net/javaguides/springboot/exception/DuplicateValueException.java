package net.javaguides.springboot.exception;

public class DuplicateValueException extends RuntimeException {
	private static final long serialVersionUid = 2l;
	public DuplicateValueException(String message){
		super(message);
	}

}
