package com.Exam.ExamServer.service.impl;
import com.Exam.ExamServer.helper.UserFoundException;
import com.Exam.ExamServer.model.User;
import com.Exam.ExamServer.model.UserRole;;
import com.Exam.ExamServer.repository.RoleRepository;
import com.Exam.ExamServer.repository.UserRepository;
import com.Exam.ExamServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is Already there!");
            throw new UserFoundException();
        } else {
            //create user
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    //get user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public boolean deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
        return false;
    }
}
