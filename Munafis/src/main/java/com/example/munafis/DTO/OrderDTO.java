package com.example.munafis.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderDTO {

    private Integer id;
    @Pattern(regexp = "^(accepted|rejected|completed)$")
    private String status;
    private double totalPrice;



}
