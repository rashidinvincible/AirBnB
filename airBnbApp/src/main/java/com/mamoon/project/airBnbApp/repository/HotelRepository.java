package com.mamoon.project.airBnbApp.repository;

import com.mamoon.project.airBnbApp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
