package com.example.kino.repository;

import com.example.kino.model.Candy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("Candy")
@Repository
public interface CandyRepository extends JpaRepository<Candy, Long> {
}
