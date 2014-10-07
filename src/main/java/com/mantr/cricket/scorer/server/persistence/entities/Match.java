package com.mantr.cricket.scorer.server.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the match database table.
 * 
 */
@Entity
@Table (name = "cricketmatch")


public class Match implements Serializable {
	private static final long serialVersionUID = 1L;
	private int matchId;
	private Timestamp createDateTime;
	private String description;
	private Date matchDate;
	private List<Delivery> deliveries = new ArrayList<Delivery> ();
	private Account account;
	private List<Team> teams = new ArrayList<Team> ();

	public Match() {
	}


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="match_id")
	public int getMatchId() {
		return this.matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}


	@Column(name="create_date_time")
	public Timestamp getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}


	@Column (name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="match_date")
	public Date getMatchDate() {
		return this.matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}


	//bi-directional many-to-one association to Delivery
	@OneToMany(mappedBy="match")
	public List<Delivery> getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public Delivery addDelivery(Delivery delivery) {
		getDeliveries().add(delivery);
		delivery.setMatch(this);

		return delivery;
	}

	public Delivery removeDelivery(Delivery delivery) {
		getDeliveries().remove(delivery);
		delivery.setMatch(null);

		return delivery;
	}


	//bi-directional many-to-one association to Account
	@ManyToOne
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="match", cascade = CascadeType.PERSIST)
	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team addTeam(Team team) {
		getTeams().add(team);
		team.setMatch(this);

		return team;
	}

	public Team removeTeam(Team team) {
		getTeams().remove(team);
		team.setMatch(null);

		return team;
	}

}
