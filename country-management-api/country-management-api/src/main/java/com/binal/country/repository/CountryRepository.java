package com.binal.country.repository;

import com.binal.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
    List<Country> findByNameIn(List<String> nameList );

    Country findByName( String name);

}
