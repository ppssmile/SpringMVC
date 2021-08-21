package ru.geekbrains.SpringMVS.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private String title;
    private int cost;

    public Product() {
    }
}

