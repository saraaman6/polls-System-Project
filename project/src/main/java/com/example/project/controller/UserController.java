package com.example.project.controller;
import com.example.project.model.User;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
       return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<User> getUsersInfo(){
      return userService.getUsersInfo();

    };

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
     public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
