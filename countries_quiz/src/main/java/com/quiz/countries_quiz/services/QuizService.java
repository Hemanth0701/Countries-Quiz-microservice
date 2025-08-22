package com.quiz.countries_quiz.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.countries_quiz.models.Country;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class QuizService {

    public List<Country> getCountries() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = QuizService.class.getClassLoader().getResourceAsStream("countriesV3.1.json");

        if (is == null) {
            throw new RuntimeException("countriesV3.json not found in resources folder!");
        }

        // Load JSON into Country list
        List<Country> countries = mapper.readValue(is, new TypeReference<List<Country>>() {});
        System.out.println("Loaded " + countries.size() + " countries");

        // Split countries into 5 maps cyclically using shifted index strategy
        List<Map<Integer, Country>> maps = splitCountriesShifted(countries, 5, 50);

        // Pick 4 unique random countries from each map
        int countriesPerMap = 4;
        List<Country> selectedCountries = new ArrayList<>();

        for (int mapIndex = 0; mapIndex < maps.size(); mapIndex++) {
            Map<Integer, Country> map = maps.get(mapIndex);
            List<Integer> keys = new ArrayList<>(map.keySet());
            Collections.shuffle(keys);

            System.out.println("Map " + (mapIndex + 1) + ":");
            for (int i = 0; i < countriesPerMap && i < keys.size(); i++) {
                int key = keys.get(i);
                Country country = map.get(key);
                selectedCountries.add(country);
                System.out.println("  Index " + key + " → " + country.getName().getCommon());
            }
            System.out.println();
        }

        // selectedCountries now contains 20 countries (4 from each map)
        System.out.println(selectedCountries.size());
        for(Country country: selectedCountries)
            System.out.println(country.getName());
        return countries;
    }

    public static List<Map<Integer, Country>> splitCountriesShifted(List<Country> countries, int mapCount, int sizePerMap) {
        List<Map<Integer, Country>> result = new ArrayList<>();
        int totalCountries = countries.size();

        // Initialize empty maps
        for (int m = 0; m < mapCount; m++) {
            result.add(new LinkedHashMap<>());
        }

        // Fill maps with shifted indices
        for (int m = 0; m < mapCount; m++) {
            Map<Integer, Country> map = result.get(m);
            for (int i = 0; i < sizePerMap; i++) {
                int countryIndex = m + i * mapCount;
                if (countryIndex < totalCountries) {
                    map.put(i, countries.get(countryIndex));
                }
            }
        }

        return result;
    }

}
