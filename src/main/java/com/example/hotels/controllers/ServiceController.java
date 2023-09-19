package com.example.hotels.controllers;

import com.example.hotels.Converter.IdConverter;
import com.example.hotels.enums.Role;
import com.example.hotels.models.Service;
import com.example.hotels.services.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ServiceController {

    private final AppController appController;
    private final ServiceService serviceService;

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("services", serviceService.getServices());
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "services";
    }

    @PostMapping("/service/delete/{id}")
    public String deleteService(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        serviceService.deleteService(longId);
        return "redirect:/services";
    }

    @GetMapping("/service/create")
    public String createService() {
        return "service-create";
    }

    @PostMapping("/service/add")
    public String addService(Service service) {
        serviceService.saveService(service);
        return "redirect:/services";
    }

    @GetMapping("/service/{id}/edit")
    public String editService(@PathVariable String id, Model model) {
        Long longId= IdConverter.convert(id);
        model.addAttribute("service", serviceService.getService(longId));
        return "service-edit";
    }

    @PostMapping("/service/edit/{id}")
    public String serviceEdit(@PathVariable String id, Service service) {
        Long longId= IdConverter.convert(id);
        serviceService.editService(longId, service);
        return "redirect:/services";
    }

    @GetMapping("/service/{id}")
    public String service(@PathVariable String id,Model model) {
        Long longId= IdConverter.convert(id);
        model.addAttribute("service", serviceService.getService(longId));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "service-info";
    }
}
