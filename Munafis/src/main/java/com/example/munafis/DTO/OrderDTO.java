package com.example.munafis.DTO;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderDTO {

    private Integer id;
    private String changed;
    private Integer integer;
}
