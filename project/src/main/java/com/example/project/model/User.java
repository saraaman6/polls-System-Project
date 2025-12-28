package com.example.project.model;

import java.time.LocalDate;

public class User {
    private Long userId;
    private String first_name;
    private String last_name;
    private String email;
    private Integer age;
    private String address;
    private LocalDate joining_date;

    public User() {
    }

    public User(Long userId, String first_name, String last_name, String email, Integer age, String address, LocalDate joining_date) {
        this.userId = userId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.joining_date = joining_date;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getJoining_date() {
        return joining_date;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJoining_date(LocalDate joining_date) {
        this.joining_date = joining_date;
    }
}
