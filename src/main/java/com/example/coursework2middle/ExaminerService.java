package com.example.coursework2middle;

import com.example.coursework2middle.essences.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
