package com.accenture.sats.server.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Learner {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String eid;
	private LocalDateTime timeIn;
	private LocalDateTime timeOut;
	
	//constructor
	public Learner() {
	}

	public Learner(long id, String eid, LocalDateTime timeIn, LocalDateTime timeOut) {
		this.id = id;
		this.eid = eid;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}
	
	//getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public LocalDateTime getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(LocalDateTime timeIn) {
		this.timeIn = timeIn;
	}

	public LocalDateTime getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(LocalDateTime timeOut) {
		this.timeOut = timeOut;
	}

	@Override
	public String toString() {
		return "Learner [id=" + id + ", eid=" + eid + ", timeIn=" + timeIn + ", timeOut=" + timeOut + "]";
	}
	
	 
	
	
	
	
}
