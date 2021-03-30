package org.mattpayne.demos.jpa.plants.controller;

import org.mattpayne.demos.jpa.plants.dto.PlantDTO;
import org.mattpayne.demos.jpa.plants.service.PlantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plant")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/{id}")
    public PlantDTO getPlantById(@PathVariable Long id) {
        return plantService.findById(id);
    }

}
