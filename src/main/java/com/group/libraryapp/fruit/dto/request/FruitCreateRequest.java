package com.group.libraryapp.fruit.dto.request;

import java.time.LocalDate;

public class FruitCreateRequest {
    private String name;
    private LocalDate warehousingDate;
    private long price;

    public FruitCreateRequest(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}
