package com.example.munafis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(225) not null")
    private String name;
    private Integer stock;
    @Column(columnDefinition = "double not null")
    private double price;



    @ManyToOne
    @JoinColumn(name = "provider_id" , referencedColumnName = "id")
    @JsonIgnore
    private Provider provider;

//    @ManyToOne
//    @JoinColumn(name = "order_id" , referencedColumnName = "id")
//    @JsonIgnore
//    private Orderr order;



//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "product")
//    @PrimaryKeyJoinColumn
//    private ProductsDetails productsDetails;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private Set<ProductsDetails> productsDetailsSet;



}
