package ie.com.fexco.eircode.api.exception;

public class AddressAutocompleteException extends Exception {

	private static final long serialVersionUID = -5497837906792114402L;

	public AddressAutocompleteException(String message, Exception e) {
		super(message, e);
	}

}
