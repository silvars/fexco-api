package ie.com.fexco.eircode.api.service;

import java.util.List;

import ie.com.fexco.eircode.api.exception.AddressLookupException;
import ie.com.fexco.eircode.api.exception.ConnectionException;
import ie.com.fexco.eircode.api.to.request.AddressLookupRequestTO;
import ie.com.fexco.eircode.api.to.response.AddressLookupResponseTO;

public interface AddressLookupService
{

	/**
	 * 
	 * Custom service that consumes <URL>
	 * http://ws.postcoder.com/pcw/[api-key]/address/ie/[eircode-or-address-fragment]
	 * and <URL>
	 * http://ws.postcoder.com/pcw/[api-key]/address/uk/[postcode-or-address-fragment]
	 * 
	 * Abstracts all rules from connection, etc.
	 * 
	 * @param poAddressLookupRequest
	 * @return List<AddressLookupResponseTO>
	 * @throws ConnectionException
	 * @throws AddressLookupException
	 */
	public List<AddressLookupResponseTO> address(final AddressLookupRequestTO poAddressLookupRequest) throws ConnectionException, AddressLookupException;

	/**
	 * Custom service that consumes <URL>
	 * http://ws.postcoder.com/pcw/[api-key]/addressgeo/ie/[eircode-or-address-fragment]
	 * 
	 * Abstracts all rules from connection, etc.
	 * 
	 * @param poAddressLookupRequest
	 * @return List<AddressLookupResponseTO>
	 * @throws ConnectionException
	 * @throws AddressLookupException
	 */
	public List<AddressLookupResponseTO> addressgeo(final AddressLookupRequestTO poAddressLookupRequest) throws ConnectionException, AddressLookupException;

	/**
	 * Custom service that consumes <URL>
	 * http://ws.postcoder.com/pcw/[api-key]/position/ie/[eircode]
	 * 
	 * Abstracts all rules from connection, etc.
	 * 
	 * @param poAddressLookupRequest
	 * @return List<AddressLookupResponseTO>
	 * @throws ConnectionException
	 * @throws AddressLookupException
	 */
	public List<AddressLookupResponseTO> position(final AddressLookupRequestTO poAddressLookupRequest) throws ConnectionException, AddressLookupException;

	/**
	 * Custom service that consumes <URL>
	 * http://ws.postcoder.com/pcw/[api-key]/rgeo/ie/[latitude]/[longitude]?distance=[distance-in-metres]
	 * 
	 * Abstracts all rules from connection, etc.
	 * 
	 * @param poAddressLookupRequestTO
	 * @return List<AddressLookupResponseTO>
	 * @throws ConnectionException
	 * @throws AddressLookupException
	 */
	public List<AddressLookupResponseTO> rgeo(AddressLookupRequestTO poAddressLookupRequestTO) throws ConnectionException, AddressLookupException;

}
