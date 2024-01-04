package com.example.munafis.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProductDTO {


    private Integer provider_id;
    private String name;
    private double price;
}
