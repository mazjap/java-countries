package local.mazjap.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class CountryController {
    @GetMapping(value = "/allcountries",
            produces = "application/json")
    public ResponseEntity<?> fetchCountries() {
        return new ResponseEntity<>(CountriesApplication.countryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/country/byName/{countryName}",
            produces = "application/json")
    public ResponseEntity<?> fetchCountry(@PathVariable String countryName) {
        Country c = CountriesApplication.countryList.getCountryByName(countryName);
        if (c != null) {
            return new ResponseEntity<>(c, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/country/byLetter/{c}",
            produces = "application/json")
    public ResponseEntity<?> fetchCountryByLetter(@PathVariable char c) {
        return new ResponseEntity<>(CountriesApplication.countryList.getCountryByLetter(c), HttpStatus.OK);
    }
}
