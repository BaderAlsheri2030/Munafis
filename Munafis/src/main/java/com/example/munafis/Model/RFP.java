package com.example.munafis.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
public class RFP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private String referenceNumber;

    private String competitionType;


    private LocalDate deadLine;

    private Integer contractLength;

    private String serviceDetails;

    private String title;
    private LocalDate timeLeft;


    @ManyToOne
    @JoinColumn(name = "company_id" , referencedColumnName = "id")
    @JsonIgnore
    private Company company;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "rfp")
    private Set<Offers> offersSet;

    @ManyToOne
    @JoinColumn(name = "competition_id" , referencedColumnName = "id")
    @JsonIgnore
    private Competition competition;


}
