package com.example.project.service;

import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public User getUserById(Long id) {
        User user = userRepository.getUserById(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not exist");
        }
        return user;
    }


    @Override
    public List<User>getUsersInfo() {
        return userRepository.getUsersInfo();
    }

    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);

    }

    @Override
    public User updateUser(User user) {
      return  userRepository.updateUser(user);

    }

    @Override
    public void deleteUser(Long id) {
     userRepository.deleteUser(id);
    }

}
