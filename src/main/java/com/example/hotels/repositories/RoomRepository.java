package com.example.hotels.repositories;

import com.example.hotels.enums.RoomStatus;
import com.example.hotels.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findRoomsByHotel_IdAndRoomStatus(Long id, RoomStatus roomStatus);
    Room findRoomByHotel_IdAndRoomNumb(Long hotelId, int roomNumb);
    Room findRoomById(Long id);
}
