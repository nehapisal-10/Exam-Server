package com.Exam.ExamServer.service;

import com.Exam.ExamServer.model.exam.Question;
import com.Exam.ExamServer.model.exam.Quiz;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);

   // This method is intended to return a set of all questions available.
    public Set<Question> getQuestions();

    //This method retrieves a specific question by its unique identifier (questionId).
    public Question getQuestion(Long questionId);

    //This method fetches questions associated with a particular quiz.
    public Set<Question> getQuestionsOfQuiz(Quiz quiz);
    public void deleteQuestion(Long quesId);

}
