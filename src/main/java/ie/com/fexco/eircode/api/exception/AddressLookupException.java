package ie.com.fexco.eircode.api.exception;

public class AddressLookupException extends Exception {

	private static final long serialVersionUID = 2296294844966192474L;

	public AddressLookupException(String message, Exception e) {
		super(message, e);
	}

}
