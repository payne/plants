package org.mattpayne.demos.jpa.plants.service;

import org.mattpayne.demos.jpa.plants.dto.PlantDTO;
import org.mattpayne.demos.jpa.plants.model.Plant;
import org.mattpayne.demos.jpa.plants.repository.PlantRepository;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public PlantDTO createPlant(String name) {
        Plant plant = new Plant(name);
        plant = plantRepository.save(plant);
        PlantDTO dto = new PlantDTO();
        // TODO: Add ModelMapper!
        dto.setId(plant.getId());
        dto.setName(plant.getName());
        return dto;
    }
}
