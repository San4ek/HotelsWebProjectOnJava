package com.example.hotels.repositories;

import com.example.hotels.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByUserId(Long id);

    List<Purchase> findByDirectorId(Long id);

    List<Purchase> findByRoomId(Long id);
}
