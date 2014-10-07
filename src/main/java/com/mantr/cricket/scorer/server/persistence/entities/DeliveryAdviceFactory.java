package com.mantr.cricket.scorer.server.persistence.entities;

public class DeliveryAdviceFactory {
	public static DeliveryAdvice createDeliveryAdvice (Delivery delivery) {
		DeliveryAdvice advice = new DeliveryAdvice ();
		
		
		
		//Events 
		boolean legalDelivery = delivery.isLegalDelivery();
		boolean endOfOver = (delivery.getLegalDeliverySequenceNumber() == 6 && legalDelivery);
		
		//If this delivery is a foot no ball, the subsequent delivery should be a 'free-hit'
		if (delivery.getIllegalDeliveryType() == IllegalDelivery.NOBALL_FOOT) {
			advice.setFreeHit(true);
		} 
		
		//Advice on the subsequent ball (over number, delivery sequence and legal delivery sequence)
		if (endOfOver) {
			advice.setOverNumber(delivery.getId().getOverNumber() + 1);
			advice.setDeliverySequenceNumber(1);
			advice.setLegalDeliverySequenceNumber(1);
		}
		else {
			advice.setOverNumber(delivery.getId().getOverNumber());
			advice.setDeliverySequenceNumber(delivery.getId().getDeliverySequence() + 1);
			advice.setLegalDeliverySequenceNumber(delivery.getLegalDeliverySequenceNumber() + (byte)(legalDelivery ? 1 :0));
		}
		
		//Determine the striker and non-striker for the next delivery
		advice.setStrikerPosition(delivery.getStrikerPosition());
		advice.setNonstrikerPosition(delivery.getNonstrikerPosition());
		
		boolean batsmenRetainEnds = (delivery.getBatsmanRuns() % 2 == 0) && (delivery.getExtras() % 2 == 0);
			
		if (delivery.getDismissal()) {
				
			//Someone has been dismissed, determine the position of the next man in 
			int newPosition = (delivery.getStrikerPosition() > delivery.getNonstrikerPosition()) ? delivery.getStrikerPosition() + 1 : delivery.getNonstrikerPosition() + 1;
				
			if (delivery.getHowOut() == Dismissal.RUNOUT) {
				
				batsmenRetainEnds = true;
				
				if (delivery.getDismissalEnd() == DismissalEnd.STRIKER) {
					advice.setStrikerPosition(newPosition);
						
					if (delivery.getStrikerPosition() == delivery.getPositionDismissed()) {
						advice.setNonstrikerPosition(delivery.getNonstrikerPosition());
					}
					else {
						advice.setNonstrikerPosition(delivery.getStrikerPosition());
					}
				}
				else {
					advice.setNonstrikerPosition(newPosition);
						
					if (delivery.getStrikerPosition() == delivery.getPositionDismissed()) {
						advice.setStrikerPosition(delivery.getNonstrikerPosition());
					}
					else {
						advice.setStrikerPosition(delivery.getStrikerPosition());
					}
				}
			}
			else {
				//For other dismissals, its the striker who has been dismissed
					
				advice.setStrikerPosition(newPosition);
				advice.setNonstrikerPosition(delivery.getNonstrikerPosition());					
			}
		}
			
			
		if (endOfOver || !batsmenRetainEnds) {
					
			//Switch Ends
			
			int temp = advice.getStrikerPosition();
			advice.setStrikerPosition(advice.getNonstrikerPosition());
			advice.setNonstrikerPosition(temp);
		}
				
		return advice;
	}
}
