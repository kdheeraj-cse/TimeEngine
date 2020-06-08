package org.dheeraj.timefactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.dheeraj.timefactory.model.TimeRequest;
import com.dheeraj.timefactory.worker.TimeThread;

@Controller
public class TimeController {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	public TimeController() {
		// TODO Auto-generated constructor stub
	}
	
	@MessageMapping("/getTime")
	public void getTime(TimeRequest tRequest) throws InterruptedException {
		for (Thread thread : Thread.getAllStackTraces().keySet()) {
			if(thread.getName().equalsIgnoreCase("timeZone") && thread.isAlive()) {
				thread.interrupt();
			}
		}  
		Thread thread = new TimeThread(tRequest.getTimeZone(), simpMessagingTemplate);
		thread.setName("timeZone");
		thread.start();
	}
	

}
