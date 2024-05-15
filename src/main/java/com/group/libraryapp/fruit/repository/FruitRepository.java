package com.group.libraryapp.fruit.repository;

import com.group.libraryapp.fruit.dto.response.FruitSalesAmountResponse;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FruitRepository {
    void save(String name, LocalDate warehousingDate, long price);
    void updateFruit(long id);
    boolean isFruitNotExist(long id);
    FruitSalesAmountResponse statFruit(String name);
}