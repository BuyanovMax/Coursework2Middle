package com.example.coursework2middle.services;


import com.example.coursework2middle.ExaminerService;
import com.example.coursework2middle.essences.MathQuestionsRepository;
import com.example.coursework2middle.essences.Question;
import com.example.coursework2middle.QuestionService;
import com.example.coursework2middle.exceptions.ChooseFewerQuestionsException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Service
@Component
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {

        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;

    }


    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> set = new HashSet<>();
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new ChooseFewerQuestionsException("choose fewer questions");
        }

//        for (int i = 0; i < amount; i++) {
//            Question question = questionService.getRandomQuestion();
//            if (set.contains(question)) {
//                i -= 1;
//            } else {
//                set.add(question);
//            }
//        }

        int ii = 0;
        while (ii < amount) {
            Question question = javaQuestionService.getRandomQuestion();
            Question question1 = mathQuestionService.getRandomQuestion();
            if (!set.contains(question)) {
                set.add(question);
                ii += 1;
            }
            if (!set.contains(question1)) {
                set.add(question1);
                ii += 1;
            }
        }


        return set;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExaminerServiceImpl that = (ExaminerServiceImpl) o;
        return Objects.equals(javaQuestionService, that.javaQuestionService) && Objects.equals(mathQuestionService, that.mathQuestionService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(javaQuestionService, mathQuestionService);
    }
}
