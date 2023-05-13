package com.example.hotels.services;

import com.example.hotels.models.Job;
import com.example.hotels.repositories.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    public Job getJob(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public void saveJob(Job job) {
        jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public void editJob(Long id, Job job) {
        job.setId(id);
        jobRepository.save(job);
    }
}
