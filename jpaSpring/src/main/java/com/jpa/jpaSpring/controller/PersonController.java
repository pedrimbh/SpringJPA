package com.jpa.jpaSpring.models.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.jpaSpring.models.Person;
import com.jpa.jpaSpring.service.PersonService;

@RestController
@RequestMapping("/events/{eventId}/people")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping
	@ResponseBody
	public Page<Person> findAll(@PathVariable("eventId") Long eventId, Pageable pageable){
		Page<Person> people = personService.findAll(eventId, pageable);
		return people;
		
//		Event event = eventReposirtory.findById(eventId).orElse(null);
//		
//		List<Person> people = event.getPeople().stream().collect(Collectors.toList());
//		return people;
	}
	@PostMapping
	@ResponseBody
	public Person create(@PathVariable("eventId") Long eventId, @RequestBody Person person) {
		personService.create(eventId, person);
		
		return person;
	}
}
