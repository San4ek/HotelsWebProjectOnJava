package com.example.hotels.controllers;

import com.example.hotels.enums.Role;
import com.example.hotels.models.Country;
import com.example.hotels.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;
    private final AppController appController;

    @GetMapping("/countries")
    public String countries(Model model) {
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "countries";
    }

    @GetMapping("/country/{id}")
    public String country(@PathVariable Long id,Model model) {
        model.addAttribute("country", countryService.getCountry(id));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "country-info";
    }

    @PostMapping("/country/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }

    @GetMapping("/country/create")
    public String createCountry() {
        return "country-create";
    }

    @PostMapping("/country/add")
    public String addCountry(Country country) {
        countryService.saveCountry(country);
        return "redirect:/countries";
    }

    @GetMapping("/country/{id}/edit")
    public String editCountry(@PathVariable Long id, Model model) {
        model.addAttribute("country", countryService.getCountry(id));
        return "country-edit";
    }

    @PostMapping("/country/edit/{id}")
    public String countryEdit(@PathVariable Long id, Country country) {
        countryService.editCountry(id,country);
        return "redirect:/countries";
    }
}
