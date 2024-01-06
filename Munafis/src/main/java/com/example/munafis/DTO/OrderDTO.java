package com.example.munafis.DTO;

import com.example.munafis.Model.Product;
import com.example.munafis.Model.Service;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
public class OrderDTO {

    private Integer id;
    @Pattern(regexp = "^(accepted|rejected|completed)$")
    private String status;
    private Integer quantity;
    private double totalPrice;
//    private Integer product_id;
//    private Integer service_id;
private List<Service> services;
private List<Product> products;

//    private List<Service> services;
//    private List<Product> products;
    private Integer company_id;



}
