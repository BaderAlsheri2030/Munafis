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
public class ProductsDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Integer quantity;

//    @OneToOne
//    @MapsId
//    @JsonIgnore
//    private Products products;



}
