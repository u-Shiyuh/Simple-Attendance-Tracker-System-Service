package com.accenture.sats.server.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.sats.server.entity.Learner;
import com.accenture.sats.server.exception.AttendanceException;
import com.accenture.sats.server.repository.LearnerRepository;

@Service
public class AttendanceService {
	
	
@Autowired
private LearnerRepository repository;


public AttendanceService() {
}


public List<Learner> getLearners(){
	return repository.findAll();
}

public Learner timeIn(String eid){
	Learner tempLearner = repository.findByEid(eid);
	
	if(tempLearner == null) {
		Learner newLearner = new Learner();
		newLearner.setEid(eid);
		newLearner.setTimeIn(LocalDateTime.now());
		repository.save(newLearner);
		tempLearner = newLearner;
	}
	else if(tempLearner.getTimeIn()==null) {
		tempLearner.setTimeIn(LocalDateTime.now());
		repository.save(tempLearner);
		}
	else {
		throw new AttendanceException("Conflicttimein");
	}
	return tempLearner;
		
}


public Learner timeOut(String eid){
	Learner tempLearner = repository.findByEid(eid);
	if(tempLearner == null) {
		throw new AttendanceException("Not Found");
	}else if(tempLearner.getTimeOut()!=null) {
		throw new AttendanceException("Conflicttimeout");
	}else {
		tempLearner.setTimeOut(LocalDateTime.now());
		repository.save(tempLearner);
	}
	
	
	return tempLearner;
		
}






}
