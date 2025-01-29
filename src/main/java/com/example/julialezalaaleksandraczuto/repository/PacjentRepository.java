package com.example.julialezalaaleksandraczuto.repository;

import com.example.julialezalaaleksandraczuto.model.Pacjent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacjentRepository extends JpaRepository<Pacjent, Long> {
}