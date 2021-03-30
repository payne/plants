package org.mattpayne.demos.jpa.plants.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private Set<Plant> plants = new HashSet<>();

    public Category() {}
    public Category(String n) { this.categoryName = n; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
