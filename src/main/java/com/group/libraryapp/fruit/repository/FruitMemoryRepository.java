package com.group.libraryapp.fruit.repository;

import com.group.libraryapp.fruit.dto.response.FruitSalesAmountResponse;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class FruitMemoryRepository {
    void save(String name, LocalDate warehousingDate, long price) {
        // todo
    }

    void updateFruit(long id) {
        // todo
    }

    boolean isFruitNotExist(long id) {
        // todo
        return false;
    }

    FruitSalesAmountResponse statFruit(String name) {
        // todo
        return null;
    }
}