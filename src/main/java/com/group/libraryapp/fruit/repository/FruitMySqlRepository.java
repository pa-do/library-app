package com.group.libraryapp.fruit.repository;

import com.group.libraryapp.fruit.dto.response.FruitSalesAmountResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@Primary
public class FruitMySqlRepository {
    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(String name, LocalDate warehousingDate, long price) {
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, warehousingDate, price);
    }

    public void updateFruit(long id) {
        String sql = "UPDATE fruit SET is_sold  = true WHERE id = ?";
        jdbcTemplate.update(sql, id);

    }

    public boolean isFruitNotExist(long id) {
        String sql = "SELECT * FROM fruit WHERE id = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public FruitSalesAmountResponse statFruit(String name) {
        String salesSql = "SELECT sum(price) FROM fruit WHERE is_sold = true GROUP BY name HAVING name = ?";
        String notSalesSql = "SELECT sum(price) FROM fruit WHERE is_sold = false GROUP BY name HAVING name = ?";


        long salesAmount = jdbcTemplate.queryForObject(salesSql, long.class, name);
        long notSalesAmount = jdbcTemplate.queryForObject(notSalesSql, long.class, name);


        return new FruitSalesAmountResponse(salesAmount, notSalesAmount);
    }
}