package com.binal.country.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY )
    private Integer id;

    private String countryName;

    private String countryCapital;

    private String countryCode;
}
