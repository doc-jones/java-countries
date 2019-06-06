package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
