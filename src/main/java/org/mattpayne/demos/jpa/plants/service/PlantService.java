package org.mattpayne.demos.jpa.plants.service;

import org.mattpayne.demos.jpa.plants.dto.PlantDTO;
import org.mattpayne.demos.jpa.plants.model.Category;
import org.mattpayne.demos.jpa.plants.model.Plant;
import org.mattpayne.demos.jpa.plants.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public PlantDTO createPlant(String name, String... catNames) {
        Plant plant = new Plant(name);
        plant = plantRepository.save(plant);
        for (String cname: catNames) {
            plant.addCategory(cname);
        }
        plant = plantRepository.save(plant);
        return fromPlant(plant);
    }

    public PlantDTO findById(Long id) {
        Plant plant = plantRepository.findById(id).get();
        // TODO: Handle the not found case!
        // TODO: Add ModelMapper!
        PlantDTO dto = fromPlant(plant);
        return dto;
    }

    private PlantDTO fromPlant(Plant plant) {
        PlantDTO dto = new PlantDTO();
        dto.setId(plant.getId());
        dto.setName(plant.getName());
        Set<Category> categories = new HashSet<>();
        for (Category c: plant.getCategories()) {
          categories.add(c);
        }
        dto.setCategories(categories);
        return dto;
    }
}
