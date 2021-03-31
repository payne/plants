package org.mattpayne.demos.jpa.plants.controller;

import org.mattpayne.demos.jpa.plants.dto.PlantDTO;
import org.mattpayne.demos.jpa.plants.service.PlantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

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

    @PostMapping
    public ResponseEntity<PlantDTO> postPlant(@RequestBody PlantDTO plantDTO) {
        // TODO: Fix this up!
        PlantDTO dto = plantService.createPlant(plantDTO.getName(), "TODO", "TODO2");
        try {
            return ResponseEntity.created(new URI("/plant/" + dto.getId()))
                    .eTag(Long.toString(dto.getId()))
                    .body(dto);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
