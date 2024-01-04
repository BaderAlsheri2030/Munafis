package com.example.munafis.Service;


import com.example.munafis.Repository.ProductsDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsDetailsService {

    private final ProductsDetailsRepository productsDetailsRepository;

}
