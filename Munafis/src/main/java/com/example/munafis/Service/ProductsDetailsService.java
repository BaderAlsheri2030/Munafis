package com.example.munafis.Service;


import com.example.munafis.DTO.ProductDetalisDTO;
import com.example.munafis.Model.Products;
import com.example.munafis.Repository.ProductRepository;
import com.example.munafis.Repository.ProductsDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsDetailsService {

    private final ProductsDetailsRepository productsDetailsRepository;
    private final ProductRepository productRepository;




    public List getAllProductsDetails(){
        return  productsDetailsRepository.findAll();
    }

    public void addProductsDetails(ProductDetalisDTO productDetalisDTO){
        Products products= productRepository.findProductsById(productDetalisDTO.getProduct_id());


    }
}
