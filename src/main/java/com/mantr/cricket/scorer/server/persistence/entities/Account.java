package com.mantr.cricket.scorer.server.persistence.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table (name = "account")
@NamedQuery (
		name = "findAccountByEmailAddress",
		query = "select a from Account a where a.emailAddress = :email"
		)

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int accountId;
	private Timestamp accountCreateDate;
	private String emailAddress;
	private List<Match> matches;

	public Account() {
	}


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	@Column(name="account_create_date")
	public Timestamp getAccountCreateDate() {
		return this.accountCreateDate;
	}

	public void setAccountCreateDate(Timestamp accountCreateDate) {
		this.accountCreateDate = accountCreateDate;
	}


	@Column(name="email_address")
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="account")
	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Match addMatch(Match match) {
		getMatches().add(match);
		match.setAccount(this);

		return match;
	}

	public Match removeMatch(Match match) {
		getMatches().remove(match);
		match.setAccount(null);

		return match;
	}

}
