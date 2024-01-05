package com.example.munafis.Model;


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
public class Provider {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String email;
    private String companyName;
    private String businessNumber;
    private String address;
    private String role;
    private String field;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "provider")
    private Set<Service> services;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "provider")
    private Set<Product> products;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "provider")
    private Set<Offers> offers;
}
