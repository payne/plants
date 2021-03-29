package org.mattpayne.demos.jpa.plants;

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
		plantService.createPlant("daisy");
	}
}
