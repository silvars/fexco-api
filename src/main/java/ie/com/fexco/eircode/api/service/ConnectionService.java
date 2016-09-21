package ie.com.fexco.eircode.api.service;

import ie.com.fexco.eircode.api.exception.ConnectionException;

public interface ConnectionService
{

	/**
	 * 
	 * General method that connects an specified URL with parameters (request
	 * parameters).
	 * 
	 * @param fullURL
	 * 			@example:
	 *            http://ws.postcoder.com/pcw/PCW45-12345-12345-1234X/rgeo/ie/53.332067/-6.255492?distance=50&format=json
	 * @param parameters
	 * @return String (JSON) Return
	 * @throws ConnectionException
	 */
	public String connect(String fullURL, String parameters) throws ConnectionException;

}
