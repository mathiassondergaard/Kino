package com.example.kino.controller;

import com.example.kino.model.Booking;
import com.example.kino.model.Movie;
import com.example.kino.payload.request.BookingRequest;
import com.example.kino.payload.response.BookingResponse;
import com.example.kino.service.BookingService;
import com.example.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:5000"})
public class BookingController {

    private BookingService bookingService;
    private MovieService movieService;

    @Autowired
    public BookingController(BookingService bookingService, MovieService movieService) {
        this.bookingService = bookingService;
        this.movieService = movieService;
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<BookingResponse> getBooking(@PathVariable Long id) {
        Booking result = bookingService.findById(id);
        return ResponseEntity.ok(new BookingResponse(
                result.getBookingId(),
                result.getNrOfAssignedSeats(),
                result.getTheater(),
                result.getMovie().getMovieTitle(),
                result.getShowingDate(),
                result.getShowingTime()
        ));
    }

    @GetMapping("/booking/bookings")
    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        List<BookingResponse> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/booking/bookingsFromDate/{localDate}")
    public ResponseEntity<List<BookingResponse>> getBookingsFromDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate ) {
        List<BookingResponse> bookings = bookingService.getBookingsFromDate(localDate);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @PostMapping("/booking/createBooking")
    public ResponseEntity<BookingResponse> newBooking(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) BookingRequest bookingRequest) throws URISyntaxException {
        Movie movieFromRequest = movieService.findById(bookingRequest.getMovieId());
        Booking result = bookingService.saveBooking(bookingRequest, movieFromRequest);
        return ResponseEntity.ok(new BookingResponse(
                result.getBookingId(),
                result.getNrOfAssignedSeats(),
                result.getTheater(),
                result.getMovie().getMovieTitle(),
                result.getShowingDate(),
                result.getShowingTime()
        ));
    }

    @DeleteMapping("/booking/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok().build();
    }



}
