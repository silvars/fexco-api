package ie.com.fexco.eircode.api.util;

import ie.com.fexco.eircode.api.to.request.AddressLookupRequestTO;

public class TestUtil
{

	public static AddressLookupRequestTO generateAddressLookupRequestTOOK(String country)
	{
		AddressLookupRequestTO addressLookupRequestTO = new AddressLookupRequestTO();

		addressLookupRequestTO.setPostCodeAddressFragment("Adelaide Road");
		addressLookupRequestTO.setLines(3);
		addressLookupRequestTO.setFormat("json");
		addressLookupRequestTO.setCountry(country);

		return addressLookupRequestTO;
	}

	public static AddressLookupRequestTO generateAddressLookupRequestTOOK(String country, String latitude, String longitude)
	{

		AddressLookupRequestTO addressLookupRequestTO = new AddressLookupRequestTO();

		addressLookupRequestTO.setDistance("50");
		addressLookupRequestTO.setLatitude(latitude);
		addressLookupRequestTO.setLongitude(longitude);
		addressLookupRequestTO.setFormat("json");
		addressLookupRequestTO.setCountry(country);
		return addressLookupRequestTO;
	}

	public static AddressLookupRequestTO generateAddressLookupRequestTOOK(String country, String addTags)
	{
		AddressLookupRequestTO addressLookupRequestTO = new AddressLookupRequestTO();

		addressLookupRequestTO.setPostCodeAddressFragment("D02X285");
		addressLookupRequestTO.setLines(4);
		addressLookupRequestTO.setFormat("json");
		addressLookupRequestTO.setCountry(country);
		addressLookupRequestTO.setAddTags(addTags);
		return addressLookupRequestTO;

	}

}
