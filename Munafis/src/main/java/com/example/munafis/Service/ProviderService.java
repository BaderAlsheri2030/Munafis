package com.example.munafis.Service;


import com.example.munafis.API.ApiException;
import com.example.munafis.Model.Orderr;
import com.example.munafis.Model.Product;
import com.example.munafis.Model.Provider;
import com.example.munafis.Model.Provider;
import com.example.munafis.Repository.OrderRepository;
import com.example.munafis.Repository.ProductsDetailsRepository;
import com.example.munafis.Repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public List getAllProviders(){
        return providerRepository.findAll();
    }


    //Register
    public void addProvider(Provider provider){
        providerRepository.save(provider);

    }


    public void updateProvider(Integer id, Provider provider){
        Provider oldProvider=providerRepository.findProviderById(id);
        if(oldProvider==null){
            throw new ApiException("Provider id not found");
        }

        oldProvider.setAddress(provider.getAddress());
        oldProvider.setField(provider.getField());
        oldProvider.setBusinessNumber(provider.getBusinessNumber());
        oldProvider.setOffers(provider.getOffers());
        oldProvider.setServices(provider.getServices());
        oldProvider.setCompanyName(provider.getCompanyName());
        oldProvider.setProducts(provider.getProducts());

        providerRepository.save(oldProvider);

    }


    public void deleteProvider(Integer id){
        Provider provider=providerRepository.findProviderById(id);

        if(provider==null){
            throw new ApiException("Provider id not found");
        }
        providerRepository.delete(provider);
    }

    //ALL
    public Set<Product> getAllProductsByProvider(String providerName){
        Provider provider = providerRepository.findByCompanyName(providerName);
        if(provider==null){
            throw new ApiException("company name not available");
        }
        if(provider.getProducts().isEmpty()){
            throw new ApiException("this provider not have products");
        }
        return provider.getProducts();
    }


    //ALL
    public Set<com.example.munafis.Model.Service> getAllServicesByProvider(String providerName){
        Provider provider = providerRepository.findByCompanyName(providerName);
        if(provider==null){
            throw new ApiException("company name not available");
        }
        if(provider.getServices().isEmpty()){
            throw new ApiException("this provider not have Services");
        }
        return provider.getServices();
    }


    public List<Orderr> getOrderAllByStatus(String status){
        List<Orderr> orders = orderRepository.findAllByStatus(status);
        if(orders.isEmpty()){
            throw new ApiException("not orders");
        }
        return orders;

    }

}
