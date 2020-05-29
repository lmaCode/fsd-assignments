package com.lipengwei.fsd.exception;

public class FSDException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7870278070683329899L;

	public FSDException() {
    }

    public FSDException(String message) {
        super(message);
    }

    public FSDException(String message, Throwable cause) {
        super(message, cause);
    }

    public FSDException(Throwable cause) {
        super(cause);
    }

    public FSDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
