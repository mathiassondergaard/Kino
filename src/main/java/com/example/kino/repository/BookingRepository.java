package com.example.kino.repository;

import com.example.kino.model.Booking;
import com.example.kino.payload.response.BookingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT new com.example.kino.payload.response.BookingResponse(b.bookingId, b.nrOfAssignedSeats, b.theater, b.movie.movieTitle, b.showingDate, b.showingTime) FROM Booking b WHERE b.showingDate = :date")
    List<BookingResponse> findBookingsMatchingDate(@Param("date") LocalDate localDate);

}
