package com.example.kino.repository;

import com.example.kino.model.Booking;
import com.example.kino.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
