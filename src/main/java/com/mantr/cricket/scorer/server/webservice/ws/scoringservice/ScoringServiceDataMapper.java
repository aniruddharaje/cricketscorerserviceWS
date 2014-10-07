package com.mantr.cricket.scorer.server.webservice.ws.scoringservice;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import com.mantr.cricket.cricketscoringservice.schema.DeliveryTransferObject;
import com.mantr.cricket.scorer.server.persistence.entities.*;
import com.mantr.cricket.cricketscoringservice.schema.*;

public class ScoringServiceDataMapper {
	
	ObjectFactory transferObjectFactory = null;
	
	public ScoringServiceDataMapper (ObjectFactory of) {
		transferObjectFactory = of;
	}
	
	public DeliveryTransferObject map (Delivery delivery) throws DatatypeConfigurationException {
		DeliveryTransferObject deliveryTransferObject = transferObjectFactory.createDeliveryTransferObject();
		DeliveryKeyTransferObject deliveryKeyTransferObject = transferObjectFactory.createDeliveryKeyTransferObject();
		
		deliveryTransferObject.setKey(deliveryKeyTransferObject);
		
		//Map the Delivery Key
		deliveryKeyTransferObject.setDeliverySequence(delivery.getId().getDeliverySequence());
		deliveryKeyTransferObject.setOver(delivery.getId().getOverNumber());
		deliveryKeyTransferObject.setInnings(delivery.getId().getInnings());
		deliveryKeyTransferObject.setMatchId(delivery.getId().getMatchId());
		
		//Map the Delivery 
		deliveryTransferObject.setLegalDeliverySequenceNumber(delivery.getLegalDeliverySequenceNumber());
		
		deliveryTransferObject.setStrikerPosition(delivery.getStrikerPosition());
		deliveryTransferObject.setNonstrikerPosition(delivery.getNonstrikerPosition());
		
		deliveryTransferObject.setIllegalDeliveryType(delivery.getIllegalDeliveryType() == null ? null : delivery.getIllegalDeliveryType().getValue());
		deliveryTransferObject.setFreehitInd(delivery.getFreeHitInd());
		
		deliveryTransferObject.setBatsmanRuns(delivery.getBatsmanRuns());
		deliveryTransferObject.setExtras(delivery.getExtras());
		deliveryTransferObject.setBoundary(delivery.getBoundary());
		deliveryTransferObject.setOverthrow(delivery.getOverthrow());
		deliveryTransferObject.setTeamTotalRuns(delivery.getTeamTotalRuns());
		
		deliveryTransferObject.setDismissal(delivery.getDismissal());
		deliveryTransferObject.setPositionDisissed(delivery.getPositionDismissed());
		deliveryTransferObject.setHowOut(delivery.getHowOut() == null ? null : delivery.getHowOut().getValue());
		deliveryTransferObject.setDismissalEnd(delivery.getDismissalEnd() == null ? null : delivery.getDismissalEnd().getValue());
		deliveryTransferObject.setAssistId(delivery.getPlayer() == null ? 0 : delivery.getPlayer().getPlayerId());
		
		deliveryTransferObject.setCommentary(delivery.getDeliveryCommentary());
		deliveryTransferObject.setNotes(delivery.getNotes());
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTimeInMillis(delivery.getDeliveryTime().getTime());
		deliveryTransferObject.setDeliveryTimestamp(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
		
		
		return deliveryTransferObject;
	
	}

	public DeliveryPK map(DeliveryKeyTransferObject deliveryKeyTransferObject) {
		DeliveryPK deliveryKey = new DeliveryPK();
		
		deliveryKey.setMatchId(deliveryKeyTransferObject.getMatchId());
		deliveryKey.setInnings(deliveryKeyTransferObject.getInnings());
		deliveryKey.setOverNumber(deliveryKeyTransferObject.getOver());
		deliveryKey.setDeliverySequence(deliveryKeyTransferObject.getDeliverySequence());
		
		
		return deliveryKey;
		
	}
	
	public Delivery map (DeliveryTransferObject deliveryTransferObject) {
		
		Delivery delivery = new Delivery();
		
		
		//Map the delivery Key
		delivery.setId(map(deliveryTransferObject.getKey()));
		
		
		//Map the Delivery
		delivery.setLegalDeliverySequenceNumber((byte)deliveryTransferObject.getLegalDeliverySequenceNumber());
		delivery.setStrikerPosition((byte)deliveryTransferObject.getStrikerPosition());
		delivery.setNonstrikerPosition((byte)deliveryTransferObject.getNonstrikerPosition());
		
		delivery.setIllegalDeliveryType(IllegalDelivery.parse(deliveryTransferObject.getIllegalDeliveryType()));
		delivery.setFreeHitInd(deliveryTransferObject.isFreehitInd());
		
		delivery.setBatsmanRuns((byte)deliveryTransferObject.getBatsmanRuns());
		delivery.setExtras((byte)deliveryTransferObject.getExtras());
		delivery.setBoundary(deliveryTransferObject.isBoundary());
		delivery.setOverthrow(deliveryTransferObject.isOverthrow());
		delivery.setTeamTotalRuns((byte)deliveryTransferObject.getTeamTotalRuns());
		

		delivery.setDismissal(deliveryTransferObject.isDismissal());
		delivery.setPositionDismissed((byte)deliveryTransferObject.getPositionDisissed());
		delivery.setHowOut(Dismissal.parse(deliveryTransferObject.getHowOut()));
		delivery.setDismissalEnd(DismissalEnd.parse(deliveryTransferObject.getDismissalEnd()));
		
		
		
		
		delivery.setDeliveryCommentary(deliveryTransferObject.getCommentary());
		delivery.setNotes(deliveryTransferObject.getNotes());
		
		//delivery.setDeliveryTime(new Timestamp(deliveryTransferObject.getDeliveryTimestamp().toGregorianCalendar().getTimeInMillis()));
		
		
		return delivery;
	
	}
	
	DeliveryAdviceTransferObject map(DeliveryAdvice advice) {
		DeliveryAdviceTransferObject deliveryAdviceTransferObject = transferObjectFactory.createDeliveryAdviceTransferObject();
		
		deliveryAdviceTransferObject.setDeliverySequenceNumber(advice.getDeliverySequenceNumber());
		deliveryAdviceTransferObject.setLegalDeliverySequenceNumber(advice.getLegalDeliverySequenceNumber());
		deliveryAdviceTransferObject.setOverNumber(advice.getOverNumber());
		deliveryAdviceTransferObject.setFreehit(advice.isFreeHit());
		deliveryAdviceTransferObject.setStrikerPosition(advice.getStrikerPosition());
		deliveryAdviceTransferObject.setNonStrikerPosition(advice.getNonstrikerPosition());
		
		return deliveryAdviceTransferObject;
	}
	
	AccountTransferObject map(Account account) throws DatatypeConfigurationException {
		
		System.out.println("Mapping Account to TO");
		AccountTransferObject accountTransferObject = transferObjectFactory.createAccountTransferObject();
		
		accountTransferObject.setAccountId(account.getAccountId());
		accountTransferObject.setEmailaddress(account.getEmailAddress());
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTimeInMillis(account.getAccountCreateDate().getTime());
		accountTransferObject.setCreateDatetime(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
		
		List<Match> matches = account.getMatches();
		
		
		if (matches != null)
		{
			Iterator<Match> matchIterator = matches.iterator();
			while(matchIterator.hasNext()) {
				accountTransferObject.getCricketMatch().add(map(matchIterator.next()));
			}
		}
		
		return accountTransferObject;
	}
	
	MatchTransferObject map(Match match) throws DatatypeConfigurationException {
		MatchTransferObject matchTransferObject = transferObjectFactory.createMatchTransferObject();
		matchTransferObject.setMatchId(match.getMatchId());
		matchTransferObject.setDescription(match.getDescription());
		
		{
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(match.getMatchDate());
			matchTransferObject.setMatchDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
		}
		
		{
			GregorianCalendar c = new GregorianCalendar();
			c.setTimeInMillis(match.getCreateDateTime().getTime());
			matchTransferObject.setCreateDatetime(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
		}
		
		List<Team> teams = match.getTeams();
		
		
		if (teams != null)
		{
			Iterator<Team> teamIterator = teams.iterator();
			while(teamIterator.hasNext()) {
				matchTransferObject.getMatchTeam().add(map(teamIterator.next()));
			}
		}
		
		List<Delivery> deliveries = match.getDeliveries();
		
		
		if (deliveries != null)
		{
			Iterator<Delivery> deliveryIterator = deliveries.iterator();
			while(deliveryIterator.hasNext()) {
				matchTransferObject.getDelivery().add(map(deliveryIterator.next()));
			}
		}
		
		
		
		return matchTransferObject;
	}
	
	TeamTransferObject map(Team team) {
		TeamTransferObject teamTransferObject = transferObjectFactory.createTeamTransferObject();
		
		teamTransferObject.setTeamId(team.getTeamId());
		teamTransferObject.setBattingInnings(team.getBattingInnings());
		teamTransferObject.setName(team.getTeamName());
		
		List<Player> players = team.getPlayers();
		
		if (players != null) {
			Iterator<Player> playerIterator = players.iterator();
			while(playerIterator.hasNext()) {
				teamTransferObject.getTeamPlayer().add(map(playerIterator.next()));
			}
		}
		
		return teamTransferObject;
	}
	
	PlayerTransferObject map(Player player) {
		PlayerTransferObject playerTransferObject = transferObjectFactory.createPlayerTransferObject();
		
		playerTransferObject.setPlayerId(player.getPlayerId());
		playerTransferObject.setFirstName(player.getFirstName());
		playerTransferObject.setLastName(player.getLastName());
		playerTransferObject.setBattingPosition(player.getBattingPosition());
		playerTransferObject.setBowlingPosition(player.getBowlingPosition());
		
		return playerTransferObject;
	}
	

}
