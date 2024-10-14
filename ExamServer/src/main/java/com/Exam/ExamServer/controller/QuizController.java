package com.Exam.ExamServer.controller;

import com.Exam.ExamServer.model.exam.Category;
import com.Exam.ExamServer.model.exam.Quiz;
import com.Exam.ExamServer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    private QuizService quizService;

    //add quizzes
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
        return ResponseEntity.ok( this.quizService.addQuiz(quiz));
    }
    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
        return ResponseEntity.ok( this.quizService.updateQuiz(quiz));
    }
    //get quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes(){
        return ResponseEntity.ok( this.quizService.getQuizzes());
    }
    //get singe quiz
    @GetMapping("/{qId}")
    public Quiz quiz(@PathVariable("qId") Long qId){
        return this.quizService.getQuiz(qId);
    }
    @DeleteMapping("/{qId}")
    public void delete(@PathVariable ("qId") Long qId){
        this.quizService.deleteQuiz(qId);
    }
    @GetMapping("/category/{cId}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cId") Long cId){
        Category category=new Category();
        category.setcId(cId);
        return this.quizService.getQuizzesOfCategory(category);
    }
    //get active quizzes
    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes(){
        return this.quizService.getActiveQuizzes();
    }
    //get active quizzes of category
    @GetMapping("/category/active/{cId}")
    public List<Quiz> getActiveQuizzes(@PathVariable("cId") Long cId){
        Category category=new Category();
        category.setcId(cId);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }
}
