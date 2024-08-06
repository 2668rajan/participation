package com.sportseventmanagement.service;

import java.util.List;

import com.sportseventmanagement.entities.Participation;

public interface ParticipationService {

	List<Participation> getParticipations();

	//Participation getParticipation(long parseLong);

	Participation addParticipation(Participation participation);

	Participation updateParticipation(Participation participation);

	void deleteParticipation(Long parseLong);

	List<Participation> getParticipationByStatus(String status);

	boolean participationExits(Long p_id);

	//boolean participationExists(Long p_id);

	

	
}
