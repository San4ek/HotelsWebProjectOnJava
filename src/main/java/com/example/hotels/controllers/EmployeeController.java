package com.example.hotels.controllers;

import com.example.hotels.Converter.IdConverter;
import com.example.hotels.enums.Role;
import com.example.hotels.models.Employee;
import com.example.hotels.services.EmployeeService;
import com.example.hotels.services.HotelService;
import com.example.hotels.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AppController appController;
    private final HotelService hotelService;
    private final JobService jobService;

    @GetMapping("/employees")
    public String country(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "employees";
    }

    @GetMapping("/employee/{id}")
    public String country(@PathVariable String id, Model model) {
        Long longId= IdConverter.convert(id);
        model.addAttribute("employee", employeeService.getEmployee(longId));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "employee-info";
    }

    @PostMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        employeeService.deleteEmployee(longId);
        return "redirect:/employees";
    }

    @GetMapping("/employee/create")
    public String createEmployee(Model model) {
        model.addAttribute("jobs", jobService.getJobs());
        model.addAttribute("hotels", hotelService.getHotels());
        return "employee-create";
    }

    @PostMapping("/employee/add")
    public String addEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/{id}/edit")
    public String editEmployee(@PathVariable String id, Model model) {
        Long longId= IdConverter.convert(id);
        model.addAttribute("employee", employeeService.getEmployee(longId));
        model.addAttribute("jobs", jobService.getJobs());
        model.addAttribute("hotels", hotelService.getHotels());
        return "employee-edit";
    }

    @PostMapping("/employee/edit/{id}")
    public String employeeEdit(@PathVariable String id, Employee employee) {
        Long longId= IdConverter.convert(id);
        employeeService.editEmployee(longId,employee);
        return "redirect:/employees";
    }
}
