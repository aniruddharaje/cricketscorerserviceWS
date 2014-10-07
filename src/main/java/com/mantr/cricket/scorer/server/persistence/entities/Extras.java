package com.mantr.cricket.scorer.server.persistence.entities;

public enum Extras {
	LEGBYES ("L"),
	BYES ("B"),
	WIDES ("W");
	
	private String value;
	
	private Extras (String e) {
		this.value = e;
	}
	
	public String getValue () {
		return value;
	}
	
	public static Extras parse (String e) {
		Extras extras = null;
		if (e != null) {
			for (Extras item : Extras.values()) {
	            if (item.getValue().equals(e)) {
	                extras = item;
	                break;
	            }
	        }
		}
		
		return extras;
	}
}
