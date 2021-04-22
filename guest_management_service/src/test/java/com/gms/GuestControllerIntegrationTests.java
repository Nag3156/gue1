package com.gms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.gms.model.Guest;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = GuestManagementServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GuestControllerIntegrationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllGuests() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetGuestById() {
		Guest guest = restTemplate.getForObject(getRootUrl() + "/guests/1", Guest.class);
		System.out.println(guest.getGuestname());
		assertNotNull(guest);
	}

	@Test
	public void testCreateGuest() {
		Guest guest = new Guest();
		guest.setAge("25");
		guest.setGuestname("admin");
		guest.setGender("male");
		guest.setEmailid("admin@gmail.com");
		guest.setMobileno("123456");
		guest.setCountry("India");
		guest.setState("Andhra pradesh");
		guest.setCity("Vijayawada");
		guest.setZipcode("123456");
		
		ResponseEntity<Guest> postResponse = restTemplate.postForEntity(getRootUrl() + "/guests", guest, Guest.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateGuest() {
		int id = 1;
		Guest guest = restTemplate.getForObject(getRootUrl() + "/guests/" + id, Guest.class);
		guest.setGuestname("admin1");
		restTemplate.put(getRootUrl() + "/guests/" + id, guest);

		Guest updatedGuest = restTemplate.getForObject(getRootUrl() + "/guests/" + id, Guest.class);
		assertNotNull(updatedGuest);
	}

	@Test
	public void testDeleteGuest() {
		int id = 2;
		Guest guest = restTemplate.getForObject(getRootUrl() + "/guests/" + id, Guest.class);
		assertNotNull(guest);

		restTemplate.delete(getRootUrl() + "/guests/" + id);

		try {
			guest = restTemplate.getForObject(getRootUrl() + "/guests/" + id, Guest.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}