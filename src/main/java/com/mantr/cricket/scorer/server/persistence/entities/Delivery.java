package com.mantr.cricket.scorer.server.persistence.entities;


import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the delivery database table.
 * 
 */
@Entity
@Table (name = "delivery")
public class Delivery implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private DeliveryPK id;
	
	@Column(name="batsman_runs")
	private byte batsmanRuns;
	
	@Column (name = "boundary")
	private boolean boundary;
	
	@Column(name="delivery_commentary")
	private String deliveryCommentary;
	
	@Column(name="delivery_time")
	private Timestamp deliveryTime;
	
	@Column (name = "dismissal")
	private boolean dismissal;
	
	@Column(name="dismissal_end")
	private String dismissalEnd;
	
	@Column (name = "extras")
	private byte extras;
	
	@Column(name="extras_type")
	private String extrasType;
	
	@Column(name="free_hit_ind")
	private boolean freeHitInd;
	
	@Column(name="how_out")
	private String howOutCode;
	
	@Column(name="illegal_delivery_type")
	private String illegalDeliveryType;
	
	@Column(name="legal_delivery_sequence_number")
	private byte legalDeliverySequenceNumber;
	
	@Column(name="nonstriker_position")
	private byte nonstrikerPosition;
	
	@Column (name = "notes")
	private String notes;
	
	@Column (name = "overthrow")
	private boolean overthrow;
	
	@Column(name="position_dismissed")	
	private byte positionDismissed;
	
	@Column(name="striker_position")
	private byte strikerPosition;
	
	@Column(name="team_total_runs")
	private byte teamTotalRuns;
	
	//bi-directional many-to-one association to Match
	@ManyToOne
	@JoinColumn(name="match_id")	
	private Match match;
	

	//one-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="assist_id")
	private Player player;

	public Delivery() {
	}


	
	public DeliveryPK getId() {
		return this.id;
	}

	public void setId(DeliveryPK id) {
		this.id = id;
	}


	
	public byte getBatsmanRuns() {
		return this.batsmanRuns;
	}

	public void setBatsmanRuns(byte batsmanRuns) {
		this.batsmanRuns = batsmanRuns;
	}

	
	public boolean getBoundary() {
		return this.boundary;
	}

	public void setBoundary(boolean boundary) {
		this.boundary = boundary;
	}


	
	public String getDeliveryCommentary() {
		return this.deliveryCommentary;
	}

	public void setDeliveryCommentary(String deliveryCommentary) {
		this.deliveryCommentary = deliveryCommentary;
	}


	
	public Timestamp getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(Timestamp deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	
	public boolean getDismissal() {
		return this.dismissal;
	}

	public void setDismissal(boolean dismissal) {
		this.dismissal = dismissal;
	}


	
	public byte getExtras() {
		return this.extras;
	}

	public void setExtras(byte extras) {
		this.extras = extras;
	}


	
	public Extras getExtrasType() {
		return Extras.parse(this.extrasType);
	}

	public void setExtrasType(Extras extras) {
		this.extrasType = (extras == null) ? null : extras.getValue();
	}


	
	public boolean getFreeHitInd() {
		return this.freeHitInd;
	}

	public void setFreeHitInd(boolean freeHitInd) {
		this.freeHitInd = freeHitInd;
	}


	
	public Dismissal getHowOut() {
		return Dismissal.parse(howOutCode);
	}

	public void setHowOut(Dismissal howOut) {
		this.howOutCode = (howOut == null) ? null : howOut.getValue();
	}


	
	public IllegalDelivery  getIllegalDeliveryType() {
		return IllegalDelivery.parse(illegalDeliveryType);
	}

	public void setIllegalDeliveryType(IllegalDelivery iDeliveryType) {
		this.illegalDeliveryType = iDeliveryType == null ? null : iDeliveryType.getValue();
	}
	
	
	public byte getLegalDeliverySequenceNumber() {
		return this.legalDeliverySequenceNumber;
	}

	public void setLegalDeliverySequenceNumber(byte legalDeliverySequenceNumber) {
		this.legalDeliverySequenceNumber = legalDeliverySequenceNumber;
	}


	
	public byte getNonstrikerPosition() {
		return this.nonstrikerPosition;
	}

	public void setNonstrikerPosition(byte nonstrikerPosition) {
		this.nonstrikerPosition = nonstrikerPosition;
	}


	
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}


	
	public boolean getOverthrow() {
		return this.overthrow;
	}

	public void setOverthrow(boolean overthrow) {
		this.overthrow = overthrow;
	}


	
	public byte getPositionDismissed() {
		return this.positionDismissed;
	}

	public void setPositionDismissed(byte positionDismissed) {
		this.positionDismissed = positionDismissed;
	}


	
	public byte getStrikerPosition() {
		return this.strikerPosition;
	}

	public void setStrikerPosition(byte strikerPosition) {
		this.strikerPosition = strikerPosition;
	}


	
	public byte getTeamTotalRuns() {
		return this.teamTotalRuns;
	}

	public void setTeamTotalRuns(byte teamTotalRuns) {
		this.teamTotalRuns = teamTotalRuns;
	}
	
	
	public DismissalEnd getDismissalEnd() {
		return DismissalEnd.parse(this.dismissalEnd);
	}

	public void setDismissalEnd(DismissalEnd end) {
		this.dismissalEnd = (end == null) ? null : end.getValue();
	}


	
	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}


	
	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public boolean isLegalDelivery() {
		boolean legalDelivery = true;
		
		if (this.getIllegalDeliveryType() != null) {
			System.out.println ("Illegal Deilery Type: " + this.getIllegalDeliveryType());
		}
		
		if (this.getIllegalDeliveryType() == IllegalDelivery.NOBALL_FOOT ||
				this.getIllegalDeliveryType() == IllegalDelivery.NOBALL ||
						this.getIllegalDeliveryType() == IllegalDelivery.WIDE) {
			
			legalDelivery = false;
		}
		return legalDelivery;
	}
}
