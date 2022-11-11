package com.example.inventorymanagementapi.controller;

import com.example.inventorymanagementapi.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.inventorymanagementapi.repository.PartRepository;

import java.util.List;

@RestController
public class PartAPI {

    @Autowired
    PartRepository partRepository;

    @GetMapping(value = "/part/{id}")
    public Part getPart(@PathVariable Long id){
        return partRepository.findById(id).get();
    }

    @GetMapping(value = "/parts")
    public List<Part> getAllParts(){
        return partRepository.findAll();
    }

    @PostMapping(value = "/part/save")
    public String savePart(@RequestBody Part part){
        partRepository.save(part);
        return "Part Saved";
    }

    @PutMapping(value = "/part/update/{id}")
    public String updatePart(@PathVariable Long id, @RequestBody Part part){
        Part updatePart = partRepository.findById(id).get();
        updatePart.setName(part.getName());
        updatePart.setPrice(part.getPrice());
        updatePart.setStock(part.getStock());
        updatePart.setMin(part.getMin());
        updatePart.setMax(part.getMax());
        partRepository.save(updatePart);
        return "Part Updated";
    }

    @DeleteMapping(value = "/part/delete/{id}")
    public String deletePart(@PathVariable Long id){
        Part deletePart = partRepository.findById(id).get();
        partRepository.delete(deletePart);
        return "Part Deleted";
    }




}
