package com.example.kino.service;

import com.example.kino.model.Showing;
import com.example.kino.repository.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

//TODO: Business logic implementation

@Service
public class ShowingService {

    private ShowingRepository showingRepository;

    @Autowired
    public ShowingService(ShowingRepository showingRepository) {
        this.showingRepository = showingRepository;
    }

    public Showing findById(Long id) {
        return showingRepository.findById(id).orElseThrow(() -> new NoResultException("Showing with id:" + id + " does not exist!"));
    }

    public List<Showing> findAllShowings() {
        return showingRepository.findAll();
    }

    public Showing saveShowing(Showing showing) {
        return showingRepository.save(showing);
    }

    public Showing updateShowing(Showing showing, Long id) {
        Showing showingData = showingRepository.findById(id).orElseThrow(() -> new NoResultException("Showing with id:" + id + " does not exist!"));
        showingData.setShowingId(showing.getShowingId());
        showingData.setMovie(showing.getMovie());
        showingData.setTheater(showing.getTheater());
        showingData.setShowingPrice(showing.getShowingPrice());
        return showingRepository.save(showingData);
    }

    public void deleteShowing(Long id) {
        showingRepository.deleteById(id);
    }


}
