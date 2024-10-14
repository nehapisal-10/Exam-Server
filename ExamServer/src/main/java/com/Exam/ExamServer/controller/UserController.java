package com.Exam.ExamServer.controller;

import com.Exam.ExamServer.helper.UserFoundException;
import com.Exam.ExamServer.model.Role;
import com.Exam.ExamServer.model.User;
import com.Exam.ExamServer.model.UserRole;
import com.Exam.ExamServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        //encoding password with BcryptEncoder
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(20L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return userService.createUser(user,roles);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(this.userService.getUsers());
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable ("username") String username){
        return this.userService.getUser(username);
    }

    //delete user by userId
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable ("userId") Long userId){
        this.userService.deleteUser(userId);
    }
    @GetMapping("")
    public String greet(){
        return "Welcome to Online Exam Portal";
    }
    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
