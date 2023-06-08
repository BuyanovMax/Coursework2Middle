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
public class JavaQuestionsRepository implements QuestionRepository {

    Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        questions.add(new Question("Question11", "Answer11"));
        questions.add(new Question("Question22", "Answer22"));
        questions.add(new Question("Question33", "Answer33"));
        questions.add(new Question("Question44", "Answer44"));
        questions.add(new Question("Question55", "Answer55"));
        questions.add(new Question("Question66", "Answer66"));
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question,answer);
        questions.add(question1);
        return question1;
    }

    public Question find(Question question) {
        if (questions.contains(question)) {
            return question;
        } else {
            throw new QuestionNotFoundException("Вопрос не найден");
        }
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
}
