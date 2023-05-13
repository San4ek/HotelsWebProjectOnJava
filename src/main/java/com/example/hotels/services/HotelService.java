package com.example.hotels.services;

import com.example.hotels.models.Hotel;
import com.example.hotels.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getHotels() {
       return hotelRepository.findAll();
    }

    public void saveHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id){
        hotelRepository.deleteById(id);
    }

    public Hotel getHotel(Long id){
        return hotelRepository.findById(id).orElse(null);
    }

    public void editHotel(Long id, Hotel hotel) {
        hotel.setId(id);
        hotelRepository.save(hotel);
    }

    public List<Hotel> findByDirectorId(Long id) {
        return hotelRepository.findByDirectorId(id);
    }
}
