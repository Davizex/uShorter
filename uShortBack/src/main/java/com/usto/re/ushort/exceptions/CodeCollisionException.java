package com.usto.re.ushort.exceptions;

public class CodeCollisionException extends Exception {

	private static final long serialVersionUID = 1873568140266820388L;

	public CodeCollisionException() {
		super();
	}

	public CodeCollisionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CodeCollisionException(String message, Throwable cause) {
		super(message, cause);
	}

	public CodeCollisionException(String message) {
		super(message);
	}

	public CodeCollisionException(Throwable cause) {
		super(cause);
	}

}
