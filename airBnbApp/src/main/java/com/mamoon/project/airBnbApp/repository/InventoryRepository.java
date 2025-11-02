package com.mamoon.project.airBnbApp.repository;

import com.mamoon.project.airBnbApp.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
