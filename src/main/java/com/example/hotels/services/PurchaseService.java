package com.example.hotels.services;

import com.example.hotels.enums.PurchaseStatus;
import com.example.hotels.enums.Role;
import com.example.hotels.enums.RoomStatus;
import com.example.hotels.models.Hotel;
import com.example.hotels.models.Purchase;
import com.example.hotels.models.Room;
import com.example.hotels.models.User;
import com.example.hotels.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final HotelService hotelService;
    private final RoomService roomService;

    public Purchase createPurchase(User user, Long hotelId, Long roomId, Date startdate, Date endDate) {
        Purchase purchase =  new Purchase();
        purchase.setUser(user);
        Hotel hotel = hotelService.getHotel(hotelId);
        purchase.setHotel(hotel);
        purchase.setPurchaseStatus(PurchaseStatus.WAIT);
        purchase.setDirector(hotel.getDirector());
        purchase.setStartDate(startdate);
        purchase.setEndDate(endDate);
        Room room= roomService.getRoomById(roomId);
        room.setRoomStatus(RoomStatus.BUSY);
        roomService.updateRoomStatusBusy(roomId);
        purchase.setRoom(room);
        return purchase;
    }

    public List<Purchase> getPurchasesByRoomId(Long id) {
        return purchaseRepository.findByRoomId(id);
    }

    public void savePurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public List<Purchase> getPurchases(User user) {
        if (user.getRole().equals(Role.USER)) {
            return purchaseRepository.findByUserId(user.getId());
        } else {
            return purchaseRepository.findByDirectorId(user.getId());
        }
    }

    public Purchase getPurchase(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    public void exceptPurchase(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow();
        purchase.setPurchaseStatus(PurchaseStatus.EXCEPT);
        roomService.updateRoomStatusBusy(purchase.getRoom().getId());
        purchaseRepository.save(purchase);
    }

    public void rejectPurchase(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow();
        purchase.setPurchaseStatus(PurchaseStatus.REJECT);
        roomService.updateRoomStatusEmpty(purchase.getRoom().getId());
        purchaseRepository.save(purchase);
    }

    public void evictPurchase(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow();
        purchase.setPurchaseStatus(PurchaseStatus.EVICTED);
        roomService.updateRoomStatusEmpty(purchase.getRoom().getId());
        purchaseRepository.save(purchase);
    }

    public void inhabitPurchase(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow();
        purchase.setPurchaseStatus(PurchaseStatus.INHABITED);
        purchaseRepository.save(purchase);
    }
}
