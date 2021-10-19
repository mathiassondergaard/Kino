package com.example.kino.controller;

import com.example.kino.model.Booking;
import com.example.kino.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:5000"})
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        Booking booking = bookingService.findById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @PostMapping("/booking/createBooking")
    public ResponseEntity<Booking> newBooking(@RequestBody Booking booking) throws URISyntaxException {
        Booking result = null;
        result = bookingService.saveBooking(booking);
        return ResponseEntity.created(new URI("/getBooking/" + result.getBookingId())).body((result));
    }

    @PutMapping("/booking/edit/{id}")
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
