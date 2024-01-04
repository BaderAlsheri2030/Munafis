package com.example.munafis.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ServiceDTO {


    private Integer provider_id;
    private String serviceName;
    private String serviceType;
    private String serviceDetails;
    private double price;


}
