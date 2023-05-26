package com.example.hotels.controllers;

import com.example.hotels.Converter.IdConverter;
import com.example.hotels.enums.Role;
import com.example.hotels.models.Job;
import com.example.hotels.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;
    private final AppController appController;

    @GetMapping("/jobs")
    public String jobs(Model model) {
        model.addAttribute("jobs", jobService.getJobs());
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "jobs";
    }

    @GetMapping("/job/{id}")
    public String job(@PathVariable String id, Model model){
        Long longId= IdConverter.convert(id);
        model.addAttribute("job", jobService.getJob(longId));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "job-info";
    }

    @PostMapping("/job/delete/{id}")
    public String deleteJob(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        jobService.deleteJob(longId);
        return "redirect:/jobs";
    }

    @GetMapping("/job/create")
    public String addJob() {
        return "job-create";
    }

    @PostMapping("/job/add")
    public String createJob(Job job) {
        jobService.saveJob(job);
        return "redirect:/jobs";
    }

    @GetMapping("/job/{id}/edit")
    public String editJob(@PathVariable String id, Model model) {
        Long longId= IdConverter.convert(id);
        model.addAttribute("job", jobService.getJob(longId));
        return "job-edit";
    }

    @PostMapping("/job/edit/{id}")
    public String jobEdit(@PathVariable String id, Job job) {
        Long longId= IdConverter.convert(id);
        jobService.editJob(longId,job);
        return "redirect:/jobs";
    }
}
