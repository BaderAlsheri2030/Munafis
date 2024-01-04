package com.example.munafis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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


    @ManyToOne
    @JoinColumn(name = "offer_id" , referencedColumnName = "id")
    @JsonIgnore
    private RFP rfp;

    @ManyToOne
    @JoinColumn(name = "provider_id" , referencedColumnName = "id")
    @JsonIgnore
    private Provider provider;

}
