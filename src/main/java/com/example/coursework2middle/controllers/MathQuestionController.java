package com.example.coursework2middle.controllers;

import com.example.coursework2middle.essences.Question;
import com.example.coursework2middle.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("exam/java/math")
@Qualifier("mathQuestionService")
public class MathQuestionController {


    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService")QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping(path = "/add")
    public Question addMathQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }
    @GetMapping(path = "/find")
    public Question findMathQuestion(Question question) {
        return questionService.find(question);
    }
    @GetMapping(path = "/remove")
    public Question removeMathQuestion(Question question) {
        return questionService.remove(question);
    }
    @GetMapping()
    public Collection<Question> getAllMath() {
        return questionService.getAll();
    }

}
