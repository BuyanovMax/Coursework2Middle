package com.example.coursework2middle;


import com.example.coursework2middle.essences.JavaQuestionsRepository;
import com.example.coursework2middle.essences.MathQuestionsRepository;
import com.example.coursework2middle.essences.Question;
import com.example.coursework2middle.exceptions.QuestionNotFoundException;
import com.example.coursework2middle.services.JavaQuestionService;
import com.example.coursework2middle.services.MathQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathQuestionServiceTest {

    public static final String QUESTION1 = "Question111";
    public static final String QUESTION2 = "Question211";
    public static final String QUESTION3 = "Question311";
    public static final String QUESTION7 = "Question7";

    public static final String ANSWER4 = "Answer4";
    public static final String ANSWER5 = "Answer5";
    public static final String ANSWER6 = "Answer6";
    public static final Question NOTFOUNDQUESTION = new Question("Question50", "Answer50");
    public static final Question QUESTION4 = new Question(QUESTION1, ANSWER4);
    public static final Question QUESTION5 = new Question(QUESTION2, ANSWER5);
    public static final Question QUESTION6 = new Question(QUESTION3, ANSWER6);

    private MathQuestionsRepository mathQuestionsRepository;

    private MathQuestionService mathQuestionService;

    public static Stream<Arguments> findTestParams() {
      return Stream.of(
                Arguments.of(QUESTION4),
                Arguments.of(QUESTION5),
                Arguments.of(QUESTION6));
    }

    @BeforeEach
    public void beforeEach() {

        mathQuestionService = new MathQuestionService(new MathQuestionsRepository());

        mathQuestionService.add(QUESTION1, ANSWER4);
        mathQuestionService.add(QUESTION2, ANSWER5);
        mathQuestionService.add(QUESTION3, ANSWER6);


    }

    @Test
    public void addTest() {

        Question expected = new Question("asdf", "asdfgv");

        Question actual = mathQuestionService.add("asdf", "asdfgv");

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("findTestParams")
    public void findTest(Question question) {

        Question actual = mathQuestionService.find(question);

        assertEquals(question, actual);
    }

    @Test
    public void findNegativeTest() {
        QuestionNotFoundException exception = assertThrows(QuestionNotFoundException.class,
                () -> mathQuestionService.find(NOTFOUNDQUESTION));

        assertEquals("Вопрос не найден", exception.getMessage());

    }

    @Test
    public void removeTest() {
        Question expected = new Question(QUESTION2, ANSWER5);

        Question actual = mathQuestionService.remove(QUESTION5);

        assertEquals(expected, actual);
    }

    @Test
    public void removeNegativeTest() {
        assertThrows(QuestionNotFoundException.class, () -> mathQuestionService.remove(NOTFOUNDQUESTION));
    }

    @Test
    public void getAllTest() {

        List<Question> expected = new ArrayList<>();
        expected.add(QUESTION4);
        expected.add(QUESTION5);
        expected.add(QUESTION6);

        Collection<Question> actual = mathQuestionService.getAll();


        assertEquals(expected, actual);
    }

}
