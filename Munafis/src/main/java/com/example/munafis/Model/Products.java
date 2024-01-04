package com.example.munafis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Products {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private double price;

//    @ManyToOne
//    @JoinColumn(name = "provider_id" , referencedColumnName = "id")
//    @JsonIgnore
//    private Provider provider;
//
//    @ManyToOne
//    @JoinColumn(name = "order_id" , referencedColumnName = "id")
//    @JsonIgnore
//    private Order order;
//
//
//
//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "products")
//    @PrimaryKeyJoinColumn
//    private ProductsDetails productsDetails;



}
