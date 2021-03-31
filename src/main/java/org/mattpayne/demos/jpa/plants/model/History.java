package org.mattpayne.demos.jpa.plants.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    // TODO: Add DateTime of when the note was made.  Also allow folks to pick the date rather than taking system date.

    public History(String n) {
        this.note = n;
    }

    public History() {

    }
}
