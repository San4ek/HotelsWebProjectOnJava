package com.example.hotels.services;

import com.example.hotels.models.Purchase;
import com.example.hotels.models.User;
import com.example.hotels.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final HotelService hotelService;

    public Purchase createPurchase(User user, Long hotelId) {
        Purchase purchase =  new Purchase();
        purchase.setUser(user);
        purchase.setHotel(hotelService.getHotel(hotelId));

        return purchase;
    }

    public void savePurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);
    }

    public List<Purchase> getPurchases(User user) {
        return purchaseRepository.findByUserId(user.getId());
    }

    public Purchase getPurchase(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }
}
