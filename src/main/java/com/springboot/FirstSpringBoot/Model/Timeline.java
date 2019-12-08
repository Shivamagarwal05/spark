package com.springboot.FirstSpringBoot.Model;

import java.util.List;

public class Timeline
{
	private List<Event> events;

	public List<Event> getEvent() {
		return events;
	}

	public void setEvent(List<Event> event) {
		this.events = event;
	}
	
}
