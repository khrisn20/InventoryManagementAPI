package com.example.inventorymanagementapi.controller;

import com.example.inventorymanagementapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.inventorymanagementapi.repository.ProductRepository;

import java.util.List;

@RestController
public class ProductAPI {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/product/{id}")
    public Product getProduct(@PathVariable Long id){
        return productRepository.findById(id).get();
    }

    @GetMapping(value = "products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping(value = "product/save")
    public String saveProduct(@RequestBody Product product){
        productRepository.save(product);
        return "Product Saved";
    }

    @PutMapping(value = "product/update/{id}")
    public String updatePorduct(@PathVariable Long id, @RequestBody Product product){
        Product updateProduct = productRepository.findById(id).get();
        updateProduct.setName(product.getName());
        updateProduct.setStock(product.getStock());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setMax(product.getMax());
        updateProduct.setMin(product.getMin());
        productRepository.save(updateProduct);
        return "Product Updated";
    }

    @DeleteMapping(value = "product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return "Product Deleted";
    }


}
