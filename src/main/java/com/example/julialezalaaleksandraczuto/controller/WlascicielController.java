package com.example.julialezalaaleksandraczuto.controller;

import com.example.julialezalaaleksandraczuto.model.Wlasciciel;
import com.example.julialezalaaleksandraczuto.repository.WlascicielRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/wlasciciele")
public class WlascicielController {

    private final WlascicielRepository wlascicielRepository;

    public WlascicielController(WlascicielRepository wlascicielRepository) {
        this.wlascicielRepository = wlascicielRepository;
    }

    @GetMapping
    public String listaWlascicieli(Model model) {
        List<Wlasciciel> wlasciciele = wlascicielRepository.findAll();
        model.addAttribute("wlasciciele", wlasciciele);
        return "lista_wlascicieli";
    }

    @GetMapping("/dodaj")
    public String formularzDodawaniaWlasciciela(Model model) {
        model.addAttribute("wlasciciel", new Wlasciciel());
        return "dodaj_wlasciciela";
    }

    @PostMapping("/dodaj")
    public String zapiszWlasciciela(@Valid Wlasciciel wlasciciel, BindingResult result) {
        if (result.hasErrors()) {
            return "dodaj_wlasciciela";
        }
        wlascicielRepository.save(wlasciciel);
        return "redirect:/wlasciciele";
    }

    @GetMapping("/usun/{id}")
    public String usunWlasciciela(@PathVariable Long id) {
        wlascicielRepository.deleteById(id);
        return "redirect:/wlasciciele";
    }
}