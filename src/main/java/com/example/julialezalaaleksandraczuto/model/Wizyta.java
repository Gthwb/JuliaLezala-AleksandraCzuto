package com.example.julialezalaaleksandraczuto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
public class Wizyta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Data i godzina wizyty musi być podana")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dataCzas;

    @NotEmpty(message = "Opis wizyty nie może być pusty")
    private String opis;

    @ManyToOne
    @JoinColumn(name = "pacjent_id")
    private Pacjent pacjent;

    public Wizyta() {
    }

    public Wizyta(LocalDateTime dataCzas, String opis, Pacjent pacjent) {
        this.dataCzas = dataCzas;
        this.opis = opis;
        this.pacjent = pacjent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCzas() {
        return dataCzas;
    }

    public void setDataCzas(LocalDateTime dataCzas) {
        this.dataCzas = dataCzas;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }
}