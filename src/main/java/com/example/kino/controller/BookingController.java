package com.example.kino.controller;

import com.example.kino.model.Booking;
import com.example.kino.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/getBooking/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        Booking booking = bookingService.findById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping("/createBooking")
    public ResponseEntity<Booking> newBooking(@RequestBody Booking booking) throws URISyntaxException {
        Booking result = null;
        result = bookingService.saveBooking(booking);
        return ResponseEntity.created(new URI("/getBooking/" + result.getBookingId())).body((result));
    }

    @PutMapping("/updateBooking/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking tmpBooking = bookingService.updateBooking(booking, id);
        return ResponseEntity.ok().body(tmpBooking);
    }

    @DeleteMapping("/booking/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok().build();
    }



}
