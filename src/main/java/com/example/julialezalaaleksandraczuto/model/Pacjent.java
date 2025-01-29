package com.example.julialezalaaleksandraczuto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Pacjent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Imię pacjenta nie może być puste")
    private String imie;

    @NotEmpty(message = "Gatunek pacjenta nie może być pusty")
    private String gatunek;

    private String rasa;

    @NotNull(message = "Data urodzenia musi być podana")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataUrodzenia;

    @ManyToOne
    @JoinColumn(name = "wlasciciel_id")
    private Wlasciciel wlasciciel;

    // Konstruktory, gettery, settery
    public Pacjent() {
    }

    public Pacjent(String imie, String gatunek, String rasa, LocalDate dataUrodzenia, Wlasciciel wlasciciel) {
        this.imie = imie;
        this.gatunek = gatunek;
        this.rasa = rasa;
        this.dataUrodzenia = dataUrodzenia;
        this.wlasciciel = wlasciciel;
    }

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public Wlasciciel getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(Wlasciciel wlasciciel) {
        this.wlasciciel = wlasciciel;
    }
}