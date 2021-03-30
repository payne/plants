package org.mattpayne.demos.jpa.plants.dto;

import lombok.Data;
import org.mattpayne.demos.jpa.plants.model.Category;

import java.util.Set;

@Data
public class PlantDTO {
    private Long id;
    private String name;
    private Set<Category> categories;
}
