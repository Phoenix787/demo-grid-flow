package com.example.demogridflow.entity;

import javax.persistence.*;

@Entity
public class PriceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    private Service service;
    private String name;

    public PriceItem() {
    }

    public PriceItem(Service service, String name) {
        this.service = service;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
