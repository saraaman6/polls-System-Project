package com.example.project.controller;

import com.example.project.model.Question;
import com.example.project.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polls")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id){
      return  questionService.getQuestionById(id);
    }

    @GetMapping("/all")
    public List<Question> getQuestion(){
       return questionService.getAllQuestions();
    };

    @PostMapping("/create")
    public void createQuestion(@RequestBody Question polls){
        questionService.createQuestion(polls);
    }

    @PutMapping("/update")
    public Question updateQuestion(@RequestBody Question polls){
        return questionService.updateQuestion(polls);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable Long id){

        questionService.deleteQuestion(id);
    }

}
