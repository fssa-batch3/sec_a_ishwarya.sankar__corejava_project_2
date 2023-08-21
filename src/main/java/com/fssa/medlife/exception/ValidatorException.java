package com.fssa.medlife.exception;

public class ValidatorException extends Exception {
	private static final long serialVersionUID = -1194860954774008955L;
	public ValidatorException(String msg) {
		super(msg);
	}
	public ValidatorException(Throwable e) {
		super(e);
	}
}