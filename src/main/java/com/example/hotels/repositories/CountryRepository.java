package com.example.hotels.repositories;

import com.example.hotels.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
