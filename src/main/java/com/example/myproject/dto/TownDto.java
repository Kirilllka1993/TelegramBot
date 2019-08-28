package com.example.myproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TownDto {
    private long id;
    private String description;
    private String country;
    private String foundationYear;
    private String townName;


}
