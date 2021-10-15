package com.example.kino.service;


import com.example.kino.model.Calendar;
import com.example.kino.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class CalendarService {

    private CalendarRepository calendarRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar findById(Long id) {
        return calendarRepository.findById(id).orElseThrow(() -> new NoResultException("No calendar with id:" + id + " exists!"));
    }


}
