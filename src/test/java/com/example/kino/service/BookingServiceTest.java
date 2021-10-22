package com.example.kino.service;

import com.example.kino.model.Booking;
import com.example.kino.repository.BookingRepository;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.Optional;

class BookingServiceTest {

    private AutoCloseable autoCloseable;

    @InjectMocks
    private BookingService bookingService;
    @Mock
    private BookingRepository bookingRepository;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @After
    void releaseMocks() throws Exception {
        autoCloseable.close();
    }

    @Test
    void findById() {
        Mockito.when(bookingRepository.findById(1L)).thenReturn(Optional.of(new Booking(1L, LocalDate.of(2020, 05, 10))));
        Booking booking = this.bookingRepository.findById(1L).orElseThrow(() -> new NoResultException("Unable to find booking by id"));
        Assertions.assertEquals(LocalDate.of(2020, 05, 10), booking.getShowingDate());
    }

    @Test
    void testSaveBooking() {
        Booking booking = new Booking(1L, LocalDate.of(2021, 10, 22), 25, "Cinemax");
        this.bookingRepository.save(booking);
        Mockito.verify(this.bookingRepository, Mockito.times(1));
        System.out.println(booking);
    }

    @Test
    void testDelete() {
        Booking booking = new Booking(1L, LocalDate.of(2021, 10, 22), 25, "Cinemax");
        this.bookingRepository.delete(booking);
        Mockito.verify(this.bookingRepository, Mockito.times(1)).delete(booking);

    }

}