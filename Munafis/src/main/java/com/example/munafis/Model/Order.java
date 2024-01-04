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
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
<<<<<<< HEAD:Munafis/src/main/java/com/example/munafis/Model/Orderr.java
    @Column(columnDefinition = "double")
    private double price;
    @Column(columnDefinition = "varchar(225) not null")
=======
    @Column
>>>>>>> 6b0c59148d9b5ccd5fa6674efd3e094688e090e6:Munafis/src/main/java/com/example/munafis/Model/Order.java
    private String status;
    @Column
    private double totalPrice;


<<<<<<< HEAD:Munafis/src/main/java/com/example/munafis/Model/Orderr.java
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderr")
    private Set<Service> services;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderr")
    private Set<Products> products;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderr")
    private Set<Company> companies;
=======



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
>>>>>>> 6b0c59148d9b5ccd5fa6674efd3e094688e090e6:Munafis/src/main/java/com/example/munafis/Model/Order.java




}
