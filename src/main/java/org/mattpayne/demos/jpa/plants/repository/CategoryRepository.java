package org.mattpayne.demos.jpa.plants.repository;

import org.mattpayne.demos.jpa.plants.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
