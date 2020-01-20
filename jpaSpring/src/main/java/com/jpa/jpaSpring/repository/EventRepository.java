package com.jpa.jpaSpring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jpa.jpaSpring.models.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

}
