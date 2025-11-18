package com.mamoon.project.airBnbApp.service;

import com.mamoon.project.airBnbApp.dto.RoomDto;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RoomService {

    RoomDto createNewRooms(Long hotelId,RoomDto roomDto);

    List<RoomDto> getAllRoomsInHotel(Long id);

    RoomDto getRoomById(Long id);

    void deleteRoomById(Long id);



}
