package com.mamoon.project.airBnbApp.service;

import com.mamoon.project.airBnbApp.dto.RoomDto;
import com.mamoon.project.airBnbApp.entity.Hotel;
import com.mamoon.project.airBnbApp.entity.Room;
import com.mamoon.project.airBnbApp.exception.ResourceNotFoundException;
import com.mamoon.project.airBnbApp.repository.HotelRepository;
import com.mamoon.project.airBnbApp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;
    private final HotelRepository hotelRepository;
    private final InventoryService inventoryService;

    @Override
    @Transactional
    public RoomDto createNewRooms(Long hotelId,RoomDto roomDto) {
        log.info("Creating a new room");
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
        Room room = modelMapper.map(roomDto, Room.class);
        room.setHotel(hotel);
        room = roomRepository.save(room);

        if(hotel.getActive())
        {
            inventoryService.initializeRoomForAYear(room);
        }

        return modelMapper.map(room, RoomDto.class);

    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long id) {
        log.info("Getting all rooms in hotel with id {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID " + id));

        return hotel.getRooms()
                .stream()
                .map((element) -> modelMapper.map(element,RoomDto.class))
                .collect(Collectors.toList());



    }

    @Override
    public RoomDto getRoomById(Long id) {
      log.info("Getting the room with id {}", id);
      Room room = roomRepository
              .findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID " + id));
      return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public void deleteRoomById(Long id) {
      log.info("Deleting the room with id {}", id);
      boolean exists = roomRepository.existsById(id);
      if (!exists) {
          throw new ResourceNotFoundException("Room not found with ID " + id);
      }
      roomRepository.deleteById(id);
    }


}
