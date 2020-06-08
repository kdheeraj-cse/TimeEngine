package org.dheeraj.timefactory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@GetMapping("/")
	public String printStartMessage() {
		return "<br/><center><h1>Welcome to Time factory</h1></center>";
	}
	
}
