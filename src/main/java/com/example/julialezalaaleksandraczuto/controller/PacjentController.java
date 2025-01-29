package com.example.julialezalaaleksandraczuto.controller;

import com.example.julialezalaaleksandraczuto.model.Pacjent;
import com.example.julialezalaaleksandraczuto.model.Wlasciciel;
import com.example.julialezalaaleksandraczuto.repository.PacjentRepository;
import com.example.julialezalaaleksandraczuto.repository.WlascicielRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pacjenci")
public class PacjentController {

    private final PacjentRepository pacjentRepository;
    private final WlascicielRepository wlascicielRepository;

    public PacjentController(PacjentRepository pacjentRepository, WlascicielRepository wlascicielRepository) {
        this.pacjentRepository = pacjentRepository;
        this.wlascicielRepository = wlascicielRepository;
    }

    @GetMapping
    public String listaPacjentow(Model model) {
        List<Pacjent> pacjenci = pacjentRepository.findAll();
        model.addAttribute("pacjenci", pacjenci);
        return "lista_pacjentow";
    }

    @GetMapping("/dodaj")
    public String formularzDodawaniaPacjenta(Model model) {
        model.addAttribute("pacjent", new Pacjent());
        model.addAttribute("wlasciciele", wlascicielRepository.findAll());
        return "dodaj_pacjenta";
    }

    @PostMapping("/dodaj")
    public String zapiszPacjenta(@Valid Pacjent pacjent, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("wlasciciele", wlascicielRepository.findAll());
            return "dodaj_pacjenta";
        }
        pacjentRepository.save(pacjent);
        return "redirect:/pacjenci";
    }

    @GetMapping("/usun/{id}")
    public String usunPacjenta(@PathVariable Long id) {
        pacjentRepository.deleteById(id);
        return "redirect:/pacjenci";
    }
}