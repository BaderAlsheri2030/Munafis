package com.example.munafis.Controller;


import com.example.munafis.DTO.ProductDetalisDTO;
import com.example.munafis.Service.ProductsDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productsDetails")
@RequiredArgsConstructor
public class ProductsDetailsController {



    private final ProductsDetailsService productsDetailsService;



    @PostMapping("/add")
    public ResponseEntity addProductsDetails(@Valid @RequestBody ProductDetalisDTO productDetalisDTO){

        productsDetailsService.addProductsDetails(productDetalisDTO);
        return ResponseEntity.status(200).body("Products Details added");
    }
}
