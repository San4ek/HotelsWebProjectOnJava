package com.example.hotels.controllers;

import com.example.hotels.Converter.IdConverter;
import com.example.hotels.enums.Role;
import com.example.hotels.models.Company;
import com.example.hotels.services.CompanyService;
import com.example.hotels.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final AppController appController;
    private final CountryService countryService;

    @GetMapping("/companies")
    public String companies(Model model) {
        model.addAttribute("companies", companyService.getCompanies());
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "companies";
    }

    @GetMapping("/company/{id}")
    public String company(@PathVariable String id, Model model){
        Long longId= IdConverter.convert(id);
        model.addAttribute("company", companyService.getCompany(longId));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "company-info";
    }

    @PostMapping("/company/delete/{id}")
    public String deleteCompany(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        companyService.deleteCompany(longId);
        return "redirect:/companies";
    }

    @GetMapping("/company/create")
    public String addCompany(Model model) {
        model.addAttribute("companies", countryService.getCountries());
        return "company-create";
    }

    @PostMapping("/company/add")
    public String createCompany(Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/company/{id}/edit")
    public String editCompany(@PathVariable String id, Model model) {
        Long longId= IdConverter.convert(id);
        model.addAttribute("company", companyService.getCompany(longId));
        model.addAttribute("companies", countryService.getCountries());
        return "company-edit";
    }

    @PostMapping("/company/edit/{id}")
    public String companyEdit(@PathVariable String id, Company company) {
        Long longId= IdConverter.convert(id);
        companyService.editCompany(longId,company);
        return "redirect:/companies";
    }
}
