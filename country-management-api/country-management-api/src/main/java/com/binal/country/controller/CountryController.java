package com.binal.country.controller;

import com.binal.country.dto.CountryDto;
import com.binal.country.entity.Country;
import com.binal.country.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/country-api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/adding-country")
    public ResponseEntity<List<CountryDto>> addingCountry(@RequestBody List<CountryDto> countryDtoList){
        log.info("[CountryController] [addingCountry] adding countries.{}", countryDtoList.size());
        List<CountryDto> countryDtoList1 = countryService.addingCountry(countryDtoList);
        return new ResponseEntity<>(countryDtoList1,HttpStatus.CREATED);
    }

    @PostMapping("add-country")
    public ResponseEntity<CountryDto> addCountry(@RequestBody CountryDto countryDto){
        log.info("[CountryController] [addCountry] adding single countries.{}", countryDto);
        CountryDto country1 = countryService.addCountry(countryDto);
        return new ResponseEntity<>(country1,HttpStatus.CREATED);
    }

    @GetMapping("/get-country")
    public ResponseEntity<List<CountryDto>> getCountry(){
        log.info("[CountryController] [getCountry] getting countries.");
        List<CountryDto> country = countryService.getCountry();
        return new ResponseEntity<>(country,HttpStatus.OK);
    }

    @GetMapping("get-byId/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable int id){
        log.info("[CountryController] [getCountryById]  getting country by id{}.", id);
        Country country = countryService.getCountryById(id);
        return new ResponseEntity<>(country,HttpStatus.OK);
    }

    @PutMapping("/update-byId/{id}")
    public ResponseEntity<CountryDto> updateCountryById(@PathVariable int id,@RequestBody CountryDto countryDto){
        log.info("[CountryController] [updateCountry]  updating country by id{}.", id);
        CountryDto country1 = countryService.updateCountryByID(id,countryDto);
        return new ResponseEntity<>(country1,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-byId/{id}")
    public ResponseEntity<?> deleteCountryById(@PathVariable int id){
        log.info("[CountryController] [deleteCountryById]  deleting country by id{}.", id);
        countryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete-country")
    public ResponseEntity<?> deleteCountry(){
        log.info("[CountryController] [deleteCountry]  deleting country.");
        countryService.deleteCountry();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
