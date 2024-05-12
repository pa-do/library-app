package com.group.libraryapp.fruit.controller;

import com.group.libraryapp.fruit.dto.request.FruitCreateRequest;
import com.group.libraryapp.fruit.dto.request.FruitSoldRequest;
import com.group.libraryapp.fruit.dto.response.FruitSalesAmountResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {
    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitSoldRequest request) {
        String readSql = "SELECT * FROM fruit WHERE id = ?";

        boolean isFruitNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isFruitNotExist) {
            throw new IllegalArgumentException();
        }

        String updateSql = "UPDATE fruit SET is_sold  = true WHERE id = ?";
        jdbcTemplate.update(updateSql, request.getId());
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitSalesAmountResponse statFruit(@RequestParam String name) {

        String salesSql = "SELECT sum(price) FROM fruit WHERE is_sold = true GROUP BY name HAVING name = ?";
        String notSalesSql = "SELECT sum(price) FROM fruit WHERE is_sold = false GROUP BY name HAVING name = ?";


        long salesAmount = jdbcTemplate.queryForObject(salesSql, long.class, name);
        long notSalesAmount = jdbcTemplate.queryForObject(notSalesSql, long.class, name);


        return new FruitSalesAmountResponse(salesAmount, notSalesAmount);
    }
}
