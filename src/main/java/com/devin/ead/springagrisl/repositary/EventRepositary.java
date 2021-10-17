package com.devin.ead.springagrisl.repositary;

import com.devin.ead.springagrisl.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepositary extends JpaRepository<Event, Long> {

}
