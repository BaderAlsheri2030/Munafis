package com.example.munafis.Service;

import com.example.munafis.API.ApiException;
import com.example.munafis.DTO.ProductDTO;
import com.example.munafis.Model.Product;
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


    //ALL
    public List getAllProducts(){

        return productRepository.findAll();
    }



    //Only provider
//    public List getMyProducts(){
//
//    }







    //Only provider
    public void addProduct(ProductDTO productDTO){
        Provider provider = providerRepository.getProvidersById(productDTO.getProvider_id());
        if(provider==null){
            throw new ApiException("provider Id not found");
        }

        Product product = new Product(null,productDTO.getName(),productDTO.getPrice(),provider,null,null);
        productRepository.save(product);
    }




    //Only provider
    public void updateProduct(Integer id,ProductDTO productDTO){

        Product oldProduct = productRepository.findProductsById(id);
        if(oldProduct==null){
            throw new ApiException("Product Id not found");
        }

        oldProduct.setName(productDTO.getName());
        oldProduct.setPrice(productDTO.getPrice());
        productRepository.save(oldProduct);
    }




    //Only provider
    public void deleteProduct(Integer id){
        Product product=productRepository.findProductsById(id);
        if(product==null){
            throw new ApiException("Product Id not found");
        }
        productRepository.delete(product);
    }

}
