package com.example.coursework2middle;


import com.example.coursework2middle.essences.Question;
import com.example.coursework2middle.exceptions.ChooseFewerQuestionsException;
import com.example.coursework2middle.services.ExaminerServiceImpl;
import com.example.coursework2middle.services.JavaQuestionService;
import com.example.coursework2middle.services.MathQuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;




    @Test
    public void getQuestionTest() {

        Question question = new Question("q1", "a1");
        Question question2 = new Question("q2", "a2");
        Question question3 = new Question("q3", "a3");
        Question question4 = new Question("q4", "a4");
        Question question5 = new Question("q5", "a5");

        Collection<Question> questions1 = Arrays.asList(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3"),
                new Question("q4", "a4"),
                new Question("q5", "a5"),
                new Question("q6", "a6")
        );

        Question q1 = new Question("q11", "a11");
        Question q2 = new Question("q22", "a22");
        Question q3 = new Question("q33", "a33");
        Question q4 = new Question("q44", "a44");
        Question q5 = new Question("q55", "a55");

        Collection<Question> questions2 = Arrays.asList(
                new Question("q11", "a11"),
                new Question("q22", "a22"),
                new Question("q33", "a33"),
                new Question("q44", "a44"),
                new Question("q55", "a55"),
                new Question("q66", "a66")
        );
        Mockito.when(javaQuestionService.getAll()).thenReturn(questions1);
        Mockito.when(mathQuestionService.getAll()).thenReturn(questions2);

        Mockito.when(javaQuestionService.getRandomQuestion())
                .thenReturn(question)
                .thenReturn(question2)
                .thenReturn(question3)
                .thenReturn(question4)
                .thenReturn(question5);

        Mockito.when(mathQuestionService.getRandomQuestion())
                .thenReturn(q1)
                .thenReturn(q2)
                .thenReturn(q3)
                .thenReturn(q4)
                .thenReturn(q5);

        Collection<Question> actual = examinerServiceImpl.getQuestions(10);

        Assertions.assertThat(actual.size()).isEqualTo(10);
        Assertions.assertThat(actual).contains(
                question, question2, question3, question4, question5,q1,q2,q3,q4,q5
        );


    }
    @Test
    public void getQuestionNegativeTest() {
        Collection<Question> questions1 = Arrays.asList(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3"),
                new Question("q4", "a4"),
                new Question("q5", "a5"),
                new Question("q6", "a6")
        );
        Collection<Question> questions2 = Arrays.asList(
                new Question("q11", "a11"),
                new Question("q22", "a22"),
                new Question("q33", "a33"),
                new Question("q44", "a44"),
                new Question("q55", "a55"),
                new Question("q66", "a66")
        );
        Mockito.when(javaQuestionService.getAll()).thenReturn(questions1);
        Mockito.when(mathQuestionService.getAll()).thenReturn(questions2);


        org.junit.jupiter.api.Assertions.assertThrows(ChooseFewerQuestionsException.class, () -> examinerServiceImpl.getQuestions(15));
    }

}
