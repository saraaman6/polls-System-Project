package com.example.project.service;

import com.example.project.model.Question;
import com.example.project.model.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatsServiceImpl {

    @Autowired
    private UserAnswerService userAnswerService;

    @Autowired
    private QuestionService questionService;


    public Map<String, Long> getAnswerStats(Long questionId) {
        List<UserAnswer> answers = userAnswerService.getAnswersByQuestionId(questionId);
        Map<String, Long> stats = new HashMap<>();
        stats.put("A", 0L);
        stats.put("B", 0L);
        stats.put("C", 0L);
        stats.put("D", 0L);

        for (UserAnswer answer : answers) {
            String option = answer.getAnswerOption().toUpperCase(); // נהפוך ל-uppercase כדי להשוות
            switch (option) {
                case "A":
                    stats.put("A", stats.get("A") + 1);
                    break;
                case "B":
                    stats.put("B", stats.get("B") + 1);
                    break;
                case "C":
                    stats.put("C", stats.get("C") + 1);
                    break;
                case "D":
                    stats.put("D", stats.get("D") + 1);
                    break;
                default:
                    break;
            }
        }

        return stats;
    }




    public Map<Long, Map<String, Long>> getAllQuestionsStats() {
        List<Question> questions = questionService.getAllQuestions();
        Map<Long, Map<String, Long>> allStats = new HashMap<>();
        for (Question question : questions) {
            allStats.put(question.getQuestion_id(), getAnswerStats(question.getQuestion_id()));
        }
        return allStats;
    }


    public List<UserAnswer> getUserAnswers(Long userId) {
        return userAnswerService.getAnswersByUserId(userId);
    }


    public Long getUserAnsweredCount(Long userId) {
        return userAnswerService.countAnswersByUserId(userId);
    }

    public Long getTotalAnswers(Long questionId) {
        return userAnswerService.countAnswersByQuestionId(questionId);
    }
}
