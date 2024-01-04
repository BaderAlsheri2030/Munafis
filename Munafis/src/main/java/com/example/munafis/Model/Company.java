package com.example.munafis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String username;

    private String password;

    private String email;

    private String companyName;

    private String businessNumber;

    private String address;

    private String role;


    @ManyToOne
    @JoinColumn(name = "orderr_id" , referencedColumnName = "id")
    @JsonIgnore
    private Orderr orderr;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private Set<RFP> rfps;
}
