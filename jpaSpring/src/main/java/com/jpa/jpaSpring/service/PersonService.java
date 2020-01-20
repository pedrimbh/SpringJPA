package com.jpa.jpaSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jpa.jpaSpring.models.Event;
import com.jpa.jpaSpring.models.Person;
import com.jpa.jpaSpring.repository.EventRepository;
import com.jpa.jpaSpring.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private EventRepository eventReposirtory;
	
	public PersonService(PersonRepository personRepository, EventRepository eventReposirtory) {
		this.personRepository = personRepository;
		this.eventReposirtory = eventReposirtory;
	}
	
	public Page<Person> findAll(Long eventId, Pageable pageable){
		Event event = eventReposirtory.findById(eventId).orElse(null);
		Page<Person> people = personRepository.findByEventId(event, pageable);
		return people;
		
	}
	public Person create(Long eventId, Person person) {
		Event event = eventReposirtory.findById(eventId).orElse(null);
		person.setEventId(event);
		personRepository.save(person);
		
		return person;
	}
}
