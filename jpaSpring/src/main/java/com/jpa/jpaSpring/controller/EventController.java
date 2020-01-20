package com.jpa.jpaSpring.models.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.jpaSpring.models.Event;
import com.jpa.jpaSpring.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	 }
	
	@GetMapping
	@ResponseBody
	public Page<Event> findAll(Pageable pageable){
		Page<Event> events = eventService.findAll(pageable);
		return events;
	}
	@GetMapping("/sorting")
	@ResponseBody
	public Page<Event> findAllSorting(){
		Page<Event> events = eventService.findAllSorting();
		return events;
	}
	
	@PostMapping
	@ResponseBody
	public Event create(@RequestBody Event event) {
		eventService.create(event);
		return event;
	}
}
