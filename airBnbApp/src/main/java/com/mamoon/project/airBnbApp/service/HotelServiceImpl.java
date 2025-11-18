package com.mamoon.project.airBnbApp.service;

import com.mamoon.project.airBnbApp.dto.HotelDto;
import com.mamoon.project.airBnbApp.entity.Hotel;
import com.mamoon.project.airBnbApp.entity.Room;
import com.mamoon.project.airBnbApp.exception.ResourceNotFoundException;
import com.mamoon.project.airBnbApp.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;

    @Override
    @Transactional
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new hotel with name {}",hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        log.info("Created a new hotel with iD: {}",hotel.getId());
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting hotel with id {}",id);
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + id));
        return modelMapper.map(hotel, HotelDto.class);

    }

    @Override
    public HotelDto updateHotelById(Long id,HotelDto hotelDto) {
        log.info("Updating the hotel with id {}",id);
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + id));
        modelMapper.map(hotelDto, hotel);
        hotel.setId(id);
        hotel = hotelRepository.save(hotel);
        log.info("Updated the hotel with id {}",hotel.getId());
        return modelMapper.map(hotel, HotelDto.class);

    }

    @Override
    public void deleteHotelById(Long id) {
       boolean exists = hotelRepository.existsById(id);
       if(!exists){
           throw new ResourceNotFoundException("Hotel not found with ID: " + id);
       }
       hotelRepository.deleteById(id);
       log.info("Deleted hotel with id {}",id);
    }

    @Override
    @Transactional
    public void activateHotel(Long id) {
        log.info("Activating the hotel with id {}",id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + id));

        hotel.setActive(true);

     for(Room room : hotel.getRooms())
      {
         inventoryService.initializeRoomForAYear(room);
      }
    }


}
