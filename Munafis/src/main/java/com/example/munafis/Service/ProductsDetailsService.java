package com.example.munafis.Service;


import com.example.munafis.API.ApiException;
import com.example.munafis.DTO.ProductDetalisDTO;
import com.example.munafis.Model.Product;
import com.example.munafis.Model.ProductsDetails;
import com.example.munafis.Repository.ProductRepository;
import com.example.munafis.Repository.ProductsDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductsDetailsService {

    private final ProductsDetailsRepository productsDetailsRepository;
    private final ProductRepository productRepository;




     //Only provider
    public void addProductsDetails(ProductDetalisDTO productDetalisDTO){
        Product product= productRepository.findProductsById(productDetalisDTO.getProduct_id());

        if(product==null){
            throw new ApiException("Product id not found");
        }
        ProductsDetails productsDetails = new ProductsDetails(null,productDetalisDTO.getQuantity(),product);
        productsDetailsRepository.save(productsDetails);
    }


    public void updateProductsDetails(Integer id,ProductDetalisDTO productDetalisDTO){

        Product product = productRepository.findProductsById(productDetalisDTO.getProduct_id());
        if(product==null){
            throw new ApiException("Product id not found");
        }
        ProductsDetails oldproductsDetails= productsDetailsRepository.findProductsDetailsById(id);

        if(oldproductsDetails==null){
            throw new ApiException("product details id not found");
        }
        oldproductsDetails.setQuantity(productDetalisDTO.getQuantity());
        productsDetailsRepository.save(oldproductsDetails);

    }


}
