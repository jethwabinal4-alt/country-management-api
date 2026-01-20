package com.binal.country.service;

import com.binal.country.dto.CountryDto;
import com.binal.country.entity.Country;
import com.binal.country.exception.ResourceFoundException;
import com.binal.country.exception.ResourceNotFoundException;
import com.binal.country.mapper.CountryMapper;
import com.binal.country.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    public List<CountryDto> addingCountry(List<CountryDto> countryDtoList){
        log.info("[CountryService] [addingCountry]  adding countries {}.", countryDtoList.size());
        List<Country> countryList = countryMapper.maoToEntity(countryDtoList);

        List<String> countryString= new ArrayList<>();
        for(Country country:countryList){
            countryString.add(country.getName());
        }
        List<Country> countryList1 = countryRepository.findByNameIn(countryString);
        if (!countryList1.isEmpty()){
            throw new ResourceFoundException("Country with this name already exists.");
        }
        List<Country> countries1 = countryRepository.saveAll(countryList1);
        return countryMapper.maoToDto(countries1);
    }

    public CountryDto addCountry(CountryDto countryDto){
        log.info("[CountryService] [addCountry]  adding single countries {}.", countryDto);
        Country country = countryMapper.map(countryDto);
        Country country1 = countryRepository.findByName(country.getName());
        if (country1 != null){
            throw new ResourceFoundException("Country with this name already exists.");
        }
        Country country2 = countryRepository.save(country);
        return countryMapper.map(country2);
    }

    public List<CountryDto> getCountry(){
        log.info("[CountryService] [getCountry]  getting all countries.");
        List<Country> countries = countryRepository.findAll();
        return countryMapper.maoToDto(countries);
    }
    
    public Country getCountryById(int id){
        log.info("[CountryService] [getCountryById]  getting country by id{}.", id);
        Optional<Country> byId = countryRepository.findById(id);
        if(byId.isEmpty()){
            throw new ResourceNotFoundException("No Country with this id.");
        }
        return byId.get();
    }

    public CountryDto updateCountryByID(int id,CountryDto countryDto){
        log.info("[CountryService] [updateCountry]  updating country by id{}.", id);
        Country country1 = getCountryById(id);
        Country country = countryMapper.convertDtoToEntity(country1,countryDto);
        Country country2 = countryRepository.save(country);
        log.info("[CountryService] [updateCountry]  updated country by id{}.", id);
        return countryMapper.convertEntityToDto(countryDto,country2);
    }

    public void deleteById(int id){
        log.info("[CountryService] [deleteById]  deleting country by id{}.", id);
        Country country = getCountryById(id);
        countryRepository.delete(country);
    }

    public void deleteCountry(){
        log.info("[CountryService] [deleteCountry]  deleting all countries.");
        countryRepository.deleteAll();
    }
}
