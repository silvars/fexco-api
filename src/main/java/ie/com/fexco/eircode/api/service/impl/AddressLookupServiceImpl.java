package ie.com.fexco.eircode.api.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ie.com.fexco.eircode.api.domain.AddressLookup;
import ie.com.fexco.eircode.api.domain.AddressLookupAddress;
import ie.com.fexco.eircode.api.enums.StatusEnum;
import ie.com.fexco.eircode.api.exception.AddressLookupException;
import ie.com.fexco.eircode.api.exception.ConnectionException;
import ie.com.fexco.eircode.api.repository.AddressLookupRepository;
import ie.com.fexco.eircode.api.service.AddressLookupService;
import ie.com.fexco.eircode.api.service.ConnectionService;
import ie.com.fexco.eircode.api.to.EirCodeConfigurationTO;
import ie.com.fexco.eircode.api.to.request.AddressLookupRequestTO;
import ie.com.fexco.eircode.api.to.response.AddressLookupResponseTO;
import ie.com.fexco.eircode.api.util.EirCodeUtil;

@Service
@Validated
public class AddressLookupServiceImpl implements AddressLookupService
{

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressLookupServiceImpl.class);
	private final AddressLookupRepository addressLookupRequestRepository;
	private final EirCodeConfigurationTO configuration;
	private final ConnectionService connectionService;

	public static final String ADDRESS = "address";
	private static final String ADDRESSGEO = "addressgeo";
	private static final String POSITION = "position";
	private static final String RGEO = "rgeo";

	@Inject
	public AddressLookupServiceImpl(final AddressLookupRepository addressLookupRequestRepository, ConnectionService connectionService, EirCodeConfigurationTO configuration)
	{
		this.addressLookupRequestRepository = addressLookupRequestRepository;
		this.configuration = configuration;
		this.connectionService = connectionService;
	}

	@Override
	@Transactional
	public List<AddressLookupResponseTO> address(AddressLookupRequestTO poAddressLookupRequest) throws ConnectionException, AddressLookupException
	{
		LOGGER.info("INI: address(AddressLookupRequestTO) ");

		String fullURL = EirCodeUtil.generateURL(configuration, ADDRESS, poAddressLookupRequest.getParameters(), poAddressLookupRequest.getCountry());

		try
		{
			return call(poAddressLookupRequest, fullURL);
		} catch (ConnectionException | AddressLookupException e)
		{
			throw e;
		} finally
		{
			LOGGER.info("END: address(AddressLookupRequestTO)");
		}

	}

	@Override
	@Transactional
	public List<AddressLookupResponseTO> addressgeo(AddressLookupRequestTO poAddressLookupRequest) throws ConnectionException, AddressLookupException
	{
		LOGGER.info("INI: addressgeo(AddressLookupRequestTO) ");

		String fullURL = EirCodeUtil.generateURL(configuration, ADDRESSGEO, poAddressLookupRequest.getParameters(), poAddressLookupRequest.getCountry());

		try
		{
			return call(poAddressLookupRequest, fullURL);
		} catch (ConnectionException | AddressLookupException e)
		{
			throw e;
		} finally
		{
			LOGGER.info("END: addressgeo(AddressLookupRequestTO)");
		}

	}

	@Override
	@Transactional
	public List<AddressLookupResponseTO> position(AddressLookupRequestTO poAddressLookupRequest) throws ConnectionException, AddressLookupException
	{
		LOGGER.info("INI: position(AddressLookupRequestTO) ");

		String fullURL = EirCodeUtil.generateURL(configuration, POSITION, poAddressLookupRequest.getParameters(), poAddressLookupRequest.getCountry());

		try
		{
			return call(poAddressLookupRequest, fullURL);
		} catch (ConnectionException | AddressLookupException e)
		{
			throw e;
		} finally
		{
			LOGGER.info("END: position(AddressLookupRequestTO)");
		}

	}

	@Override
	public List<AddressLookupResponseTO> rgeo(AddressLookupRequestTO poAddressLookupRequest) throws ConnectionException, AddressLookupException
	{

		LOGGER.info("INI: position(AddressLookupRequestTO) ");

		String fullURL = EirCodeUtil.generateURL(configuration, RGEO, poAddressLookupRequest.getParameters(), poAddressLookupRequest.getCountry(), poAddressLookupRequest.getLongitude(), poAddressLookupRequest.getLatitude());

		try
		{
			return call(poAddressLookupRequest, fullURL);
		} catch (ConnectionException | AddressLookupException e)
		{
			throw e;
		} finally
		{
			LOGGER.info("END: position(AddressLookupRequestTO)");
		}
	}

	private List<AddressLookupResponseTO> call(AddressLookupRequestTO poAddressLookupRequest, final String psFullURL) throws ConnectionException, AddressLookupException
	{

		AddressLookup address = addressLookupRequestRepository.findByRequestURL(psFullURL);

		if (address == null)
		{
			try
			{

				address = addressLookupRequestRepository.findByRequestURL(psFullURL);

				if (address != null)
				{
					return returnFromCache(address);
				}

				String json = connectionService.connect(psFullURL, poAddressLookupRequest.getFormat());

				GsonBuilder builder = new GsonBuilder();
				Gson gson = builder.create();

				AddressLookupResponseTO[] addresses = gson.fromJson(json, AddressLookupResponseTO[].class);

				Set<AddressLookupAddress> addressDB = EirCodeUtil.copyAddressProperties(addresses);

				address = new AddressLookup(new Date(), psFullURL, StatusEnum.ACTIVE, 1, addressDB);

				addressLookupRequestRepository.save(address);

				LOGGER.info(" From the Service");

				return Arrays.asList(addresses);

			} catch (ConnectionException e)
			{
				throw e;
			} catch (Exception e)
			{
				throw new ConnectionException(e.getMessage(), e);
			}

		} else
		{
			return returnFromCache(address);
		}
	}

	private List<AddressLookupResponseTO> returnFromCache(AddressLookup address)
	{
		address.setHits(address.getHits() + 1);

		addressLookupRequestRepository.save(address);

		Set<AddressLookupResponseTO> addressesSaved = EirCodeUtil.copyAddressProperties(address.getAddresses());

		LOGGER.info(" From the Cache");

		return new ArrayList<AddressLookupResponseTO>(addressesSaved);
	}

}
