package com.mantr.cricket.scorer.server.persistence.entities;

public enum IllegalDelivery {
	WIDE ("W"),
	NOBALL ("N"),
	NOBALL_FOOT ("F");
	
	private String value;
	
	private IllegalDelivery (String c) {
		value = c;
	}
	
	public String getValue () {
		return value;
	}
	
	public static IllegalDelivery parse (String c) {
		IllegalDelivery illegalDelivery = null;
		
		if (c != null) {
			for (IllegalDelivery item : IllegalDelivery.values()) {
				if (item.getValue().equals(c)) {
					illegalDelivery = item;
					break;
				}
			}
		}
		return illegalDelivery;
	}
}
