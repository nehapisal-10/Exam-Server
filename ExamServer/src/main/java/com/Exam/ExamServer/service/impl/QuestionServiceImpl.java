package com.Exam.ExamServer.service.impl;

import com.Exam.ExamServer.model.exam.Question;
import com.Exam.ExamServer.model.exam.Quiz;
import com.Exam.ExamServer.repository.QuestionRepository;
import com.Exam.ExamServer.service.QuestionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    @Transactional
    public void deleteQuestion(Long quesId) {
        Question question=new Question();
        question.setqId(quesId);
        this.questionRepository.delete(question);
    }
}
