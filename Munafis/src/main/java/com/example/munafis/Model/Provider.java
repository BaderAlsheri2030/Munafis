package com.example.munafis.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Provider {


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


    /////

    private String field;




}
