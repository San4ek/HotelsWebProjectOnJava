package com.example.hotels.repositories;

import com.example.hotels.models.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
}
