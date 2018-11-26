package com.example.demogridflow.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dates")
public class SchDate {

    @Id
    @GeneratedValue
    Long id;
    LocalDate date;

    public SchDate(LocalDate date) {
        this.date = date;
    }

    public SchDate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
