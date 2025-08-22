package com.quiz.countries_quiz.controller;

import com.quiz.countries_quiz.models.Country;
import com.quiz.countries_quiz.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private QuizService quizService;

    @GetMapping(value = "/getCountries")
    public ResponseEntity<List<Country>> getCountries() throws IOException {
        return ResponseEntity.ok(quizService.getCountries());
    }
}
