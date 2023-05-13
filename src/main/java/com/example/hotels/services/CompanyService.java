package com.example.hotels.services;

import com.example.hotels.models.Company;
import com.example.hotels.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElseThrow();
    }

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public void editCompany(Long id, Company company) {
        company.setId(id);
        companyRepository.save(company);
    }
}
