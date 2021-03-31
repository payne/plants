package org.mattpayne.demos.jpa.plants.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String categoryName;

    public CategoryDTO(String n) { this.categoryName = n;}
}
