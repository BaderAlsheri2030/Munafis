package com.example.munafis.DTO;

import com.example.munafis.Model.Offer;
import com.example.munafis.Model.Product;
import com.example.munafis.Model.Service;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class ProviderDTO {
    private Integer user_id;
//    @NotNull(message = "address cannot be null")
//    private String address;
//    @NotNull(message = "business number cannot be null")
//    private String business_number;
//    @NotNull(message = "company name cannot be null")
//    private String company_name;
//    @NotNull(message = "field cannot be null")

    @Column(columnDefinition = "varchar(50) not null unique")
    @NotNull(message = "UserName cannot be null")
    private String username;
    @Column(columnDefinition = "varchar(50) not null")
    @NotNull(message = "Password cannot be null")
    private String password;
    @Column(columnDefinition = "varchar(50) not null unique")
    @Email(message = "Must be a valid email")
    @NotNull(message = "email cannot be null")
    private String email;
    @Pattern(regexp = "^(Company|Provider)$" , message = "Role must be Company or Provider only")
    @Column(columnDefinition = "varchar(10) not null check (role='Company' or role='Provider')")
    private String role;
    @Column(columnDefinition = "varchar(50) not null")
    @NotNull(message = "company name cannot be null")
    private String companyName;
    @Column(columnDefinition = "varchar(50) not null unique")
    @NotNull(message = "business number cannot be null")
    private String businessNumber;
    @Column(columnDefinition = "varchar(50) not null")
    @NotNull(message = "address cannot be null")
    private String address;
    private String field;
    private Set<Service> services;
    private Set<Product> products;
    private Set<Offer> offers;
}