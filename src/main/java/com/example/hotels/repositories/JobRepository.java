package com.example.hotels.repositories;

import com.example.hotels.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
