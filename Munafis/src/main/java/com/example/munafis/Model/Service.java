package com.example.munafis.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

<<<<<<< HEAD
    @Column(columnDefinition = "varchar(225) not null")
=======
>>>>>>> 6b0c59148d9b5ccd5fa6674efd3e094688e090e6
    private String serviceName;
    @Column(columnDefinition = "varchar(225) not null")
    private String serviceType;
    @Column(columnDefinition = "varchar(225) not null")
    private String serviceDetails;
    @Column(columnDefinition = "double not null")
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


}
