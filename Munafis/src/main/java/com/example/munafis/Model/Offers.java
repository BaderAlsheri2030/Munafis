package com.example.munafis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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



    @NotNull(message = "description cannot be null")
    private String description;
    private LocalDate deadLine;
    @Column(columnDefinition = "double not null")
    private double price;
    @NotNull(message = "status cannot be null")
    private String status;
    @NotNull(message = "conditions cannot be null")
    private String conditions;


//    @ManyToOne
//    @JoinColumn(name = "offer_id" , referencedColumnName = "id")
//    @JsonIgnore
//    private RFP rfp;
//
//    @ManyToOne
//    @JoinColumn(name = "provider_id" , referencedColumnName = "id")
//    @JsonIgnore
//    private Provider provider;

}
