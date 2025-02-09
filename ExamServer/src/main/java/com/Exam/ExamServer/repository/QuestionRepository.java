package com.Exam.ExamServer.repository;

import com.Exam.ExamServer.model.exam.Question;
import com.Exam.ExamServer.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
