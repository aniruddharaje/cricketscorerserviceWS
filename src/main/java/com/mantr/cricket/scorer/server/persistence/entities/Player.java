package com.mantr.cricket.scorer.server.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the player database table.
 * 
 */
@Entity
@Table (name = "player")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private int playerId;
	private byte battingPosition;
	private byte bowlingPosition;
	private String firstName;
	private String lastName;
	private Team team;

	public Player() {
	}


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="player_id")
	public int getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}


	@Column(name="batting_position")
	public byte getBattingPosition() {
		return this.battingPosition;
	}

	public void setBattingPosition(byte battingPosition) {
		this.battingPosition = battingPosition;
	}


	@Column(name="bowling_position")
	public byte getBowlingPosition() {
		return this.bowlingPosition;
	}

	public void setBowlingPosition(byte bowlingPosition) {
		this.bowlingPosition = bowlingPosition;
	}


	@Column(name="first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(name="last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	//bi-directional many-to-one association to Team
	@ManyToOne
	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
