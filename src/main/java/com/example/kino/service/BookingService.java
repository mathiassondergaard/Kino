package com.example.kino.service;

import com.example.kino.model.Booking;
import com.example.kino.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

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

    @Transactional
    @Modifying
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Transactional
    @Modifying
    public Booking updateBooking(Booking booking, Long id) {
        Booking bookingData = bookingRepository.findById(id).orElseThrow(() -> new NoResultException("Booking with id: " + id + "does not exist!"));
        bookingData.setBookingId(booking.getBookingId());
        booking.setTheater(booking.getTheater());
        booking.setNrOfAssignedSeats(booking.getNrOfAssignedSeats());
        return bookingRepository.save(bookingData);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
