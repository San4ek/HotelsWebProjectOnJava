package com.example.hotels.services;

import com.example.hotels.models.Country;
import com.example.hotels.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    public void editCountry(Long id, Country country) {
        country.setId(id);
        countryRepository.save(country);
    }
}
