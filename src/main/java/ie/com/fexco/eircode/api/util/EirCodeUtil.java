package ie.com.fexco.eircode.api.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import ie.com.fexco.eircode.api.domain.AddressLookupAddress;
import ie.com.fexco.eircode.api.to.EirCodeConfigurationTO;
import ie.com.fexco.eircode.api.to.response.AddressLookupResponseTO;

public class EirCodeUtil
{

	public static final String JSON = "json";
	public static final String XML = "xml";
	public static final String APPLICATION = "application/";

	public static String generateURL(EirCodeConfigurationTO poConfiguration, String psMethod, String psParameters, String psCountry)
	{

		String uri = String.format(poConfiguration.getBaseURL(), poConfiguration.getSearchKey(), psMethod, psCountry);
		return new StringBuffer(uri).append(psParameters).toString().trim();

	}

	public static String generateURL(EirCodeConfigurationTO poConfiguration, String psMethod, String psParameters, String psCountry, String longitude, String latitude)
	{
		String uri = String.format(poConfiguration.getBaseURL() + "%s/%s/", poConfiguration.getSearchKey(), psMethod, psCountry, longitude, latitude);
		return new StringBuffer(uri).append(psParameters).toString().trim();
	}

	public static Set<AddressLookupAddress> copyAddressProperties(AddressLookupResponseTO[] addresses)
	{
		Set<AddressLookupAddress> addressDB = new HashSet<AddressLookupAddress>(addresses.length);

		for (AddressLookupResponseTO addressLookupResponseTO : addresses)
		{
			AddressLookupAddress address = new AddressLookupAddress();
			try
			{
				BeanUtils.copyProperties(address, addressLookupResponseTO);
			} catch (Exception e)
			{
				e.printStackTrace();
			}

			addressDB.add(address);
		}
		return addressDB;
	}

	public static Set<AddressLookupResponseTO> copyAddressProperties(Set<AddressLookupAddress> addresses)
	{

		Set<AddressLookupResponseTO> addressDB = new HashSet<AddressLookupResponseTO>(addresses.size());

		for (AddressLookupAddress addressLookupResponseTO : addresses)
		{
			AddressLookupResponseTO address = new AddressLookupResponseTO();
			try
			{
				BeanUtils.copyProperties(address, addressLookupResponseTO);
			} catch (Exception e)
			{
				e.printStackTrace();
			}

			addressDB.add(address);
		}
		return addressDB;
	}

}
