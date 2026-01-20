package com.binal.country.mapper;

import com.binal.country.dto.CountryDto;
import com.binal.country.entity.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CountryMapper {

    public Country map(CountryDto countryDto){
        return convertDtoToEntity(null,countryDto);
    }

    public Country convertDtoToEntity(Country country,CountryDto countryDto){
        if (Objects.isNull(country)){
            country = new Country();
        }
        country.setName(countryDto.getCountryName());
        country.setCapital(countryDto.getCountryCapital());
        country.setCode(countryDto.getCountryCode());
        return country;
    }

    public CountryDto map(Country country){
        return convertEntityToDto(null,country);
    }

    public CountryDto convertEntityToDto(CountryDto countryDto,Country country){
        if (Objects.isNull(countryDto)){
            countryDto = new CountryDto();
        }
        countryDto.setCountryName(country.getName());
        countryDto.setCountryCapital(country.getCapital());
        countryDto.setCountryCode(country.getCode());
        return countryDto;
    }

    public List<Country> maoToEntity(List<CountryDto> countryDtoList){
        List<Country> countryList = new ArrayList<>();
        for (CountryDto countryDto:countryDtoList){
            Country country = new Country();
            country.setName(countryDto.getCountryName());
            country.setCapital(countryDto.getCountryCapital());
            country.setCode(countryDto.getCountryCode());
            countryList.add(country);
        }
        return countryList;
    }

    public List<CountryDto> maoToDto(List<Country> countryList){
        List<CountryDto> countryDtoList = new ArrayList<>();
        for (Country country:countryList){
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryName(country.getName());
            countryDto.setCountryCapital(country.getCapital());
            countryDto.setCountryCode(country.getCode());
            countryDtoList.add(countryDto);
        }
        return countryDtoList;
    }

}
