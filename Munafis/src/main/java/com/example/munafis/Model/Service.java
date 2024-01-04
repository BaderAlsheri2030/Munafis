package com.example.munafis.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Service {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String serviceName;

    private String serviceType;

    private String serviceDetails;

    private double price;


}
