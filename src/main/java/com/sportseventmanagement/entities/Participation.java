package com.sportseventmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Participation {

	@Id
	private Long p_id;//participation id
	@NotNull(message = "Player name cannot be null")
	private Long playerId;
	@NotNull(message = "Player name cannot be null")
	private String playerName;
	@NotNull(message = "Player name cannot be null")
	private Long eventId;
	@NotNull(message = "Player name cannot be null")
	private String eventName;
	@NotNull(message = "Player name cannot be null")
	private Long sportsId;
	@NotNull(message = "Player name cannot be null")
	private String sportsName;
	@NotNull(message = "Player name cannot be null")
	private String status;
	
	public Participation(Long p_id, Long playerId, String playerName, Long eventId, String eventName, Long sportsId,
			String sportsName, String status) {
		super();
		this.p_id = p_id;
		this.playerId = playerId;
		this.playerName = playerName;
		this.eventId = eventId;
		this.eventName = eventName;
		this.sportsId = sportsId;
		this.sportsName = sportsName;
		this.status = status;
	}

	public Participation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Long getSportsId() {
		return sportsId;
	}

	public void setSportsId(Long sportsId) {
		this.sportsId = sportsId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Participation [p_id=" + p_id + ", playerId=" + playerId + ", playerName=" + playerName + ", eventId="
				+ eventId + ", eventName=" + eventName + ", sportsId=" + sportsId + ", sportsName=" + sportsName
				+ ", status=" + status + "]";
	}
	
	
}
