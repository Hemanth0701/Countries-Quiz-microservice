package com.quiz.countries_quiz.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignore fields not mapped
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Country {
    private Name name;
    private List<String> tld;
    private String cca2;
    private String cca3;
    private String cioc;
    private String fifa;
    private boolean independent;
    private boolean unMember;
    private Map<String, Currency> currencies;
    private Idd idd;
    private List<String> capital;
    private CapitalInfo capitalInfo;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private List<String> continents;
    private Map<String, String> languages;
    private Map<String, Translation> translations;
    private List<Double> latlng;
    private boolean landlocked;
    private List<String> borders;
    private double area;
    private String flag;
    private Map<String, Demonym> demonyms;
    private Flags flags;
    private CoatOfArms coatOfArms;
    private long population;
    private Maps maps;
    private Car car;
    private PostalCode postalCode;
    private List<String> timezones;
    private String startOfWeek;
}
