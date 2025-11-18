package com.mamoon.project.airBnbApp.repository;

import com.mamoon.project.airBnbApp.entity.Inventory;
import com.mamoon.project.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    //void deleteByDateAfterAndRoom(LocalDate date, Room room);
}
