package org.mattpayne.demos.jpa.plants.dto;

import lombok.Data;
import org.mattpayne.demos.jpa.plants.model.Category;
import org.mattpayne.demos.jpa.plants.model.History;

import java.util.HashSet;
import java.util.Set;

@Data
public class PlantDTO {
    private Long id;
    private String name;
    private Set<CategoryDTO> categories;
    private Set<HistoryDTO> histories = new HashSet<>();
}
