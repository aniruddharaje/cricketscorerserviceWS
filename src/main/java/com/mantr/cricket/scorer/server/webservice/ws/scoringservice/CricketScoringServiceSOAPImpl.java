
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.mantr.cricket.scorer.server.webservice.ws.scoringservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import javax.management.RuntimeErrorException;



import org.apache.openjpa.lib.log.Log;

import com.mantr.cricket.cricketscoringservice._interface.CricketScorerServicePortType;
import com.mantr.cricket.scorer.server.persistence.ScoringService;
import com.mantr.cricket.cricketscoringservice.schema.*;
import com.mantr.cricket.scorer.server.persistence.entities.*;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-13T13:24:14.710-05:00
 * Generated source version: 3.0.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "CricketScoringService",
                      portName = "CricketScoringServiceSOAP",
                      targetNamespace = "http://www.mantr.com/cricket/CricketScoringService/service",
                      wsdlLocation = "file:/C:/Users/aniruddha.raje/Development/mvnprojects/cricketscorerserviceWS/src/main/resources/CricketScoringService.wsdl",
                      endpointInterface = "com.mantr.cricket.cricketscoringservice._interface.CricketScorerServicePortType")
                      
public class CricketScoringServiceSOAPImpl implements CricketScorerServicePortType {

	private ScoringService persistenceService;

    private static final Logger LOG = Logger.getLogger(CricketScoringServiceSOAPImpl.class.getName());

    ScoringServiceDataMapper dataMapper;

    public CricketScoringServiceSOAPImpl (ScoringService service, ScoringServiceDataMapper mapper) {
	    persistenceService = service;
	    dataMapper = mapper;
    }

    /* (non-Javadoc)
     * @see com.mantr.cricket.cricketscoringservice._interface.CricketScorerServicePortType#clearMatchScore(int  matchId )*
     */
    public int clearMatchScore(int matchId) {
        LOG.info("Executing operation clearMatchScore");
        
        return persistenceService.clearMatchScore(matchId);
    }

    /* (non-Javadoc)
     * @see com.mantr.cricket.cricketscoringservice._interface.CricketScorerServicePortType#retrieveDeliveries(int  matchId )*
     */
    public List<DeliveryTransferObject> retrieveDeliveries(int matchId) { 
        LOG.info("Executing operation retrieveDeliveries");
        
        List<Delivery> deliveries = persistenceService.retrieveDeliveries(matchId);
        
        List<DeliveryTransferObject> deliveriesTransferObjects = new ArrayList<DeliveryTransferObject>();
        
        Iterator<Delivery> deliveryIterator = deliveries.iterator();
        while (deliveryIterator.hasNext()) {
        	
        	try {
        		deliveriesTransferObjects.add(dataMapper.map(deliveryIterator.next()));
        	}
        	catch (DatatypeConfigurationException dtce) {
        		dtce.printStackTrace();
        		throw new RuntimeException(dtce);
        	}
        	
        }
        
        return deliveriesTransferObjects;
    }

    /* (non-Javadoc)
     * @see com.mantr.cricket.cricketscoringservice._interface.CricketScorerServicePortType#recordDelivery(com.mantr.cricket.cricketscoringservice.schema.DeliverySpec  delivery )*
     */
    public DeliveryAdviceTransferObject recordDelivery(DeliveryTransferObject delivery) { 
        LOG.info("Executing operation recordDelivery");
        
        Delivery d = dataMapper.map(delivery);
        
        DeliveryAdvice deliveryAdvice = persistenceService.recordDelivery(d);
        
        return dataMapper.map(deliveryAdvice);
    }

    /* (non-Javadoc)
     * @see com.mantr.cricket.cricketscoringservice._interface.CricketScorerServicePortType#createNewAccount(java.lang.String  emailaddress )*
     */
    public AccountTransferObject createNewAccount(java.lang.String emailaddress) { 
        LOG.info("Executing operation createNewAccount");
        
        Account account = persistenceService.createNewAccount(emailaddress);
        
        AccountTransferObject accountTransferObject = null;
        try {
        	accountTransferObject = dataMapper.map(account);
        	System.out.println("Mapping Done");
        }
    	catch (DatatypeConfigurationException dtce) {
    		LOG.info(dtce.getMessage());
    		dtce.printStackTrace();
    		throw new RuntimeException(dtce);
    	}
        
        return accountTransferObject;
     
    }

    /* (non-Javadoc)
     * @see com.mantr.cricket.cricketscoringservice._interface.CricketScorerServicePortType#retrieveMatches(java.lang.String  emailaddress )*
     */
    public List<MatchTransferObject> retrieveMatches(String emailaddress) {
    	
    	LOG.info("Executing operation retrieveMatches");
        
        List<Match> matches = persistenceService.retrieveMatches(emailaddress);
        
        List<MatchTransferObject> matchTransferObjects = new ArrayList<MatchTransferObject>();
        
        if (matches != null ) {
        	Iterator<Match> matchIterator = matches.iterator();
        
        	while (matchIterator.hasNext()) {
        	
        		try {
        			matchTransferObjects.add(dataMapper.map(matchIterator.next()));
        		}
        		catch (DatatypeConfigurationException dtce) {
        			dtce.printStackTrace();
        			throw new RuntimeException(dtce);
        		}
        	
        	}
        }
        
        return matchTransferObjects;
    }

    /* (non-Javadoc)
     * @see com.mantr.cricket.cricketscoringservice._interface.CricketScorerServicePortType#retrieveAccount(java.lang.String  emailaddress )*
     */
    public AccountTransferObject retrieveAccount(String emailaddress) {
    	
    	LOG.info("Executing operation retrieveAccount");
    	
    	Account account = persistenceService.retrieveAccount(emailaddress);
    	
    	AccountTransferObject accountTransferObject = null;
    	
    	try {
    		accountTransferObject = dataMapper.map(account);
    	}
    	catch (DatatypeConfigurationException dtce) {
    		dtce.printStackTrace();
    		throw new RuntimeException(dtce);
    	}
    	
    	return accountTransferObject;
    }

    /* (non-Javadoc)
     * @see com.mantr.cricket.cricketscoringservice._interface.CricketScorerServicePortType#createMatch(int  accountId ,)java.util.List<com.mantr.cricket.cricketscoringservice.schema.Team>  team ,)java.lang.String  description )*
     */
    public MatchTransferObject createMatch(int accountId, List<String> team, String description) { 
    	LOG.info("Executing operation createMatch");
    	
    	try {
    		return dataMapper.map(persistenceService.createMatch(accountId, team.toArray(new String[2]), description));
    	}
    	catch (DatatypeConfigurationException dtce) {
    		dtce.printStackTrace();
    		throw new RuntimeException(dtce);
    	}
    }

    /* (non-Javadoc)
     * @see com.mantr.cricket.cricketscoringservice._interface.CricketScorerServicePortType#retrieveDelivery(com.mantr.cricket.cricketscoringservice.schema.DeliveryKey  key )*
     */
    public DeliveryTransferObject retrieveDelivery(DeliveryKeyTransferObject key) {
    	
    	LOG.info("Executing operation retrieveDelivery");
    	
    	try {
    		return dataMapper.map(persistenceService.retrieveDelivery(dataMapper.map(key)));
    	}
    	catch (DatatypeConfigurationException dtce) {
    		dtce.printStackTrace();
    		throw new RuntimeException(dtce);
    	}
    }

}
