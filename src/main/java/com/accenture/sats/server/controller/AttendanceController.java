package com.accenture.sats.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sats.server.entity.Learner;
import com.accenture.sats.server.service.AttendanceService;
@RequestMapping("/api/attendance")
@RestController
public class AttendanceController {

	@Autowired
	private AttendanceService service;

	
	@GetMapping("/learners")
	public List<Learner> getLearners() {
		return service.getLearners();
	}
	
	@PostMapping("/timeIn")
	public Learner timeIn(@RequestBody Learner learner) {
		learner =service.timeIn(learner.getEid());
		return learner;
	 }
	 
	@PostMapping("/timeOut")
 	public Learner timeOut(@RequestBody Learner learner) {
 		learner =service.timeOut(learner.getEid());
 		return learner;
 	 }









}
