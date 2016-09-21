package ie.com.fexco.eircode.api.exception;

public class ConnectionException extends Exception {

	private static final long serialVersionUID = 2296294844966192474L;

	public ConnectionException(String message) {
		super(message);
	}

	public ConnectionException(String message, Exception e) {
		super(message, e);
	}

}
