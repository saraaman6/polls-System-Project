package com.example.project.model;

public class UserAnswer {
    private Long id;
    private Long userId;
    private Long questionId;
    private String answerOption;

    public UserAnswer() {
    }

    public UserAnswer(Long id, Long userId, Long questionId, String answerOption) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.answerOption = answerOption;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getAnswerOption() {
        return answerOption;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setAnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }
}
