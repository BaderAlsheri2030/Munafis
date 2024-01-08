package com.example.munafis.DTO;

import com.example.munafis.Model.Orderr;
import com.example.munafis.Model.Rfp;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class CompanyDTO {

    private Integer user_id;
    @NotNull(message = "address cannot be null")
    private String address;
    @NotNull(message = "business number cannot be null")
    private String business_number;
    @NotNull(message = "company name cannot be null")
    private String company_name;
    private Set<Orderr> orders;
    private Set<Rfp> rfps;
}