package com.jpa.jpaSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpa.jpaSpring.models.Event;
import com.jpa.jpaSpring.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	 }
	
	public Page<Event> findAll(Pageable pageable){
		Page<Event> events = eventRepository.findAll(pageable);
		return events;
	}
	
	public Page<Event> findAllSorting(){
		Page<Event> events = (Page<Event>) eventRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC,"id")));
		return events;
	}
	

	public Event create(Event event) {
		eventRepository.save(event);
		return event;
	}
}
