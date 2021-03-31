package org.mattpayne.demos.jpa.plants.service;

import org.mattpayne.demos.jpa.plants.dto.CategoryDTO;
import org.mattpayne.demos.jpa.plants.dto.PlantDTO;
import org.mattpayne.demos.jpa.plants.model.Category;
import org.mattpayne.demos.jpa.plants.model.History;
import org.mattpayne.demos.jpa.plants.model.Plant;
import org.mattpayne.demos.jpa.plants.repository.HistoryRepository;
import org.mattpayne.demos.jpa.plants.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PlantService {

    private final PlantRepository plantRepository;
    private final HistoryRepository historyRepository;

    public PlantService(PlantRepository plantRepository, HistoryRepository historyRepository) {
        this.plantRepository = plantRepository;
        this.historyRepository = historyRepository;
    }

    public PlantDTO createPlant(PlantDTO dto) {
        Plant plant = new Plant(dto.getName());
        plant = plantRepository.save(plant);
        for (CategoryDTO c: dto.getCategories()) {
            plant.addCategory(c.getCategoryName());
        }
        plant = plantRepository.save(plant);
        return fromPlant(plant);
    }

    public PlantDTO createPlant(String name, String... catNames) {
        PlantDTO dto = new PlantDTO();
        dto.setName(name);
        Set<CategoryDTO> cSet = new HashSet<>();
        for (String cName: catNames) {
            CategoryDTO c = new CategoryDTO(cName);
            cSet.add(c);
        }
        dto.setCategories(cSet);
        return createPlant(dto);
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
        Set<CategoryDTO> categories = new HashSet<>();
        for (Category c: plant.getCategories()) {
          categories.add(fromCategory(c));
        }
        dto.setCategories(categories);
        return dto;
    }

    private CategoryDTO fromCategory(Category c) {
        CategoryDTO dto = new CategoryDTO(c.getCategoryName());
        dto.setId(c.getId());
        return dto;
    }

    public void addHistory(Long id, String note) {
        History history = historyRepository.save(new History(note));
        System.out.println(history);
        System.out.println("Well?");
    }
    /*
    public void addHistory(Long id, String note) {
        Optional<Plant> optional = plantRepository.findById(id);
        // TODO: Add logging!  Maybe return some error...
        if (optional.isPresent()) {
            Plant plant = optional.get();
            plant.addHistory(note);
            plant = plantRepository.save(plant);
        }
        //TODO: Consider returning the DTO...
    }

     */
}
