package com.example.munafis.DTO;

import com.example.munafis.Model.Offer;
import com.example.munafis.Model.Product;
import com.example.munafis.Model.Service;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class ProviderDTO {
    private Integer user_id;
    @NotNull(message = "address cannot be null")
    private String address;
    @NotNull(message = "business number cannot be null")
    private String business_number;
    @NotNull(message = "company name cannot be null")
    private String company_name;
    @NotNull(message = "field cannot be null")
    private String field;
    private Set<Service> services;
    private Set<Product> products;
    private Set<Offer> offers;
}