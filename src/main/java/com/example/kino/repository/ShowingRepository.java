package com.example.kino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.kino.model.Showing;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, Long> {
}
