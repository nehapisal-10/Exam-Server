package com.Exam.ExamServer.repository;

import com.Exam.ExamServer.model.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
