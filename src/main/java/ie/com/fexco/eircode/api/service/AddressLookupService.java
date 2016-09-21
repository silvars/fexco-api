package ie.com.fexco.eircode.api.service;

import java.util.List;

import ie.com.fexco.eircode.api.exception.AddressLookupException;
import ie.com.fexco.eircode.api.exception.ConnectionException;
import ie.com.fexco.eircode.api.to.request.AddressLookupRequestTO;
import ie.com.fexco.eircode.api.to.response.AddressLookupResponseTO;

public interface AddressLookupService
{

	public List<AddressLookupResponseTO> address(final AddressLookupRequestTO poAddressLookupRequest) throws ConnectionException, AddressLookupException;

	public List<AddressLookupResponseTO> addressgeo(final AddressLookupRequestTO poAddressLookupRequest) throws ConnectionException, AddressLookupException;

	public List<AddressLookupResponseTO> position(final AddressLookupRequestTO poAddressLookupRequest) throws ConnectionException, AddressLookupException;

	public List<AddressLookupResponseTO> rgeo(AddressLookupRequestTO poAddressLookupRequestTO) throws ConnectionException, AddressLookupException;

}
