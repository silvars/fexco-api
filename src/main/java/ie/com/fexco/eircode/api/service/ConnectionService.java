package ie.com.fexco.eircode.api.service;

import ie.com.fexco.eircode.api.exception.ConnectionException;

public interface ConnectionService {

	public String connect(String fullURL, String parameters) throws ConnectionException;

}
