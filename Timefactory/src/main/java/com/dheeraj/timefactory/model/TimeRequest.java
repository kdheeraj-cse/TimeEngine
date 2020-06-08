package com.dheeraj.timefactory.model;

public class TimeRequest {
	
	private String timeZone;
	
	public TimeRequest() {
		
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	@Override
	public String toString() {
		return this.timeZone;
	}
	
}
