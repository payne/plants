package org.mattpayne.demos.jpa.plants.repository;

import org.mattpayne.demos.jpa.plants.model.History;
import org.mattpayne.demos.jpa.plants.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {

}
