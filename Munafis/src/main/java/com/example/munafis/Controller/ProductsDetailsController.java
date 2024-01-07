package com.example.munafis.Controller;


import com.example.munafis.DTO.ProductDetalisDTO;
import com.example.munafis.Service.ProductsDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update")
    public ResponseEntity updateProductsDetails(@Valid @RequestBody ProductDetalisDTO productDetalisDTO, @PathVariable Integer id ){
      productsDetailsService.updateProductsDetails(id,productDetalisDTO);
        return ResponseEntity.status(200).body("Products Details updated");
    }

    //Only provider
    @PutMapping("/addStock/{provider_id}/{product_id}/{quantity}")
    public ResponseEntity addStock(@PathVariable Integer provider_id,@PathVariable Integer product_id, @PathVariable Integer quantity ){
        productsDetailsService.addStock(provider_id,product_id,quantity);
        return ResponseEntity.status(200).body("Stock added successfully");
    }
}
