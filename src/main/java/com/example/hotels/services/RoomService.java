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

    public void updateRoomStatusBusy(int numb, Long hotelId) {
        Room room = roomRepository.findRoomByHotel_IdAndRoomNumb(hotelId, numb);
        room.setRoomStatus(RoomStatus.BUSY);
        roomRepository.save(room);
    }

    public void updateRoomStatusEmpty(int numb, Long hotelId) {
        Room room = roomRepository.findRoomByHotel_IdAndRoomNumb(hotelId, numb);
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

    public Room getRoomByHotelIdAndRoomNumb(Long hotelId, int roomNumb) {
        return roomRepository.findRoomByHotel_IdAndRoomNumb(hotelId, roomNumb);
    }
}
