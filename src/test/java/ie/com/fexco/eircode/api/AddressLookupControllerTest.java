/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ie.com.fexco.eircode.api;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Basic integration tests for service demo application.
 *
 * @author Dave Syer
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties =
{ "management.port=0" })
public class AddressLookupControllerTest
{

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldBeReturned200WhenSendingRequestToRgeoController() throws Exception
	{
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/rgeo/ie/53.332067/-6.255492/?distance=50&format=json", List.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void shouldBeReturned200WhenSendingRequestToAddressController() throws Exception
	{
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/address/IE/Adelaide%20Road/?lines=4&format=json", List.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void shouldBeReturned200WhenSendingRequestToAddressgeoController() throws Exception
	{
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/addressgeo/IE/D02X285?format=json&lines=4&addTags=w3w", List.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void shouldBeReturned200WhenSendingRequestToPositionController() throws Exception
	{
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/position/IE/D02X285?format=json&lines=4&addTags=w3w", List.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void shouldBeReturned200WhenSendingRequestToUKAddressController() throws Exception
	{
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/address/uk/Adelaide%20Road/?lines=10&format=json", List.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception
	{
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.mgt + "/info", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
