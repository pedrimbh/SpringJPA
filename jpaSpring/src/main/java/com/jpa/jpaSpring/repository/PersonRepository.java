package com.jpa.jpaSpring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jpa.jpaSpring.models.Event;
import com.jpa.jpaSpring.models.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	Page<Person> findByEventId(Event eventId, Pageable pageable);
}
