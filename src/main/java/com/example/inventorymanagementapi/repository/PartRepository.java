package com.example.inventorymanagementapi.repository;

import com.example.inventorymanagementapi.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {
}
