package com.dheeraj.timefactory.worker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.dheeraj.timefactory.model.TimeResponse;

@Component
public class TimeThread extends Thread{
	
	private SimpMessagingTemplate simpMessagingTemplate;
	private String zone;
	
	public TimeThread(String zone, SimpMessagingTemplate simpMessagingTemplate) {
		this.zone = zone;
		this.simpMessagingTemplate = simpMessagingTemplate;
	}
	
	@Override
	public void run() {
		boolean condition = true;
		while (condition) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("earlier thread kill");	
				condition = false;
			}
			TimeZone tz = TimeZone.getTimeZone(zone);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			dateFormat.setTimeZone(tz);
			TimeResponse tResponse = new TimeResponse(zone, dateFormat.format(new Date()));
			simpMessagingTemplate.convertAndSend("/topic/currentTime", tResponse);
		}
	}
	
}
