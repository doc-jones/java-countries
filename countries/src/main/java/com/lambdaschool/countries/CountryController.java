package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController {

    //    localhost:2019/data/all
    @RequestMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getallCountries() {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getCname().compareToIgnoreCase(c2.getCname()));
        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    //  localhost:2019/data/country/2
    @GetMapping(value = "/country/{id}", produces = {"application/json"})

    public ResponseEntity<?> getCountryDetail(@PathVariable long id) {
        Country rtnCountry = CountriesApplication.ourCountryList.findCountry(c -> (c.getId() == id));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    //  localhost:2019/data/population/size
    @GetMapping(value = "/population/size/{num}", produces = {"application/json"})

    public ResponseEntity<?> getCountryDetail(@PathVariable int population) {
        Country rtnCountry = CountriesApplication.ourCountryList.findCountry(c -> (c.getPopulation() == population));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    //    localhost:2019/data/cnames/s
    @GetMapping(value = "/cnames/{letter}",
            produces = {"application/json"})

    public ResponseEntity<?> getCountries(
            @PathVariable
                    char letter)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.
                findCountries(c -> c.getCname().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

}
