package com.example.hotels.services;

import com.example.hotels.enums.RoomStatus;
import com.example.hotels.models.Hotel;
import com.example.hotels.models.Room;
import com.example.hotels.models.RoomType;
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
    private final RoomTypeService roomTypeService;

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

    public void createRooms(Hotel hotel, int[] rooms) {
        List<RoomType> roomTypes=roomTypeService.getRoomTypes();
        int roomNumb=1;
        for (int i=0; i<rooms.length; ++i) {
            for (int j = 0; j < rooms[i]; ++j) {
                Room room = new Room();
                room.setHotel(hotel);
                room.setRoomNumb(roomNumb++);
                room.setRoomStatus(RoomStatus.EMPTY);
                room.setRoomType(roomTypes.get(i));
                roomRepository.save(room);
            }
        }
    }

    public Room getRoomById(Long roomId) {
        return roomRepository.findRoomById(roomId);
    }

    public List<Room> getRoomsByHotelId(Long id) {
        return roomRepository.findRoomByHotel_Id(id);
    }
}
