package com.example.munafis.Service;


import com.example.munafis.API.ApiException;
import com.example.munafis.Model.Provider;
import com.example.munafis.Repository.ProductsDetailsRepository;
import com.example.munafis.Repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;

    public List getAllProviders(){
        return providerRepository.findAll();
    }


    //Register
    public void addProvider(Provider provider){

        providerRepository.save(provider);
    }



    public void updateProvider(Integer id, Provider provider){
        Provider oldProvider=providerRepository.getProvidersById(id);
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
        Provider provider=providerRepository.getProvidersById(id);

        if(provider==null){
            throw new ApiException("Provider id not found");
        }
        providerRepository.delete(provider);
    }


}
