package com.mantr.cricket.scorer.server.persistence.entities;

public enum DismissalEnd {
	STRIKER ("S"),
	NONSTRIKER ("N");
	
	private String value;
	
	private DismissalEnd (String s) {
		value = s;
	}
	
	public String getValue () {
		return value;
	}
	
	public static DismissalEnd parse (String s) {
		DismissalEnd dismissalEnd = null;
		
		if (s != null) {
			for (DismissalEnd item : DismissalEnd.values()) {
				if (item.getValue().equals(s)) {
					dismissalEnd = item;
					break;
				}
			}
		}
		return dismissalEnd;
	}
}
