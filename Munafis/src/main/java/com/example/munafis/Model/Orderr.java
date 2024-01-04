package com.example.munafis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Orderr {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double price;


    private String status;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderr")
    private Set<Service> services;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderr")
    private Set<Products> products;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderr")
    private Set<Company> companies;




}
