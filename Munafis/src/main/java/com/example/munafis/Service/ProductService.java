package com.example.munafis.Service;

import com.example.munafis.API.ApiException;
import com.example.munafis.DTO.ProductDTO;
import com.example.munafis.Model.Products;
import com.example.munafis.Model.Provider;
import com.example.munafis.Repository.ProductRepository;
import com.example.munafis.Repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProviderRepository providerRepository;


    public List getAllProducts(){
        return productRepository.findAll();
    }

//    public void addProduct(ProductDTO productDTO){
//        Provider provider = providerRepository.getProvidersById(productDTO.getProvider_id());
//        if(provider==null){
//            throw new ApiException("provider Id not found");
//        }
//
//        Products products = new Products(null,productDTO.getName(),productDTO.getPrice(),provider,null,null);
//        productRepository.save(products);
//    }

    public void updateProduct(Integer id,ProductDTO productDTO){

        Products oldProduct = productRepository.findProductsById(id);
        if(oldProduct==null){
            throw new ApiException("Product Id not found");
        }

        oldProduct.setName(productDTO.getName());
        oldProduct.setPrice(productDTO.getPrice());
        productRepository.save(oldProduct);
    }


}
