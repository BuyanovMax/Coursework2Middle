package com.example.coursework2middle.essences;

import com.example.coursework2middle.repository.QuestionRepository;
import com.example.coursework2middle.exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MathQuestionsRepository implements QuestionRepository {

    Set<Question> mathQuestions = new HashSet<>();



    @PostConstruct
    public void init() {
        mathQuestions.add(new Question("Question1", "Answer1"));
        mathQuestions.add(new Question("Question2", "Answer2"));
        mathQuestions.add(new Question("Question3", "Answer3"));
        mathQuestions.add(new Question("Question4", "Answer4"));
        mathQuestions.add(new Question("Question5", "Answer5"));
        mathQuestions.add(new Question("Question6", "Answer6"));
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question,answer);
        mathQuestions.add(question1);
        return question1;
    }

    public Question find(Question question) {
        if (mathQuestions.contains(question)) {
            return question;
        } else {
            throw new QuestionNotFoundException("Вопрос не найден");
        }
    }

    @Override
    public Question remove(Question question) {
        if (mathQuestions.contains(question)) {
            mathQuestions.remove(question);
            return question;
        }
        throw new QuestionNotFoundException("Question not found");
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestions.stream().collect(Collectors.toList());
    }
}
