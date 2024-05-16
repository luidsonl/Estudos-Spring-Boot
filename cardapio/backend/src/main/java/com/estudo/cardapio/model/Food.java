package com.estudo.cardapio.model;

import com.estudo.cardapio.dto.FoodRequestDTO;
import jakarta.persistence.*;

@Table(name="foods")
@Entity(name = "foods")
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String image;
    private Integer price;

    public Food(Long id, String title, String description, String image, Integer price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
    }
    public Food(){}

    public Food(FoodRequestDTO data){
        this.title = data.title();
        this.description = data.description();
        this.image = data.image();
        this.price = data.price();
    }

    public Long getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
