package com.sportseventmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventmanagement.dao.ParticipationDao;
import com.sportseventmanagement.entities.Participation;

@Service
public class ParticipationServiceImpl implements ParticipationService {
	
	@Autowired
	private ParticipationDao participationDao;

	List<Participation> list;

	public ParticipationServiceImpl() {

//		list = new ArrayList<>();
//		list.add(new Participation(1, 1001, "Rajan", 101, "Summer game", 261, "cricket", "approved"));
//		list.add(new Participation(2, 1002, "Annu", 102, "Winter game", 2668, "chess", "declined"));
	}

	@Override
	public List<Participation> getParticipations() {
		// TODO Auto-generated method stub
		//return list;
		return participationDao.findAll();
	}

	/*
	 * @Override public Participation getParticipation(long parseLong) {
	 * 
	 * Participation p = null; for (Participation participation : list) { if
	 * (participation.getP_id() == parseLong) { p = participation; break; } } return
	 * p; }
	 */

	@Override
	public Participation addParticipation(Participation participation) {
		//list.add(participation);
		participationDao.save(participation);
		return participation;
	}

	@Override
	public Participation updateParticipation(Participation participation) {
		/*list.forEach(e -> {
			if (e.getP_id() == participation.getP_id()) {
				e.setEventName(participation.getEventName());
				e.setEventId(participation.getEventId());
				e.setSportsId(participation.getSportsId());
				e.setSportsName(participation.getSportsName());
				e.setPlayerId(participation.getPlayerId());
				e.setPlayerName(participation.getPlayerName());
				e.setStatus(participation.getStatus());
			}
		});
		*/
		participationDao.save(participation);
		return participation;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteParticipation(Long parseLong) {

		//list = this.list.stream().filter(e -> e.getP_id() != parseLong).collect(Collectors.toList());
		Participation entity = participationDao.getOne(parseLong);
		participationDao.delete(entity);
	}

	@Override
	public List<Participation> getParticipationByStatus(String status) {
		
		return participationDao.findByStatus(status);
		//return participationDao.findby
	}

	@Override
	public boolean participationExits(Long p_id) {
		return participationDao.existsById(p_id);
	}

	


}
