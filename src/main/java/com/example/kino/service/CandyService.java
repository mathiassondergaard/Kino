package com.example.kino.service;

import com.example.kino.model.Candy;
import com.example.kino.repository.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;

@Service
public class CandyService {

    private CandyRepository candyRepository;

    @Autowired
    public CandyService(CandyRepository candyRepository){
        this.candyRepository = candyRepository;
    }

    public Candy findById(Long id){
        return candyRepository.findById(id).orElseThrow(()-> new NoResultException("Candy with id: " + id + " does not exist!"));
    }

    public List<Candy> findAll(){
        return candyRepository.findAll();
    }

    public Candy saveCandy(Candy candy){
        return candyRepository.save(candy);
    }

    public Candy updateCandy(Candy candy, Long id){
        Candy candyData = candyRepository.findById(id).orElseThrow(()-> new NoResultException("Candy with id: " + id + " does not exist!"));
        candyData.setCandyID(candy.getCandyID());
        candyData.setCandyName(candy.getCandyName());
        candyData.setCandyPrice(candy.getCandyPrice());
        return candyRepository.save(candyData);
    }

    public void deleteCandy(Long id){
        candyRepository.deleteById(id);
    }
}
