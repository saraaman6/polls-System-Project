package com.example.project.controller;

import com.example.project.model.UserAnswer;
import com.example.project.service.StatsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsServiceImpl statsService;


    @GetMapping("/question/{questionId}")
    public Map<String, Long> getAnswerStats(@PathVariable Long questionId) {
        return statsService.getAnswerStats(questionId);
    }


    @GetMapping("/all")
    public Map<Long, Map<String, Long>> getAllQuestionsStats() {
        return statsService.getAllQuestionsStats();
    }


    @GetMapping("/user/{userId}/answers")
    public List<UserAnswer> getUserAnswers(@PathVariable Long userId) {
        return statsService.getUserAnswers(userId);
    }


    @GetMapping("/user/{userId}/count")
    public long getUserAnsweredCount(@PathVariable Long userId) {
        return statsService.getUserAnsweredCount(userId);
    }

    @GetMapping("/question/{questionId}/total")
    public long getTotalAnswers(@PathVariable Long questionId) {
        return statsService.getTotalAnswers(questionId);
    }
}

