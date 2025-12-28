package com.example.project.controller;

import com.example.project.client.UserClient;
import com.example.project.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserClientController {

  @Autowired
  UserClient userClient;

  @GetMapping("/users/{id}")
  public UserDto getUserById(@PathVariable Long id) {
    return userClient.getUserById(id);
  }

  @GetMapping("/users/all")
  public List<UserDto> getAllUsers() {
    return userClient.getAllUsers();
  }

  @DeleteMapping("/users/delete/{id}")
  public void deleteAnswerById(@PathVariable Long id){
    userClient.deleteUser(id);
  }

}
