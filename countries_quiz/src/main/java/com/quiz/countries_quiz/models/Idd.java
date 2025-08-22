package com.quiz.countries_quiz.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Idd {
    private String root;
    private List<String> suffixes;
}
