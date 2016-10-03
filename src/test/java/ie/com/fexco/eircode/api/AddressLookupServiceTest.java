package ie.com.fexco.eircode.api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;

import ie.com.fexco.eircode.api.repository.AddressLookupRepository;
import ie.com.fexco.eircode.api.service.AddressLookupService;
import ie.com.fexco.eircode.api.service.ConnectionService;
import ie.com.fexco.eircode.api.service.impl.AddressLookupServiceImpl;
import ie.com.fexco.eircode.api.to.EirCodeConfigurationTO;
import ie.com.fexco.eircode.api.to.response.AddressLookupResponseTO;
import ie.com.fexco.eircode.api.util.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressLookupServiceTest
{

	@Autowired
	private AddressLookupRepository addressLookupRepository;
	@Autowired
	private ConnectionService connectionService;
	@Autowired
	private EirCodeConfigurationTO configuration;

	private AddressLookupService addressLookupService;

	private Gson gson;

	@Before
	public void setUp() throws Exception
	{
		addressLookupService = new AddressLookupServiceImpl(addressLookupRepository, connectionService, configuration);
		gson = new Gson();
	}

	@Test
	public void addressUKShouldBeTheSameAtServiceAndCache() throws Exception
	{

		// from service
		List<AddressLookupResponseTO> resultFromService = addressLookupService.address(TestUtil.generateAddressLookupRequestTOOK("UK"));

		// from cache
		List<AddressLookupResponseTO> resultFromBD = addressLookupService.address(TestUtil.generateAddressLookupRequestTOOK("UK"));

		assertEquals("Should be the same!", (resultFromService.size()), (resultFromBD.size()));
	}

	@Test
	public void addressIEShouldBeTheSameAtServiceAndCache() throws Exception
	{

		// from service
		List<AddressLookupResponseTO> resultFromService = addressLookupService.address(TestUtil.generateAddressLookupRequestTOOK("IE"));

		// from cache
		List<AddressLookupResponseTO> resultFromBD = addressLookupService.address(TestUtil.generateAddressLookupRequestTOOK("IE"));

		assertEquals("Should be the same!", gson.toJson(resultFromService), gson.toJson(resultFromBD));
	}

	@Test
	public void rgeoIEShouldBeTheSameAtServiceAndCache() throws Exception
	{

		// from service
		List<AddressLookupResponseTO> resultFromService = addressLookupService.address(TestUtil.generateAddressLookupRequestTOOK("IE", "53.332067", "-6.255492"));

		// from cache
		List<AddressLookupResponseTO> resultFromBD = addressLookupService.address(TestUtil.generateAddressLookupRequestTOOK("IE", "53.332067", "-6.255492"));

		assertEquals("Should be the same!", gson.toJson(resultFromService), gson.toJson(resultFromBD));
	}

	@Test
	public void addressgeoIEShouldBeTheSameAtServiceAndCache() throws Exception
	{

		// from service
		List<AddressLookupResponseTO> resultFromService = addressLookupService.address(TestUtil.generateAddressLookupRequestTOOK("IE", "w3w"));

		// from cache
		List<AddressLookupResponseTO> resultFromBD = addressLookupService.address(TestUtil.generateAddressLookupRequestTOOK("IE", "w3w"));

		assertEquals("Should be the same!", gson.toJson(resultFromService), gson.toJson(resultFromBD));
	}

	@Test
	public void rgeoIEShouldNotBeTheSameAtServiceAndCache() throws Exception
	{

		// from service
		List<AddressLookupResponseTO> resultFromService1 = addressLookupService.address(TestUtil.generateAddressLookupRequestTOOK("IE", "53.332067", "-6.255492"));

		// from service
		List<AddressLookupResponseTO> resultFromService2 = addressLookupService.address(TestUtil.generateAddressLookupRequestTOOK("IE"));

		assertThat(gson.toJson(resultFromService1), is(not(gson.toJson(resultFromService2))));
	}

}
