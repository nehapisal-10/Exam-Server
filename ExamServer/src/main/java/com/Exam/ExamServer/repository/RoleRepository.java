package com.Exam.ExamServer.repository;

import com.Exam.ExamServer.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
