package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NameController
{
    // localhost:2019/names/all
    @GetMapping(value = "all")
    public ResponseEntity<?> getAllCountries()
    {
        CountriesApplication.ourCountryList.countryList.sort((c1, c2 ) -> c1.getCname().compareToIgnoreCase(c2.getCname()));

        return new ResponseEntity<>(CountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }


    // localhost:2019/names/start/s
    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesWithStartLetter(
            @PathVariable
                    char letter)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.
                findCountries(c -> c.getCname().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountries.sort((c1, c2 ) -> c1.getCname().compareToIgnoreCase(c2.getCname()));

        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }


    // localhost:2019/names/size/20
    @GetMapping(value = "/size/{number}")
    public ResponseEntity<?> getCountriesNameSize(@PathVariable int number)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCountryList.
                findCountries(c -> c.getCname().length() >= number);
        rtnCountries.sort((c1, c2 ) -> c1.getCname().compareToIgnoreCase(c2.getCname()));

        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }
}
