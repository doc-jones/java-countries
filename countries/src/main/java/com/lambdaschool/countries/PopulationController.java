package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController {
    // localhost:2019/population/size/1000000000
    @GetMapping(value = "/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> findLargerPopulations(@PathVariable long people)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.
                findCountries(c -> c.getPopulation() >= people);

        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // localhost:2019/population/min
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> findMinPopulation()
    {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));

        Country rtnCountry = CountriesApplication.ourCountryList.countryList.get(0);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // localhost:2019/population/max
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> findMaxPopulation()
    {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));

        Country rtnCountry = CountriesApplication.ourCountryList.countryList.get(0);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
}
