package com.lambdaschool.countries;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/population")
public class PopulationController {
    //    localhost:2019/population/size/{number}
    //    return the countries alphabetically that have a name equal to or longer than the given length
    @GetMapping(value = "/size/{number}", produces = {"application/json"}) {
        public ResponseEntity<?> checkCnameLength(@PathVariable int number) {

            Country tempCountry = new Country(CountriesApplication.ourCountryList.findCountry(c ->(c.getSize()==population)));
            tempCountry.setSize(tempCountry.getSize() );
        }
    }
}
