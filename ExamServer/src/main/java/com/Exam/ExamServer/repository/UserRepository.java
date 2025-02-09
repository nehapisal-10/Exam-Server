package com.Exam.ExamServer.repository;

import com.Exam.ExamServer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}
