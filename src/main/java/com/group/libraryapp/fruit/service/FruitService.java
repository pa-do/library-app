package com.group.libraryapp.fruit.service;

import com.group.libraryapp.fruit.domain.Fruit;
import com.group.libraryapp.fruit.dto.request.FruitCreateRequest;
import com.group.libraryapp.fruit.dto.request.FruitSoldRequest;
import com.group.libraryapp.fruit.dto.response.FruitSalesAmountResponse;
import com.group.libraryapp.fruit.repository.FruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Transactional
    public void saveFruit(FruitCreateRequest request) {
        fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
    }

    @Transactional
    public void updateFruit(FruitSoldRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        fruit.updateIsSold(true);
        fruitRepository.save(fruit);
    }

    @Transactional
    public FruitSalesAmountResponse statFruit(String name) {
        List<Fruit> list = fruitRepository.findAllByName(name);
        long salesAmount = 0;
        long notSalesAmount = 0;

        for (Fruit fruit : list) {
            if (fruit.isSold()) {
                salesAmount += fruit.getPrice();
            } else {
                notSalesAmount += fruit.getPrice();
            }
        }

        return new FruitSalesAmountResponse(salesAmount, notSalesAmount);
    }
}