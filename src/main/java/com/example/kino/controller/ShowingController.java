package com.example.kino.controller;

import com.example.kino.model.Showing;
import com.example.kino.service.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;


@Controller
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:5000"})
public class ShowingController {

    private ShowingService showingService;

    @Autowired
    public ShowingController(ShowingService showingService) {
        this.showingService = showingService;
    }

    @GetMapping("/saveShowing")
        public ResponseEntity<Showing> newShowing(@RequestBody Showing showing) throws URISyntaxException {
        Showing result = null;
        result = showingService.saveShowing(showing);
        return ResponseEntity.created(new URI("/GetShowing/" + result.getShowingId())).body((result));
    }

    @PutMapping("/updateShowing/{id}")
    public ResponseEntity<Showing> updateShowing(@PathVariable Long id, @RequestBody Showing showing) {
        Showing tmpShowing = showingService.updateShowing(showing, id);
        return ResponseEntity.ok().body(tmpShowing);
    }

    @DeleteMapping("/showing/delete/{id}")
    public ResponseEntity<?> deleteShowing(@PathVariable Long id) {
        showingService.deleteShowing(id);
        return ResponseEntity.ok().build();
    }

}
