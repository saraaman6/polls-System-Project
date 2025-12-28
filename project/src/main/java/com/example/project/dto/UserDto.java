package com.example.project.dto;

public class UserDto {
    private Long userId;
    private String first_name;

    public UserDto() {
    }

    public UserDto(Long userId, String first_name) {
        this.userId = userId;
        this.first_name = first_name;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
