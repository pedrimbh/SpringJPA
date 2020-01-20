package com.jpa.jpaSpring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "people")
public class Person {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	

	@ManyToOne
	@JoinColumn(name = "event_id")
	@JsonBackReference
	private Event eventId;
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Person(Long id, String name, Event eventId) {
		this.id = id;
		this.name = name;
		this.eventId = eventId;
	}
	
	public Person(String name, Event eventId) {
		this.name = name;
		this.eventId = eventId;
	}
	


	public Person(String name) {
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Event getEventId() {
		return eventId;
	}



	public void setEventId(Event eventId) {
		this.eventId = eventId;
	}
	
	
}
