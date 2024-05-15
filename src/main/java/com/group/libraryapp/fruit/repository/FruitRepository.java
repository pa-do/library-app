package com.group.libraryapp.fruit.repository;

import com.group.libraryapp.fruit.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
    List<Fruit> findAllByName(String name);
}