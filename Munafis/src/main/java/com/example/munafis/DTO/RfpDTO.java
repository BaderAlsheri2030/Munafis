package com.example.munafis.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RfpDTO {

    private String competition_type;
    private Integer contract_length;
    private LocalDate dead_line;
    private String description;
    private String reference_number;
    private String service_details;
    private LocalDate time_left;
    private String title;
    private Integer company_id;
    private Integer competition_id;

}
