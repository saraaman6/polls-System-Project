package com.example.project.controller;

import com.example.project.model.UserAnswer;
import com.example.project.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;

    @GetMapping("/{id}")
    public UserAnswer getAnswerById(@PathVariable Long id){
        return userAnswerService.getAnswerById(id);
    }

    @GetMapping("/all")
    public List<UserAnswer> getAllAnswers(){
        return userAnswerService.getAllAnswers();
    }

    @PostMapping("/create")
    public void createAnswer(@RequestBody UserAnswer answer){
        userAnswerService.createAnswer(answer);
    }

    @PutMapping("/update")
    public UserAnswer updateAnswer(@RequestBody UserAnswer answer){
        return userAnswerService.updateAnswer(answer);
    }

    @DeleteMapping("/user/{id}")
    public void deleteAnswersByUserId(@PathVariable Long id){
        userAnswerService.deleteAnswerByUserId(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserAnswer> getAnswersByUserId(@PathVariable Long userId) {
        return userAnswerService.getAnswersByUserId(userId);
    }


    @GetMapping("/user/{userId}/count")
    public long countAnswersByUser(@PathVariable Long userId) {
        return userAnswerService.countAnswersByUserId(userId);
    }

    @GetMapping("/question/{questionId}")
    public List<UserAnswer> getAnswersByQuestionId(@PathVariable Long questionId) {
        return userAnswerService.getAnswersByQuestionId(questionId);
    }

    @GetMapping("/question/{questionId}/count")
    public long countAnswersByQuestion(@PathVariable Long questionId) {
        return userAnswerService.countAnswersByQuestionId(questionId);
    }
}
