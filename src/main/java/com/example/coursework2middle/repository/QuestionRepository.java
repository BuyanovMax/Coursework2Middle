package com.example.coursework2middle.repository;

import com.example.coursework2middle.essences.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
@Repository
public interface QuestionRepository {
    Question add(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();

}
