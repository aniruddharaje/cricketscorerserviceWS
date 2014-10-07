package com.mantr.cricket.scorer.server.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the delivery database table.
 * 
 */
@Embeddable
public class DeliveryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int matchId;
	private byte innings;
	private byte overNumber;
	private short deliverySequence;

	public DeliveryPK() {
	}

	@Column(name="match_id", insertable=false, updatable=false)
	public int getMatchId() {
		return this.matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	@Column (name = "innings")
	public byte getInnings() {
		return this.innings;
	}
	public void setInnings(byte innings) {
		this.innings = innings;
	}

	@Column(name="over_number")
	public byte getOverNumber() {
		return this.overNumber;
	}
	public void setOverNumber(byte overNumber) {
		this.overNumber = overNumber;
	}

	@Column(name="delivery_sequence")
	public short getDeliverySequence() {
		return this.deliverySequence;
	}
	public void setDeliverySequence(short deliverySequence) {
		this.deliverySequence = deliverySequence;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DeliveryPK)) {
			return false;
		}
		DeliveryPK castOther = (DeliveryPK)other;
		return 
			(this.getMatchId() == castOther.getMatchId())
			&& (this.getInnings() == castOther.getInnings())
			&& (this.getOverNumber() == castOther.getOverNumber())
			&& (this.getDeliverySequence() == castOther.getDeliverySequence());
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.getMatchId();
		hash = hash * prime + ((int) this.getInnings());
		hash = hash * prime + ((int) this.getOverNumber());
		hash = hash * prime + ((int) this.getDeliverySequence());
		
		return hash;
	}
}
