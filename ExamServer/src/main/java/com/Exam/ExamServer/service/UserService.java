package com.Exam.ExamServer.service;

import com.Exam.ExamServer.model.User;
import com.Exam.ExamServer.model.UserRole;

import java.util.Set;

public interface UserService {
    //create user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    //get user by username
    public User getUser(String username);
    public Set<User> getUsers();
    public boolean deleteUser(Long userId);

}
