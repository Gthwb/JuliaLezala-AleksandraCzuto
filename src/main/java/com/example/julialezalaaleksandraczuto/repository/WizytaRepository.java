package com.example.julialezalaaleksandraczuto.repository;

import com.example.julialezalaaleksandraczuto.model.Wizyta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WizytaRepository extends JpaRepository<Wizyta, Long> {
}