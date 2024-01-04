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

}
