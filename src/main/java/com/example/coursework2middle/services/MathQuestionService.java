package com.example.coursework2middle.services;
import com.example.coursework2middle.essences.MathQuestionsRepository;
import com.example.coursework2middle.essences.Question;
import com.example.coursework2middle.QuestionService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Component
public class MathQuestionService implements QuestionService {

    private final MathQuestionsRepository mathQuestionsRepository;

    public MathQuestionService(MathQuestionsRepository mathQuestionsRepository) {
        this.mathQuestionsRepository = mathQuestionsRepository;
    }

    Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return mathQuestionsRepository.add(question,answer);
    }


    public Question find(Question question) {
        return mathQuestionsRepository.find(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionsRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(mathQuestionsRepository.getAll());
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list =  mathQuestionsRepository.getAll().stream().toList();
        int a = random.nextInt(0, mathQuestionsRepository.getAll().size());
        return list.get(a);
    }

}


