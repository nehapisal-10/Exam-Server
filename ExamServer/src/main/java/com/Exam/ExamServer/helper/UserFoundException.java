package com.Exam.ExamServer.helper;

public class UserFoundException extends Exception{
    public UserFoundException() {
        super("User with this username is already in the database !!");
    }
    public UserFoundException(String msg) {
        super(msg);
    }
}
