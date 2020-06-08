package com.dheeraj.timefactory.model;

public class TimeResponse {
	private String currentZone;
	private String currentTime;
	
	public TimeResponse() {
		
	}
	
	public TimeResponse(String currentZone, String currentTime) {
		super();
		this.currentZone = currentZone;
		this.currentTime = currentTime;
	}


	public String getCurrentTime() {
		return currentTime;
	}

	public String getCurrentZone() {
		return currentZone;
	}
	
}
