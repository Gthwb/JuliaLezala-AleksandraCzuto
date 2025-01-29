package com.example.julialezalaaleksandraczuto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Wlasciciel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Imię nie może być puste")
    @Size(min = 2, max = 50, message = "Imię musi mieć od 2 do 50 znaków")
    private String imie;

    @NotEmpty(message = "Nazwisko nie może być puste")
    @Size(min = 2, max = 50, message = "Nazwisko musi mieć od 2 do 50 znaków")
    private String nazwisko;

    @Pattern(regexp = "\\d{9}", message = "Numer telefonu musi składać się z 9 cyfr")
    private String numerTelefonu;

    @Email(message = "Nieprawidłowy format adresu email")
    private String email;

    @OneToMany(mappedBy = "wlasciciel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pacjent> pacjenci = new ArrayList<>();

    public Wlasciciel() {
    }

    public Wlasciciel(String imie, String nazwisko, String numerTelefonu, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerTelefonu = numerTelefonu;
        this.email = email;
    }

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

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pacjent> getPacjenci() {
        return pacjenci;
    }

    public void setPacjenci(List<Pacjent> pacjenci) {
        this.pacjenci = pacjenci;
    }

}