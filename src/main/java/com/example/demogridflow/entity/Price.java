package com.example.demogridflow.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
public class Price {
    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;
    private LocalDate date;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PriceItem> priceItems;

    public Price() {
    }

    public Price(LocalDate date) {
        this.date = date;
        this.priceItems = new ArrayList<>(Arrays.asList(new PriceItem(Service.ADVERT, "10500"),
                new PriceItem(Service.ADVERTSING, "150"),
                new PriceItem(Service.PUBLICITION, "450")));
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

    public List<PriceItem> getPriceItems() {
        return priceItems;
    }

    public void setPriceItems(List<PriceItem> priceItems) {
        this.priceItems = priceItems;
    }
}
