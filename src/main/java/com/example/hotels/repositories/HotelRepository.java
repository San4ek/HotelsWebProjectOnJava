package com.example.hotels.repositories;

import com.example.hotels.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByName(String name);

}
