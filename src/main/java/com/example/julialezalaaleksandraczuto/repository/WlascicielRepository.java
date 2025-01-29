package com.example.julialezalaaleksandraczuto.repository;

import com.example.julialezalaaleksandraczuto.model.Wlasciciel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WlascicielRepository extends JpaRepository<Wlasciciel, Long> {
}