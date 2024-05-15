package com.group.libraryapp.fruit.service;

import com.group.libraryapp.fruit.dto.request.FruitCreateRequest;
import com.group.libraryapp.fruit.dto.request.FruitSoldRequest;
import com.group.libraryapp.fruit.dto.response.FruitSalesAmountResponse;
import com.group.libraryapp.fruit.repository.FruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Transactional
    public void saveFruit(FruitCreateRequest request) {
        fruitRepository.save(request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @Transactional
    public void updateFruit(FruitSoldRequest request) {
        if (fruitRepository.isFruitNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        fruitRepository.updateFruit(request.getId());
    }

    @Transactional
    public FruitSalesAmountResponse statFruit(String name) {
        return fruitRepository.statFruit(name);
    }
}