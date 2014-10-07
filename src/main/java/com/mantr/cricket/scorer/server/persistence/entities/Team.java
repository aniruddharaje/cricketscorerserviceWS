package com.mantr.cricket.scorer.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;
import java.util.ArrayList;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity

public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	private int teamId;
	private byte battingInnings;
	private String teamName;
	private List<Player> players = new ArrayList<Player> ();
	private Match match;

	public Team() {
	}


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="team_id")
	public int getTeamId() {
		return this.teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}


	@Column(name="batting_innings")
	public byte getBattingInnings() {
		return this.battingInnings;
	}

	public void setBattingInnings(byte battingInnings) {
		this.battingInnings = battingInnings;
	}


	@Column(name="team_name")
	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	//bi-directional many-to-one association to Player
	@OneToMany(mappedBy="team", cascade = CascadeType.PERSIST)
	public List<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player addPlayer(Player player) {
		getPlayers().add(player);
		player.setTeam(this);

		return player;
	}

	public Player removePlayer(Player player) {
		getPlayers().remove(player);
		player.setTeam(null);

		return player;
	}


	//bi-directional many-to-one association to Match
	@ManyToOne
	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}
