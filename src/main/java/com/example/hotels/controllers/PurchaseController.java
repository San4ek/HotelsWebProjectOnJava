package com.example.hotels.controllers;

import com.example.hotels.enums.Role;
import com.example.hotels.services.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    private final AppController appController;

    @GetMapping("/purchases")
    public String purchases(Model model) {
        model.addAttribute("purchases", purchaseService.getPurchases(appController.user));
        return "purchases";
    }

    @GetMapping("/purchase/{id}")
    public String company(@PathVariable Long id, Model model){
        model.addAttribute("purchase", purchaseService.getPurchase(id));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "purchase-info";
    }

    @PostMapping("/purchase/delete/{id}")
    public String deleteCompany(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
        return "redirect:/purchases";
    }
}
