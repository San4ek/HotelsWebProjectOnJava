package com.example.hotels.repositories;

import com.example.hotels.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
