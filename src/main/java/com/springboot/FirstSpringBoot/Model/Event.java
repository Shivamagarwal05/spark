package com.springboot.FirstSpringBoot.Model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Event
{
	private Date eventdate;
	private LocalTime eventtime;
	private String eventdesc;
	public Date getEventdate() {
		return eventdate;
	}
	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}
	public LocalTime getEventtime() {
		return eventtime;
	}
	public void setEventtime(LocalTime eventtime) {
		this.eventtime = eventtime;
	}
	public String getEventdesc() {
		return eventdesc;
	}
	public void setEventdesc(String eventdesc) {
		this.eventdesc = eventdesc;
	}
	

}
