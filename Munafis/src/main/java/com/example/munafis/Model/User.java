package com.example.munafis.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^(Admin|Company|Provider)$" , message = "Role must be in admin, Company or Provider only")
    @Column(columnDefinition = "varchar(10) not null check (role='Admin' or role='Company' or role='Provider')")
    private String role;
}
