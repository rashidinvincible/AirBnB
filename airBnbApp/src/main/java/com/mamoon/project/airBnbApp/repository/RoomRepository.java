package com.mamoon.project.airBnbApp.repository;

import com.mamoon.project.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
