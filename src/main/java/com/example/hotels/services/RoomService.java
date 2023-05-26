package com.example.hotels.services;

import com.example.hotels.enums.RoomStatus;
import com.example.hotels.models.Hotel;
import com.example.hotels.models.Room;
import com.example.hotels.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public void updateRoomStatusBusy(Long roomId) {
        Room room = roomRepository.findRoomById(roomId);
        room.setRoomStatus(RoomStatus.BUSY);
        roomRepository.save(room);
    }

    public void updateRoomStatusEmpty(Long roomId) {
        Room room = roomRepository.findRoomById(roomId);
        room.setRoomStatus(RoomStatus.EMPTY);
        roomRepository.save(room);
    }

    public void createRooms(Hotel hotel) {
        for (int i=0; i< hotel.getNumbOfRooms(); ++i) {
            Room room= new Room();
            room.setRoomStatus(RoomStatus.EMPTY);
            room.setRoomNumb(i+1);
            room.setHotel(hotel);
            roomRepository.save(room);
        }
    }

    public List<Room> getRoomsByHotelIdAndRoomStatus(Long id, RoomStatus roomStatus) {
        return roomRepository.findRoomsByHotel_IdAndRoomStatus(id,roomStatus);
    }

    public Room getRoomById(Long roomId) {
        return roomRepository.findRoomById(roomId);
    }

    public List<Room> getRoomsByHotelId(Long id) {
        return roomRepository.findRoomByHotel_Id(id);
    }
}
