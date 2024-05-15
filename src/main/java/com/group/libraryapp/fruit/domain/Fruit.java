package com.group.libraryapp.fruit.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column
    private LocalDate warehousingDate;

    @Column
    private Long price;

    @Column(columnDefinition = "boolean default false")
    private boolean isSold;

    public Fruit() {
    }

    public Fruit(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = false;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }

    public Boolean isSold() {
        return isSold;
    }

    public void updateIsSold(Boolean isSold) {
        this.isSold = isSold;
    }
}
