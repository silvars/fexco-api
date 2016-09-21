package ie.com.fexco.eircode.api.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ie.com.fexco.eircode.api.exception.AddressLookupException;
import ie.com.fexco.eircode.api.exception.ConnectionException;
import ie.com.fexco.eircode.api.service.AddressLookupService;
import ie.com.fexco.eircode.api.to.request.AddressLookupRequestTO;
import ie.com.fexco.eircode.api.to.response.AddressLookupResponseTO;

@RestController
public class EirCodeController
{

	private static final Logger LOGGER = LoggerFactory.getLogger(EirCodeController.class);
	private final AddressLookupService addressLookupService;

	@Inject
	public EirCodeController(final AddressLookupService addressLookupService)
	{
		this.addressLookupService = addressLookupService;
	}

	@RequestMapping(value = "/address/{country}/{postCodeAddressFragment}", method = RequestMethod.GET)
	public ResponseEntity<List<AddressLookupResponseTO>> address(AddressLookupRequestTO poAddressLookupRequestTO)
	{

		//LOGGER.info("address", poAddressLookupRequestTO.toString());

		List<AddressLookupResponseTO> response = null;

		try
		{
			response = addressLookupService.address(poAddressLookupRequestTO);
		} catch (AddressLookupException e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.NOT_FOUND);
		} catch (ConnectionException e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.BAD_REQUEST);
		} catch (Exception e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<AddressLookupResponseTO>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/addressgeo/{country}/{postCodeAddressFragment}", method = RequestMethod.GET)
	public ResponseEntity<List<AddressLookupResponseTO>> addressgeo(AddressLookupRequestTO poAddressLookupRequestTO)
	{

		//LOGGER.info("addressgeo", poAddressLookupRequestTO.toString());

		List<AddressLookupResponseTO> response = null;

		try
		{
			response = addressLookupService.addressgeo(poAddressLookupRequestTO);
		} catch (AddressLookupException e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.NOT_FOUND);
		} catch (ConnectionException e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.BAD_REQUEST);
		} catch (Exception e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<AddressLookupResponseTO>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/position/{country}/{postCodeAddressFragment}", method = RequestMethod.GET)
	public ResponseEntity<List<AddressLookupResponseTO>> position(AddressLookupRequestTO poAddressLookupRequestTO)
	{

		//LOGGER.info("position", poAddressLookupRequestTO.toString());

		List<AddressLookupResponseTO> response = null;

		try
		{
			response = addressLookupService.position(poAddressLookupRequestTO);
		} catch (AddressLookupException e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.NOT_FOUND);
		} catch (ConnectionException e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.BAD_REQUEST);
		} catch (Exception e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<AddressLookupResponseTO>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/rgeo/{country}/{latitude}/{longitude}", method = RequestMethod.GET)
	public ResponseEntity<List<AddressLookupResponseTO>> rgeo(AddressLookupRequestTO poAddressLookupRequestTO)
	{

		//LOGGER.info("position", poAddressLookupRequestTO.toString());

		List<AddressLookupResponseTO> response = null;

		try
		{
			response = addressLookupService.rgeo(poAddressLookupRequestTO);
		} catch (AddressLookupException e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.NOT_FOUND);
		} catch (ConnectionException e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.BAD_REQUEST);
		} catch (Exception e)
		{
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<AddressLookupResponseTO>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<AddressLookupResponseTO>>(response, HttpStatus.OK);
	}

}
