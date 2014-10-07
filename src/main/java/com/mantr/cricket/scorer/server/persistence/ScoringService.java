package com.mantr.cricket.scorer.server.persistence;

import com.mantr.cricket.scorer.server.persistence.entities.*;

import java.util.List;

public interface ScoringService {
	
	public boolean accountExists (String eMailAddress);
	
	public Account createNewAccount (String eMailAddress);
	
	public Account retrieveAccount(String eMailAddress);
	
	public Match createMatch (int accountId, String [] teamNames, String description);
	
	public List<Match> retrieveMatches (String eMailAddress);
	
	public List<Delivery> retrieveDeliveries(int matchId);
	
	public int clearMatchScore (int matchId);
	
	public DeliveryAdvice recordDelivery (
			int matchId,
			byte innings,
			byte overNumber,
			byte deliverySequenceNumber,
			byte legalDeliverySequenceNumber,
			byte strikerPosition,
			byte nonStrikerPosition,
			IllegalDelivery illegalDeliveryType,
			boolean freeHit,
			byte batsmanRuns,
			byte extras,
			Extras extrasType,
			boolean boundary,
			boolean overthrow,
			byte teamTotalRuns,
			boolean dismissal,
			byte positionDismissed,
			Dismissal howOut,
			int assistPlayerId,
			String commentary,
			String notes);
	
	public DeliveryAdvice recordDelivery (Delivery delivery);
	
	public Delivery retrieveDelivery (DeliveryPK deliveryPK);
}
