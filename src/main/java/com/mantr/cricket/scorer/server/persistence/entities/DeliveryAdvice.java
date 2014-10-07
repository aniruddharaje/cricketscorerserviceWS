package com.mantr.cricket.scorer.server.persistence.entities;

public class DeliveryAdvice {
	private int deliverySequenceNumber;
	private int legalDeliverySequenceNumber;
	private int overNumber;
	private boolean freeHit = false;
	private int strikerPosition;
	private int nonstrikerPosition;
	
	public DeliveryAdvice () {
		
	}
	
	public int getDeliverySequenceNumber() {
		return deliverySequenceNumber;
	}
	public void setDeliverySequenceNumber(int deliverySequenceNumber) {
		this.deliverySequenceNumber = deliverySequenceNumber;
	}
	public int getLegalDeliverySequenceNumber() {
		return legalDeliverySequenceNumber;
	}
	public void setLegalDeliverySequenceNumber(int legalDeliverySequenceNumber) {
		this.legalDeliverySequenceNumber = legalDeliverySequenceNumber;
	}
	public int getOverNumber() {
		return overNumber;
	}
	public void setOverNumber(int overNumber) {
		this.overNumber = overNumber;
	}
	public boolean isFreeHit() {
		return freeHit;
	}
	public void setFreeHit(boolean freeHit) {
		this.freeHit = freeHit;
	}
	public int getStrikerPosition() {
		return strikerPosition;
	}
	public void setStrikerPosition(int strikerPosition) {
		this.strikerPosition = strikerPosition;
	}
	public int getNonstrikerPosition() {
		return nonstrikerPosition;
	}
	public void setNonstrikerPosition(int nonstrikerPosition) {
		this.nonstrikerPosition = nonstrikerPosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deliverySequenceNumber;
		result = prime * result + (freeHit ? 1231 : 1237);
		result = prime * result + legalDeliverySequenceNumber;
		result = prime * result + nonstrikerPosition;
		result = prime * result + overNumber;
		result = prime * result + strikerPosition;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DeliveryAdvice))
			return false;
		DeliveryAdvice other = (DeliveryAdvice) obj;
		if (deliverySequenceNumber != other.deliverySequenceNumber)
			return false;
		if (freeHit != other.freeHit)
			return false;
		if (legalDeliverySequenceNumber != other.legalDeliverySequenceNumber)
			return false;
		if (nonstrikerPosition != other.nonstrikerPosition)
			return false;
		if (overNumber != other.overNumber)
			return false;
		if (strikerPosition != other.strikerPosition)
			return false;
		return true;
	}
}
