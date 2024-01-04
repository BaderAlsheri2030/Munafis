package com.example.munafis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @Column(columnDefinition = "double")
    private double price;
    @Column(columnDefinition = "varchar(225) not null")
    private String status;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderr")
    private Set<Service> services;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderr")
    private Set<Products> products;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderr")
    private Set<Company> companies;




}
