package com.estudo.cardapio.repository;

import com.estudo.cardapio.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
