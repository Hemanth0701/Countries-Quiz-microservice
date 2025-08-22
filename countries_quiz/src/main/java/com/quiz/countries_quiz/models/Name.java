package com.quiz.countries_quiz.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class Name {
    private String common;
    private String official;
    private Map<String, NativeName> nativeName;
}
