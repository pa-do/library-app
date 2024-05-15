package com.group.libraryapp.fruit.controller;

import com.group.libraryapp.fruit.dto.request.FruitCreateRequest;
import com.group.libraryapp.fruit.dto.request.FruitSoldRequest;
import com.group.libraryapp.fruit.dto.response.FruitResponse;
import com.group.libraryapp.fruit.dto.response.FruitSalesAmountResponse;
import com.group.libraryapp.fruit.service.FruitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        fruitService.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitSoldRequest request) {
        fruitService.updateFruit(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitSalesAmountResponse statFruit(@RequestParam String name) {
        return fruitService.statFruit(name);
    }

    @GetMapping("/api/v1/fruit/list")
    public List<FruitResponse> getExistFruits(@RequestParam String option, @RequestParam Long price) {
        return fruitService.getExistFruits(option, price);
    }
}