package com.example.hotels.controllers;

import com.example.hotels.enums.Role;
import com.example.hotels.models.Director;
import com.example.hotels.services.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;
    private final AppController appController;

    @GetMapping("/directors")
    public String country(Model model) {
        model.addAttribute("directors", directorService.getDirectors());
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "directors";
    }

    @GetMapping("/director/{id}")
    public String director(@PathVariable Long id, Model model) {
        model.addAttribute("director", directorService.getDirector(id));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "director-info";
    }

    @PostMapping("/director/delete/{id}")
    public String deleteDirector(@PathVariable Long id) {
        directorService.deleteDirector(id);
        return "redirect:/directors";
    }

    @GetMapping("/director/create")
    public String createDirector() {
        return "director-create";
    }

    @PostMapping("/director/add")
    public String addDirector(Director director) {
        directorService.saveDirector(director);
        return "redirect:/directors";
    }

    @GetMapping("/director/{id}/edit")
    public String editDirector(@PathVariable Long id, Model model) {
        model.addAttribute("director", directorService.getDirector(id));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "director-edit";
    }

    @PostMapping("/director/edit/{id}")
    public String directorEdit(@PathVariable Long id, Director director) {
        directorService.editDirector(id,director);
        return "redirect:/directors";
    }
}
