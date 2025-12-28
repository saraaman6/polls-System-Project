package com.example.project.service;
import com.example.project.model.User;


import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User>getUsersInfo();
    User updateUser(User user);
    void deleteUser(Long userId);


}
