package com.example.demogridflow.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    Long id;

    @Version
            private Integer version;

    String name;
    @ManyToOne(fetch = FetchType.EAGER)
    PriceItem price;

    Double amount=0.0;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public PriceItem getPrice() {
        return price;
    }

    public void setPrice(PriceItem price) {
        this.price = price;
    }
}
