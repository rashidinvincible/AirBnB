package com.mamoon.project.airBnbApp.service;

import com.mamoon.project.airBnbApp.dto.HotelDto;
import com.mamoon.project.airBnbApp.entity.Hotel;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

}
