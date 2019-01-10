package com.stackroute.nextevent.repository;

import com.stackroute.nextevent.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,String> {

    Event findByEventId(Long Id);
}

