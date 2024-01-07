package com.example.munafis.Controller;


import com.example.munafis.Model.*;
import com.example.munafis.Service.ProviderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/provider")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;



    //Admin
    @GetMapping("get")
    public ResponseEntity getAllProviders(){
        return ResponseEntity.status(200).body(providerService.getAllProviders());
    }


    @PostMapping("/add")
    public ResponseEntity addProvider(@Valid @RequestBody Provider provider){
        providerService.addProvider(provider);
        return ResponseEntity.status(200).body("provider added");
    }



    @PutMapping("/update/{id}")
    public ResponseEntity updateProvider(@PathVariable Integer id,@Valid @RequestBody Provider provider){
        providerService.updateProvider(id, provider);
        return ResponseEntity.status(200).body("provider updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProvider(@PathVariable Integer id){
      providerService.deleteProvider(id);
        return ResponseEntity.status(200).body("provider deleted");
    }



    //ALL
    @GetMapping("/getAllProductsByProvider/{providerName}")
    public ResponseEntity getAllProductsByProvider(@PathVariable String providerName){
        Set<Product> products =providerService.getAllProductsByProvider(providerName);
        return ResponseEntity.status(200).body(products);
    }


    @GetMapping("/getAllServicesByProvider/{providerName}")
    public ResponseEntity getAllServicesByProvider(@PathVariable String providerName){
        Set<Service> services =providerService.getAllServicesByProvider(providerName);
        return ResponseEntity.status(200).body(services);
    }

    @GetMapping("/viewMyAcceptedOffers/{provider_id}")
    public ResponseEntity viewMyAcceptedOffers(@PathVariable Integer provider_id) {
        List<Offer> offers =providerService.viewMyAcceptedOffers(provider_id);
        return ResponseEntity.status(200).body(offers);
    }


    @GetMapping("/viewMyPendingOffers/{provider_id}")
    public ResponseEntity viewMyPendingOffers(@PathVariable Integer provider_id) {
        List<Offer> offers =providerService.viewMyPendingOffers(provider_id);
        return ResponseEntity.status(200).body(offers);
    }

    @GetMapping("/viewMyRejectedOffers/{provider_id}")
    public ResponseEntity viewMyRejectedOffers(@PathVariable Integer provider_id) {
        List<Offer> offers =providerService.viewMyRejectedOffers(provider_id);
        return ResponseEntity.status(200).body(offers);
    }
}
