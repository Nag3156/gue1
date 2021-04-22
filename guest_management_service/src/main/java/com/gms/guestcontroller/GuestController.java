package com.gms.guestcontroller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gms.exception.ResourceNotFoundException;
import com.gms.guestrepository.GuestRepository;
import com.gms.model.Guest;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class GuestController {
	@Autowired
	private GuestRepository guestRepository;

	@GetMapping("/guests")
	public List<Guest> getAllGuests() {
		return guestRepository.findAll();
	}

	@GetMapping("/guests/{emailid}")
	public ResponseEntity<Guest> getGuestById(@PathVariable(value = "emailid") String guestId)
			throws ResourceNotFoundException {
		Guest guest = guestRepository.findById(guestId)
				.orElseThrow(() -> new ResourceNotFoundException("Guest not found for this id :: " + guestId));
		return ResponseEntity.ok().body(guest);
	}

	@PostMapping("/guests")
	public Guest createGuest(@RequestBody Guest guest) {
		return guestRepository.save(guest);
	}

	@PutMapping("/guests/{emailid}")
	public ResponseEntity<Guest> updateGuest(@PathVariable(value = "emailid") String guestId,
			@RequestBody Guest guestDetails) throws ResourceNotFoundException {
		Guest guest = guestRepository.findById(guestId)
				.orElseThrow(() -> new ResourceNotFoundException("Guest not found for this id :: " + guestId));

		guest.setGuestname(guestDetails.getGuestname());
		guest.setNoofchildren(guestDetails.getNoofchildren());
		guest.setNoofadults(guestDetails.getNoofadults());
		guest.setAge(guestDetails.getAge());
		guest.setAge(guestDetails.getAge());
		guest.setGender(guestDetails.getGender());
		guest.setEmailid(guestDetails.getEmailid());
		guest.setMobileno(guestDetails.getMobileno());
		guest.setCountry(guestDetails.getCountry());
		guest.setState(guestDetails.getState());
		guest.setCity(guestDetails.getCity());
		guest.setZipcode(guestDetails.getZipcode());
		final Guest updatedGuest = guestRepository.save(guest);
		return ResponseEntity.ok(updatedGuest);
	}

	@DeleteMapping("/guests/{emailid}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "emailid") String guestId)
			throws ResourceNotFoundException {
		Guest guest = guestRepository.findById(guestId)
				.orElseThrow(() -> new ResourceNotFoundException("Guest not found for this id :: " + guestId));

		guestRepository.delete(guest);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}