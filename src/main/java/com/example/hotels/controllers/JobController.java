package com.example.hotels.controllers;

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
    public String job(@PathVariable Long id, Model model){
        model.addAttribute("job", jobService.getJob(id));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "job-info";
    }

    @PostMapping("/job/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
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
    public String editJob(@PathVariable Long id, Model model) {
        model.addAttribute("job", jobService.getJob(id));
        return "job-edit";
    }

    @PostMapping("/job/edit/{id}")
    public String jobEdit(@PathVariable Long id, Job job) {
        jobService.editJob(id,job);
        return "redirect:/jobs";
    }
}
