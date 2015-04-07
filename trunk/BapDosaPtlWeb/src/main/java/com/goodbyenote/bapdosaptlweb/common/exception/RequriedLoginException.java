package com.goodbyenote.bapdosaptlweb.common.exception;

public class RequriedLoginException extends Exception {

	public RequriedLoginException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequriedLoginException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public RequriedLoginException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RequriedLoginException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RequriedLoginException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
