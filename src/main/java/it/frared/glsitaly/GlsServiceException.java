package it.frared.glsitaly;

public class GlsServiceException extends Exception {

	public GlsServiceException(String message) {
		super(message);
	}

	public GlsServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}