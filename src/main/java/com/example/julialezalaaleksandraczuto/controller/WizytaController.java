package com.example.julialezalaaleksandraczuto.controller;

import com.example.julialezalaaleksandraczuto.model.Pacjent;
import com.example.julialezalaaleksandraczuto.model.Wizyta;
import com.example.julialezalaaleksandraczuto.repository.PacjentRepository;
import com.example.julialezalaaleksandraczuto.repository.WizytaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/wizyty")
public class WizytaController {

    private final WizytaRepository wizytaRepository;
    private final PacjentRepository pacjentRepository;

    public WizytaController(WizytaRepository wizytaRepository, PacjentRepository pacjentRepository) {
        this.wizytaRepository = wizytaRepository;
        this.pacjentRepository = pacjentRepository;
    }

    @GetMapping
    public String listaWizyt(Model model) {
        List<Wizyta> wizyty = wizytaRepository.findAll();
        model.addAttribute("wizyty", wizyty);
        return "lista_wizyt";
    }

    @GetMapping("/dodaj")
    public String formularzDodawaniaWizyty(Model model) {
        model.addAttribute("wizyta", new Wizyta());
        model.addAttribute("pacjenci", pacjentRepository.findAll());
        return "dodaj_wizyte";
    }

    @PostMapping("/dodaj")
    public String zapiszWizyte(@Valid Wizyta wizyta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pacjenci", pacjentRepository.findAll());
            return "dodaj_wizyte";
        }
        wizytaRepository.save(wizyta);
        return "redirect:/wizyty";
    }

    @GetMapping("/usun/{id}")
    public String usunWizyte(@PathVariable Long id) {
        wizytaRepository.deleteById(id);
        return "redirect:/wizyty";
    }
}