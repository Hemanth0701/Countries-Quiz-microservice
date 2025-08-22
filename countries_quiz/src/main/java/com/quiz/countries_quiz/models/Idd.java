package com.quiz.countries_quiz.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class Idd {
    private String root;
    private List<String> suffixes;
}
