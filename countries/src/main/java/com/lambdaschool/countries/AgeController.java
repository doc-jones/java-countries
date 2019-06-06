package com.lambdaschool.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController
{
@GetMapping(value = "/age/{age}",
        produces = {"application/json"})
public ResponseEntity<?> findOlderPeople(
@PathVariable
                    long age)
                            {
                            ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.
        findCountries(c -> c.getAge() >= age);

        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
        }

// localhost:2019/age/min
@GetMapping(value = "/min",
        produces = {"application/json"})
public ResponseEntity<?> findMinAge()
        {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> (c1.getAge() - c2.getAge()));

        Country rtnCountry = CountriesApplication.ourCountryList.countryList.get(0);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
        }

// localhost:2019/age/max
@GetMapping(value = "/max",
        produces = {"application/json"})
public ResponseEntity<?> findMaxAge()
        {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2) -> (c2.getAge() - c1.getAge()));

        Country rtnCountry = CountriesApplication.ourCountryList.countryList.get(0);
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
        }
        }
