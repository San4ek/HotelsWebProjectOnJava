package com.example.hotels.services;

import com.example.hotels.models.RoomType;
import com.example.hotels.repositories.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    public List<RoomType> getRoomTypes() {
        return roomTypeRepository.findAll();
    }

    public void saveRoomType(RoomType roomType) {
        roomTypeRepository.save(roomType);
    }

    public RoomType getRoomType(Long id) {
        return roomTypeRepository.findById(id).orElseThrow();
    }

    public void editRoomType(Long id, RoomType roomType) {
        roomType.setId(id);
        roomTypeRepository.save(roomType);
    }

    public void deleteRoomType(Long id) {
        roomTypeRepository.deleteById(id);
    }
}
