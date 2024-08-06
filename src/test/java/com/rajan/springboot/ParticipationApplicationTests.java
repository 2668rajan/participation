package com.rajan.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sportseventmanagement.ParticipationApplication;
import com.sportseventmanagement.dao.ParticipationDao;
import com.sportseventmanagement.entities.Participation;
import com.sportseventmanagement.service.ParticipationService;

@SpringBootTest(classes=ParticipationApplication.class)
class ParticipationApplicationTests {
	
	@Autowired
	private ParticipationDao repo;
	
	@Autowired
	private ParticipationService service;

	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	void setUp(){
		Participation parti = new Participation(1l, 1001l, "Rajan", 101l, "Summer game", 261l, "cricket", "approved");
		repo.save(parti);
	}
	
	@Test
	void getParticipations() {
		List<Participation> actualList = repo.findAll();
		assertThat(actualList).asList();
	}
	
	@Test
	void addParticipation() {
		Participation participation = new Participation(2l, 1001l, "Rajan", 101l, "Summer game", 261l, "cricket", "approved");
		repo.save(participation);
	}
	
	@Test
	void updateParticipation() {
		Participation participation = new Participation(2l, 1001l, "Adnan", 101l, "Summer game", 261l, "cricket", "approved");
		repo.save(participation);
	}
	
	@Test
	void deleteParticipation() {
		repo.deleteById(1l);
	}
	
	@Test
	void getParticipationByStatus() {
		List<Participation> actual = repo.findByStatus("approved");
		assertThat(actual).isNotEmpty();
		
	}
	@Test
	void paticipationExist() {
		boolean actual = repo.existsById(1l);
		assertThat(actual).isTrue();
	}
	
	
}
