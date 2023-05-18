package com.example.coursework2middle.services;


import com.example.coursework2middle.Question;
import com.example.coursework2middle.QuestionService;
import com.example.coursework2middle.exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questions = new HashSet<>();
    Random random = new Random();


    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question,answer);
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new QuestionNotFoundException("Question not found");
    }

    @Override
    public Collection<Question> getAll() {
        return questions.stream().collect(Collectors.toList());
    }

    @Override
    public Question getRandomQuestion() {
       List<Question> list =  questions.stream().collect(Collectors.toList());
        int a = random.nextInt(0, questions.size());
        return list.get(a);
    }



}
