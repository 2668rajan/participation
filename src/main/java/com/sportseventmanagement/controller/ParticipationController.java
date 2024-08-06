package com.sportseventmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportseventmanagement.entities.Participation;
import com.sportseventmanagement.exception.AuthenticationException;
import com.sportseventmanagement.exception.ParticipationAlreadyExists;
import com.sportseventmanagement.exception.ParticipationsNotFoundException;
import com.sportseventmanagement.feign.Iproxy;
import com.sportseventmanagement.service.ParticipationService;

@RestController
@RequestMapping("/participation")
public class ParticipationController {

	@Autowired
	private Iproxy iproxy;

	@Autowired
	private ParticipationService participationService;

	Logger log = LoggerFactory.getLogger(ParticipationController.class);

	@GetMapping("/home")
	public String home() {
		return "welcome home page of participation microservice";
	}

	// get all participations
	@GetMapping("/participations")
	public List<Participation> getParticipations(@RequestHeader(value = "Authorization", required = true) String token1)
			throws ParticipationsNotFoundException, AuthenticationException {
		if (iproxy.getvalidation(token1)) {
			List<Participation> participations = participationService.getParticipations();
			if (participations.isEmpty()) {
				throw new ParticipationsNotFoundException("Participations not found");
			}

			log.info("List of all participations fetched");
			return participations;

		} else {
			throw new AuthenticationException("You are not authorized");
		}
	}

//	//get a participation with an id
//	@GetMapping("/participations/{p_id}")
//	public Participation getParticipation(@PathVariable String p_id) {
//		return this.participationService.getParticipation(Long.parseLong(p_id));
//	}

	// add a participation
	@PostMapping("/participations")
	public ResponseEntity<String> addParticipation(@RequestBody Participation participation, @RequestHeader(value = "Authorization", required = true) String token1)
			throws ParticipationAlreadyExists, AuthenticationException {
		if(iproxy.getvalidation(token1)) {
			if (participationService.participationExits(participation.getP_id())) {
				throw new ParticipationAlreadyExists("Participation already exists");
			}
			participationService.addParticipation(participation);
	
			log.info("Participation with Id " + participation.getP_id() + " created");
	
			return new ResponseEntity<>("Participation Created Successfully!", HttpStatus.CREATED);
		}else {
			throw new AuthenticationException("You are not authorized");
		}

	}

	// update a participation
	@PutMapping("/participations")
	public Participation updateParticipation(@RequestBody Participation participation,
			@RequestHeader(value = "Authorization", required = true) String token1) throws AuthenticationException, ParticipationsNotFoundException {
		if (iproxy.getvalidation(token1)) {
			if (participationService.participationExits(participation.getP_id())) {
				Participation updateParticipation = participationService.updateParticipation(participation);
				log.info("Participation updated successfully");
				return updateParticipation;
			}else {
				throw new ParticipationsNotFoundException("Participation not found");
			}
		} else {
			throw new AuthenticationException("You are not autorized");
		}
		
	}

	// delete a participant
	@DeleteMapping("/participations/{p_id}")
	public ResponseEntity<HttpStatus> deleteParticipation(@PathVariable Long p_id,
			@RequestHeader(value = "Authorization", required = true) String token1) throws AuthenticationException {

		if (iproxy.getvalidation(token1)) {
			try {
				System.out.println("deleted");
				this.participationService.deleteParticipation(p_id);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			throw new AuthenticationException("You are not authorized");
		}
	}

	// get all participants by status
	@GetMapping("/participations/{status}")
	public List<Participation> getParticipationByStatus(@PathVariable String status,
			@RequestHeader(value = "Authorization", required = true) String token1) throws ParticipationsNotFoundException, AuthenticationException {
		if (iproxy.getvalidation(token1)) {

			List<Participation> participationByStatus = participationService.getParticipationByStatus(status);
			if (participationByStatus.isEmpty()) {
				throw new ParticipationsNotFoundException("No Participation found");
			}
			log.info("participation with status are " + participationByStatus);
			return participationByStatus;
		} else {
			throw new AuthenticationException("You are not authorized");
		}
	}

}
