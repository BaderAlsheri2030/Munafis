package com.example.munafis.DTO;

import com.example.munafis.Model.Orderr;
import com.example.munafis.Model.Rfp;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CompanyDTO {

    @NotNull(message = "UserName cannot be null")
    private String username;
    @NotNull(message = "Password cannot be null")
    private String password;
    @Email(message = "Must be a valid email")
    @NotNull(message = "email cannot be null")
    private String email;
    @Pattern(regexp = "^(Company|Provider)$" , message = "Role must be Company or Provider only")
    private String role;
    @NotNull(message = "company name cannot be null")
    private String companyName;
    @NotNull(message = "business number cannot be null")
    private String businessNumber;
    @NotNull(message = "address cannot be null")
    private String address;

//    private Integer user_id;
//    @NotNull(message = "address cannot be null")
//    private String address;
//    @NotNull(message = "business number cannot be null")
//    private String business_number;
//    @NotNull(message = "company name cannot be null")
//    private String company_name;
//    private Set<Orderr> orders;
//    private Set<Rfp> rfps;
}