package com.quiz.countries_quiz.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
@Getter
@Setter
@ToString
public class Name {
    private String common;
    private String official;
    private Map<String, NativeName> nativeName;
}
