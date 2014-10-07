package com.mantr.cricket.scorer.server.persistence.entities;

public enum Dismissal {
	RETIRED ("R"),
	BOWLED ("B"),
	TIMEDOUT ("T"),
	CAUGHT ("C"),
	HANDLED_BALL ("H"),
	HITBALL_TWICE ("2"),
	HITWICKET ("W"),
	LBW ("L"),
	OBSTRUCTING_FIELD ("O"),
	STUMPED ("S"),
	RUNOUT ("N");
	
	private String value;
	
	private Dismissal (String d) {
		this.value = d;
	}
	
	public String getValue () {
		return value;
	}
	
	public static Dismissal parse (String code) {
		Dismissal dismissal = null;
		if (code != null) {
			for (Dismissal item : Dismissal.values()) {
	            if (item.getValue().equals(code)) {
	                dismissal = item;
	                break;
	            }
	        }
		}
		
		return dismissal;
	}
}
