package com.quiz.countries_quiz.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostalCode {
    private String format;
    private String regex;
}
