package com.example.inventorymanagementapi.repository;

import com.example.inventorymanagementapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
