package org.mattpayne.demos.jpa.plants.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="plant_id")
    private Plant plant;

    // TODO: Add DateTime of when the note was made.  Also allow folks to pick the date rather than taking system date.

    public History(String n) {
        this.note = n;
    }

    public History() {

    }
}
