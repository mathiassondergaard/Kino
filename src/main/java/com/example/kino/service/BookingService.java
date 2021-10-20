package com.example.kino.service;

import com.example.kino.model.Booking;
import com.example.kino.model.Movie;
import com.example.kino.payload.request.BookingRequest;
import com.example.kino.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new NoResultException("Booking with id: " + id + "does not exist!"));
    }

    public List<Booking> getAllBookings() {
        try {
            return bookingRepository.findAll();
        }
        catch (Exception e) {
            throw new NoResultException("No bookings exist in system!");
        }
    }

    public Booking saveBooking(BookingRequest bookingRequest, Movie movie) {
        Booking booking = new Booking();
        booking.setNrOfAssignedSeats(bookingRequest.getNrOfAssignedSeats());
        booking.setTheater(bookingRequest.getTheater());
        booking.setShowingDate(bookingRequest.getShowingDate());
        booking.setShowingTime(bookingRequest.getShowingTime());
        booking.setMovie(movie);
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new NoResultException("Booking with id: " + id + "does not exist!"));
        booking.setMovie(null);
        bookingRepository.delete(booking);
    }
}
