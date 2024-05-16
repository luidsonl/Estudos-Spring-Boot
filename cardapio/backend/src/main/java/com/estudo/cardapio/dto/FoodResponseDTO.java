package com.estudo.cardapio.dto;

import com.estudo.cardapio.model.Food;

public record FoodResponseDTO (Long id, String title, String description, String image, Integer price){

    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getDescription(), food.getImage(), food.getPrice());
    }
}
