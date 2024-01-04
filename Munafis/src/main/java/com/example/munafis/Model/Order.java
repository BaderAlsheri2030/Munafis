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
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String status;
    @Column
    private double totalPrice;





//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
//    private Set<Service> services;
//
//
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
//    private Set<Products> products;
//
//
//
//    @ManyToOne
//    @JoinColumn(name = "company_id",referencedColumnName = "id")
//    @JsonIgnore
//    private Company company;




}
