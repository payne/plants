package org.mattpayne.demos.jpa.plants;

import org.mattpayne.demos.jpa.plants.dto.PlantDTO;
import org.mattpayne.demos.jpa.plants.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlantsApplication implements CommandLineRunner {

    @Autowired
    private PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(PlantsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PlantDTO plantDTO = plantService.createPlant("daisy", "flower", "perennial");
        plantService.addHistory(plantDTO.getId(), "Started with ideal planting conditions.");
        plantService.addHistory(plantDTO.getId(), "Survived the first winter.");
        plantService.addHistory(plantDTO.getId(), "This field of dasies is growing!");

        /*
         */
    }
}
