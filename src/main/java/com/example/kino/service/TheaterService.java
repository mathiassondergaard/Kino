package com.example.kino.service;

import com.example.kino.model.Theater;
import com.example.kino.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TheaterService {

    private TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public Theater findById(Long id) {
        return theaterRepository.findById(id).orElseThrow(() -> new NoResultException("No theater with id:" + id + " exists!"));

    }

    public List<Theater> findAllTheaters() { return theaterRepository.findAll();}

    @Transactional
    @Modifying
    public Theater updateTheater(Theater theater, Long id) {
        Theater theaterData = theaterRepository.findById(id).orElseThrow(() -> new NoResultException("No theater with id:" + id + " exists!"));
        theaterData.setTheaterId(theater.getTheaterId());
        theaterData.setMovie(theater.getMovie());
        theaterData.setStartTime(theater.getStartTime());
        theaterData.setEndTime(theater.getEndTime());
        return theaterRepository.save(theaterData);
    }


}
