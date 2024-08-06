package com.sportseventmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventmanagement.entities.Participation;

public interface ParticipationDao extends JpaRepository<Participation, Long> {

	List<Participation> findByStatus(String status);

	//boolean existsByp_id(Long p_id);

	


}
