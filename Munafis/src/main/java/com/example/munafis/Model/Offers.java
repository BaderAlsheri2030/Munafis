package com.example.munafis.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Offers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    private String description;

    private LocalDate deadLine;

    private double price;


    private String status;

    private String conditions;

}
