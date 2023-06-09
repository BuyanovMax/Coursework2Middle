package com.example.coursework2middle;

import com.example.coursework2middle.essences.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question find(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();


}
